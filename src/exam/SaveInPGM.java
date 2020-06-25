package exam;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class SaveInPGM extends Application {
    public void start(final Stage stage) {
        stage.setTitle("Choose Image");

        FileChooser fileChooser = new FileChooser();

        StackPane stac = new StackPane();
        Label label = new Label();
        Button button = new Button("Choose Image");
        button.setTranslateY(150);

        button.setOnAction((final ActionEvent e) -> {
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {

                Image img = new Image(file.toURI().toString());

                BackgroundSize backgroundSize = new BackgroundSize(30, 30, true, true, true, false);
                BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
                stac.setBackground(new Background(backgroundImage));


                label.setText(file.getPath());
                label.setTranslateY(120);
                label.setTextFill(Color.RED);
            }
        });


        stac.getChildren().addAll(button, label);
        stage.setScene(new Scene(stac, 400, 400));
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}