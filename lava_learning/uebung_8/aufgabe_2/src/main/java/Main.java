import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage stage) {
    VBox mainBox = new VBox();
    final int width = 640;
    final int height = 480;
    Scene scene = new Scene(mainBox, width, height);

    Canvas canvas = new Canvas(width, height);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    // Set stroke color
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(1);

    // Set fill color
    gc.setFill(Color.RED);

    int body_top_left_x = width / 3;
    int body_top_left_y = height / 5 * 2;
    int body_top_right_x = width / 3 * 2;
    int body_top_right_y = height / 5 * 2;
    int body_bot_left_x = width / 3;
    int body_bot_left_y = height / 5 * 4;
    int body_bot_right_x = width / 3 * 2;
    int body_bot_right_y = height / 5 * 4;
    int tip_x = width / 2;
    int tip_y = height / 5;

    double[] xPoints = { body_bot_left_x, body_top_left_x, tip_x, body_top_right_x, body_bot_right_x, body_bot_left_x,
        body_bot_right_x, body_top_left_x, body_bot_right_x };
    double[] yPoints = { body_bot_left_y, body_top_left_y, tip_y, body_top_right_y, body_bot_right_y, body_bot_left_y,
        body_top_right_y, body_top_left_y, body_bot_right_y };
    int nPoints = xPoints.length;

    double[] xPoints_FILL = {
        body_bot_left_x,
        body_top_left_x,
        tip_x,
        body_top_right_x,
        body_bot_right_x
    };
    double[] yPoints_FILL = {
        body_bot_left_y,
        body_top_left_y,
        tip_y,
        body_top_right_y,
        body_bot_right_y
    };
    int nPoints_FILL = xPoints_FILL.length;

    // Fill the polygon first
    gc.fillPolygon(xPoints_FILL, yPoints_FILL, nPoints_FILL);

    // Then stroke the outline
    gc.strokePolygon(xPoints, yPoints, nPoints);

    mainBox.getChildren().add(canvas);

    stage.setScene(scene);
    stage.setTitle("Red House Example");
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
