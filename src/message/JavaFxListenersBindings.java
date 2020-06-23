package message;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxListenersBindings extends Application {

    private TextField input;
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private Label label7;




    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setScene(new Scene(initInterface()));
        primaryStage.show();
        initInteraction();
    }

    private VBox initInterface() {
        input = new TextField("Text");
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();

        VBox vBox = new VBox(input, label1, label2, label3, label4, label5, label6);
        vBox.setStyle("-fx-font-size: 26px");
        return vBox;
    }

    private void initInteraction() {
        input.textProperty().addListener(
                o -> {
                    String newText = input.getText();
                    label1.setText(newText);
                }
        );
        label1.setText(input.getText());

        input.textProperty().addListener(
                (o, oldValue, newValue) -> label2.setText(newValue)
        );
        label2.setText(input.getText());

        label3.textProperty().bind(input.textProperty());

        input.textProperty().addListener( o -> {
            String newText = input.getText() + "!";
            label4.setText(newText);
        });

        label5.textProperty().bind(
                input.textProperty()
                        .concat("!")
        );

        label6.textProperty().bind(
                Bindings.concat(
                        "!",
                        input.textProperty()
                )
        );

        label7.textProperty().bind(
                Bindings.createStringBinding(
                        () -> input.getText().toUpperCase(),
                        input.textProperty()
                )
        );
    }
}
