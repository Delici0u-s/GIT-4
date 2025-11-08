package frontend.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import frontend.NavigationButton;
import frontend.Navigator;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.Route;
import services.MealPlannerService;

public class PantryPage extends Page {
  private MealPlannerService mealPlanner;

  public PantryPage(Navigator navigator, MealPlannerService mealPlanner) {
    super(navigator);
    this.mealPlanner = mealPlanner;
  }

  @Override
  public Parent getView() {
    VBox root = new VBox(15);
    root.setPadding(new Insets(20));

    Label titleLabel = new Label("PantryPage");
    titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

    return root;
  }
}
