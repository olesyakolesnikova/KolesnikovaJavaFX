package message;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;


public class ColorCR extends Application{
    public static void main(String[] args) { Application.launch(args); }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(initInterface()); //, 300, 150);
        stage.setScene(scene);
        stage.setTitle("VBox in JavaFX");
        stage.show();
    }

    private HBox initInterface() {
        HBox root = new HBox();
        VBox left = new VBox();
        Label slid = new Label("Радиус круга");
        Label colorPicker1 = new Label("Цвет круга");
        Label colorPicker2 = new Label("Цвет фона");
        StackPane right = new StackPane();
        Circle circle = new Circle(50);
        ColorPicker circleColor = new ColorPicker();
        ColorPicker backgroundColor = new ColorPicker();
        Slider slider = new Slider(0, 100, 50);
        root.getChildren().addAll(left,right);
        left.getChildren().addAll(slid, slider, colorPicker1, circleColor, colorPicker2, backgroundColor);
        right.getChildren().addAll(circle);

        HBox.setHgrow(right, Priority.ALWAYS);
        VBox.setVgrow(left,Priority.ALWAYS);



        circleColor.setOnAction(e -> circle.setFill(circleColor.getValue()));
        circle.radiusProperty().bind(slider.valueProperty());
        backgroundColor.setOnAction(e -> right.setBackground(new Background(new BackgroundFill(backgroundColor.getValue(), null, null))));


        return root;
    }
}
