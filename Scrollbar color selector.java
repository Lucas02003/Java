
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorSelector extends Application {
    private Label colorLabel;

    @Override
    public void start(Stage primaryStage) {
        colorLabel = new Label("Sample Text");
        colorLabel.setTextFill(Color.rgb(0, 0, 0, 1)); // Initial color

        ScrollBar redScroll = createScrollBar(0, 255, 0);
        ScrollBar greenScroll = createScrollBar(0, 255, 0);
        ScrollBar blueScroll = createScrollBar(0, 255, 0);
        ScrollBar opacityScroll = createScrollBar(0, 100, 100);

        VBox vbox = new VBox(10, redScroll, greenScroll, blueScroll, opacityScroll, colorLabel);
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setTitle("Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ScrollBar createScrollBar(int min, int max, int initial) {
        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setMin(min);
        scrollBar.setMax(max);
        scrollBar.setValue(initial);
        scrollBar.setPrefWidth(250);

        scrollBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateColor();
        });

        return scrollBar;
    }

    private void updateColor() {
        int red = (int) ((ScrollBar) ((VBox) colorLabel.getParent()).getChildren().get(0)).getValue();
        int green = (int) ((ScrollBar) ((VBox) colorLabel.getParent()).getChildren().get(1)).getValue();
        int blue = (int) ((ScrollBar) ((VBox) colorLabel.getParent()).getChildren().get(2)).getValue();
        double opacity = ((ScrollBar) ((VBox) colorLabel.getParent()).getChildren().get(3)).getValue() / 100.0;

        colorLabel.setTextFill(Color.rgb(red, green, blue, opacity));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
