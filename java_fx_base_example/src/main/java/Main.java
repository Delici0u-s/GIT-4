import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage stage) {
    VBox mainBox = new VBox();
    Scene scene = new Scene(mainBox, 640, 480);

    mainBox.getChildren().addAll(new Label("\t\tHI\n\n"), new Label("\t\tBYE"));
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }

}