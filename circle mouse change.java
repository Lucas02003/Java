import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleColorChange extends Application {

    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(100, Color.WHITE);
        circle.setCenterX(150);
        circle.setCenterY(150);
        
        // Event handler for mouse pressed
        circle.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            circle.setFill(Color.BLACK);
        });

        // Event handler for mouse released
        circle.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            circle.setFill(Color.WHITE);
        });

        Pane root = new Pane(circle);
        Scene scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle("Circle Color Change");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}