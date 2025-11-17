import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage stage) {
    final int width = 1280;
    final int height = 720;
    final Canvas canvas = new Canvas(width, height);
    final GraphicsContext gc = canvas.getGraphicsContext2D();

    gc.setFill(Color.BLACK);
    gc.fillRect(0, 0, width, height / 3);

    gc.setFill(Color.RED);
    gc.fillRect(0, height / 3, width, height / 3);

    gc.setFill(Color.GOLD);
    gc.fillRect(0, 2 * height / 3, width, height / 3);

    final Group root = new Group(canvas);
    final Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }

}