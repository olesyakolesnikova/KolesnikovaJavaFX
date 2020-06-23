package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class JavaFxHello extends Application {

    @Override
    public void start(Stage mainStage){
        mainStage.setTitle("...");
        mainStage.setScene(new Scene(
                new Button("Press me"),
                640,
                480
        ));
        mainStage.show();

    }
}
