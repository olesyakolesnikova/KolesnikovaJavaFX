package message;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Texting extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(initInterface()); //, 300, 150);
        stage.setScene(scene);
        stage.setTitle("VBox in JavaFX");
        stage.show();
    }
    private HBox initInterface() {
        HBox root = new HBox();
        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();
        root.getChildren().addAll(vbox1,vbox2);
        TextArea textarea = new TextArea();
        HBox hbox = new HBox();
        vbox1.getChildren().addAll(textarea,hbox);
        TextField tf = new TextField();
        Button butt = new Button("Отправить");
        hbox.getChildren().addAll(tf,butt);
        Label label = new Label("Контакты");
        ListView list = new ListView();
        vbox2.getChildren().addAll(label,list);

        HBox.setHgrow(vbox1, Priority.ALWAYS);
        VBox.setVgrow(textarea, Priority.ALWAYS);
        HBox.setHgrow(tf,Priority.ALWAYS);
        VBox.setVgrow(list, Priority.ALWAYS);


        return root;
    }
}
