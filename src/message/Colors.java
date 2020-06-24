package message;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Colors extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(initInterface()); //, 300, 150);
        stage.setScene(scene);
        stage.setTitle("VBox in JavaFX");
        stage.show();
    }

    private VBox initInterface() {
        VBox window = new VBox();
        HBox up = new HBox();
        HBox down = new HBox();
        HBox centre = new HBox();
        ImageView img1 = new ImageView();
        ImageView img2 = new ImageView();
        ImageView img3 = new ImageView();
        ImageView img4 = new ImageView();
        ImageView img5 = new ImageView();


        window.getChildren().addAll(up, centre, down);
        centre.getChildren().addAll(img4, img5);
        up.getChildren().addAll(img1, img2, img3);


        WritableImage writImage1 = new WritableImage(120,100);
        PixelWriter pw1 = writImage1.getPixelWriter();
        for (int x = 0; x < 120; x++){
            for (int y = 0; y < 100; y++)
                pw1.setColor(x, y, Color.GREEN);
        }
        img1.setImage(writImage1);


        WritableImage writImage2 = new WritableImage(256,256);
        PixelWriter pw2 = writImage2.getPixelWriter();
        for (int x = 0; x < 255; x++){
            for (int y = 0; y < 255; y++)
                pw2.setColor(x, y, Color.rgb(0,x,y));
        }
        img2.setImage(writImage2);

        WritableImage writImage3 = new WritableImage(256,256);
        PixelWriter pw3 = writImage3.getPixelWriter();
        for (int x = 0; x < 255; x++){
            for (int y = 0; y < 255; y++)
                pw3.setColor(x, y, Color.rgb(x,x,y));
        }
        img3.setImage(writImage3);

        WritableImage writImage4 = new WritableImage(360,100);
        PixelWriter pw4 = writImage4.getPixelWriter();
        for (int x = 0; x < 360; x++){
            for (int y = 0; y < 100; y++)
                pw4.setColor(x, y, Color.hsb(x,y/99,1));
        }
        img4.setImage(writImage4);

        WritableImage writImage5 = new WritableImage(360,140);
        PixelWriter pw5 = writImage5.getPixelWriter();
        for (int x = 0; x < 360; x++){
            for (int y = 0; y < 140; y++)
                pw5.setColor(x, y, LCH.colorFromLCH(80,y,x));
        }
        img5.setImage(writImage5);

        Image image6 = new Image("https://www.meme-arsenal.com/memes/5edd6aa200457b998a8065af3197f2ef.jpg");

        ImageView img6 = new ImageView(image6);
        ImageView img7 = new ImageView(image6);

        img6.setFitHeight(256);
        img6.setFitWidth(256);
        img7.setFitHeight(256);
        img7.setFitWidth(256);



        PixelReader pr = image6.getPixelReader();
        WritableImage bw = new WritableImage(256,256);
        PixelWriter pixelWriter = bw.getPixelWriter();
        for (int x = 0; x < 256; x++) {
            for (int y = 0; y < 256; y++) {
                int pixel = pr.getArgb(x, y);

                int red = ((pixel >> 16) & 0xff);
                int green = ((pixel >> 8) & 0xff);
                int blue = (pixel & 0xff);

                int grlv = (int) (0.2126 * (double)red + 0.7152 * (double)green + 0.0722 * (double)blue);
                grlv = 255 - grlv;
                int gray = (grlv << 16) + (grlv << 8) + grlv;

                pixelWriter.setArgb(x, y, -gray);
            }
        }
        img7.setImage(bw);

        down.getChildren().addAll(img6, img7);



        return window;


    }
}
