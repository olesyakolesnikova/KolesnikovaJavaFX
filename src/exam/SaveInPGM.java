package exam;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

public class SaveInPGM extends Application {
    public void start(Stage stage) {
        stage.setTitle("Choose Image");

        FileChooser fileChooser = new FileChooser();

        StackPane stac = new StackPane();
        Label label = new Label();
        Button button = new Button("Choose Image");
        button.setTranslateY(150);

        button.setOnAction((ActionEvent e) -> {
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {

                Image img = new Image(file.toURI().toString());

                BackgroundSize backgroundSize = new BackgroundSize(30, 30, true, true, true, false);
                BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
                stac.setBackground(new Background(backgroundImage));


                label.setText(file.getPath());
                label.setTranslateY(120);
                label.setTextFill(Color.RED);

                try{
                    savePGM(file.getAbsolutePath());
                } catch (IOException a) {
                    a.printStackTrace();
                }
            }
        });


        stac.getChildren().addAll(button, label);
        stage.setScene(new Scene(stac, 400, 400));
        stage.show();
    }

    public void savePGM(String filename) throws IOException {
        Image img = new Image("filename");

        PixelReader pixelReader = img.getPixelReader();

        int w = (int) img.getWidth();
        int h = (int) img.getHeight();
        PGMImage pgm = new PGMImage(w, h);


        for (int x = 0; x < w; x++) {
            for (int y = 0; x < h; y++) {
                Color color = pixelReader.getColor(x, y);
                double pgmCol = color.getRed() * 0.2126 + color.getGreen() * 0.0722 + color.getBlue() * 0.7152;
                double pgmCol2 = pgmCol * 255;
                pgm.setPixel(x, y, (int)pgmCol2);
            }
        }
        pgm.saveTo("D:\\Lesya\\Desktop\\progsredy\\osnovy_programmirovanya\\4sem\\src\\exam\\newPic.pgm");
    }

    public static void main(String[] args) {
        launch(args);
    }
}