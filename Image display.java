import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ImageGridPane extends  Application{

@override
public void start(Stage primaryStage) {

GridPane gridPane = new GridPane();


Image image1 = new Image("file:path/to/image1.jpg");
Image image2 = new Image("file:path/to/image2.jpg");
Image image3 = new Image("file:path/to/image3.jpg");
Image image4 = new Image("file:path/to/image4.jpg");


ImageView imageView1 = new ImageView(image1);
ImageView imageView2 = new ImageView(image2);
ImageView imageView3 = new ImageView(image3);
ImageView imageView4 = new ImageView(image4);



gridPane.add(imageView1, 0, 0); // Column 0, Row 0
gridPane.add(imageView2, 1, 0); // Column 1, Row 0
gridPane.add(imageView3, 0, 1); // Column 0, Row 1
gridPane.add(imageView4, 1, 1); // Column 1, Row 1


Scene scene = new Scene(gridPane, 400, 400);
primaryStage.setTitle("Image Grid Pane");
primaryStage.setScene(scene);
primaryStage.show();
}

public static void main(String[] args) {
launch(args);
}




























}