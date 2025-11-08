package frontend.pages;

import frontend.NavigationButton;
import frontend.Navigator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.PantryItem;
import models.Route;
import services.MealPlannerService;

public class PantryPage extends Page {
  private final MealPlannerService mealPlanner;
  private int selectedIndex = -1;
  private final VBox itemInfoBox = new VBox(10);

  public PantryPage(Navigator navigator, MealPlannerService mealPlanner) {
    super(navigator);
    this.mealPlanner = mealPlanner;
  }

  @Override
  public Parent getView() {
    VBox root = new VBox(15);
    root.setPadding(new Insets(20));

    // Pantry box
    VBox pantryBox = createPantryBox();

    // Item details box
    VBox itemDetailsBox = createItemDetailsBox();

    // Main content
    HBox mainContent = new HBox(10, pantryBox, itemDetailsBox);
    mainContent.setPrefHeight(600);

    // Buttons
    HBox buttonBox = createButtonBox();

    root.getChildren().addAll(mainContent, buttonBox);
    return root;
  }

  private VBox createPantryBox() {
    VBox box = new VBox(10);
    Label label = new Label("Speisekammer:");
    label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

    ObservableList<String> itemNames = FXCollections.observableArrayList(
        mealPlanner.getPantry().stream()
            .map(PantryItem::getName)
            .toList());

    ListView<String> listView = new ListView<>(itemNames);
    listView.getSelectionModel().selectedIndexProperty().addListener((obs, oldVal, newVal) -> {
      selectedIndex = (newVal == null) ? -1 : newVal.intValue();
      updateItemDetailsBox(itemInfoBox);
    });

    box.getChildren().addAll(label, listView);
    return box;
  }

  private VBox createItemDetailsBox() {
    VBox box = new VBox(10);
    Label label = new Label("Lebensmitteldetails:");
    label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

    updateItemDetailsBox(itemInfoBox);

    box.getChildren().addAll(label, itemInfoBox);
    return box;
  }

  private HBox createButtonBox() {
    HBox box = new HBox(10);
    box.setAlignment(Pos.CENTER);

    Button addButton = new NavigationButton("Lebensmittel hinzufügen", Route.ADD_GROCERY, navigator);
    Button homeButton = new NavigationButton("Zurück zum Hauptmenü", Route.MAIN, navigator);

    box.getChildren().addAll(addButton, homeButton);
    return box;
  }

  private void updateItemDetailsBox(VBox itemInfo) {
    itemInfo.getChildren().clear();
    if (selectedIndex == -1) {
      itemInfo.getChildren().add(new Label("No item selected"));
    } else {
      String details = mealPlanner.getPantry().get(selectedIndex).getDetails(locale);
      itemInfo.getChildren().add(new Label(details));
    }
  }
}

// public class PantryPage extends Page {
// private MealPlannerService mealPlanner;
// private int plebensmittelIdx;

// public PantryPage(Navigator navigator, MealPlannerService mealPlanner) {
// super(navigator);
// this.mealPlanner = mealPlanner;
// }

// @Override
// public Parent getView() {
// VBox root = new VBox(15);
// root.setPadding(new Insets(20));

// /* speisekammer box */
// VBox SpeisekammerBox = new VBox(10);
// Label SpeisekammerBoxLabel = new Label("Speisekammer:");
// SpeisekammerBoxLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

// ObservableList<String> names = FXCollections.observableArrayList();
// for (PantryItem i : mealPlanner.getPantry()) {
// names.add(i.getName());
// }
// ListView<String> LebensmittelList = new ListView<>(names);

// SpeisekammerBox.getChildren().addAll(SpeisekammerBoxLabel, LebensmittelList);

// /* lebensmittel box */
// VBox LebensmittenInfoBox = new VBox(10);
// Label LebensmittenInfoBoxLabel = new Label("Lebensmitteldetails:");
// LebensmittenInfoBoxLabel.setStyle("-fx-font-size: 18px; -fx-font-weight:
// bold;");

// VBox itemInfo = new VBox(10);
// updateLebensmittelInfoBox(itemInfo);

// LebensmittelList.getSelectionModel().selectedIndexProperty().addListener((obs,
// oldVal, newVal) -> {
// this.plebensmittelIdx = (newVal == null) ? -1 : newVal.intValue();
// updateLebensmittelInfoBox(itemInfo);
// });

// LebensmittenInfoBox.getChildren().addAll(LebensmittenInfoBoxLabel, itemInfo);

// /* mainpage consisting of speisekammer and details */
// HBox siteMain = new HBox(10);
// siteMain.setPrefHeight(600);
// siteMain.getChildren().addAll(SpeisekammerBox, LebensmittenInfoBox);

// /* buttons at bottom */
// HBox buttonBox = new HBox(10);
// buttonBox.setAlignment(Pos.CENTER);
// Button addLebensmittel = new NavigationButton("Lebensmittel hinzufügen",
// Route.ADD_GROCERY, navigator);
// Button homeButton = new NavigationButton("Zurück zum Hauptmenü", Route.MAIN,
// navigator);
// buttonBox.getChildren().addAll(addLebensmittel, homeButton);

// root.getChildren().addAll(siteMain, buttonBox);

// return root;
// }

// private void updateLebensmittelInfoBox(VBox itemInfo) {
// itemInfo.getChildren().clear();
// if (this.plebensmittelIdx == -1) {
// itemInfo.getChildren().add(new Label("No item selected"));
// } else {
// Label sel = new
// Label(mealPlanner.getPantry().get(this.plebensmittelIdx).getDetails(locale));
// itemInfo.getChildren().add(sel);
// }
// }
// }

// bevor ich wusste das es getPantry gibt :(
// package frontend.pages;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;

// import frontend.NavigationButton;
// import frontend.Navigator;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Parent;
// import javafx.scene.control.Button;
// import javafx.scene.control.ButtonBar;
// import javafx.scene.control.ButtonType;
// import javafx.scene.control.ChoiceBox;
// import javafx.scene.control.Dialog;
// import javafx.scene.control.Label;
// import javafx.scene.control.ListView;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
// import models.Category;
// import models.PantryItem;
// import models.Route;
// import models.Unit;
// import services.MealPlannerService;

// public class PantryPage extends Page {
// private MealPlannerService mealPlanner;
// protected List<PantryItem> plebensmittel;
// private int plebensmittelIdx;

// public PantryPage(Navigator navigator, MealPlannerService mealPlanner) {
// super(navigator);
// this.mealPlanner = mealPlanner;
// plebensmittel = new ArrayList<>();
// plebensmittel.add(new PantryItem(
// "Milk",
// Unit.L,
// 1.0,
// Category.DAIRY,
// LocalDate.now().minusDays(2),
// LocalDate.now().plusDays(5),
// "Müller",
// 1.19));

// plebensmittel.add(new PantryItem(
// "Spaghetti",
// Unit.G,
// 500,
// Category.STARCH,
// LocalDate.now().minusDays(10),
// LocalDate.now().plusMonths(24),
// "Barilla",
// 0.99));

// plebensmittel.add(new PantryItem(
// "Chicken Breast",
// Unit.KG,
// 1.2,
// Category.MEAT,
// LocalDate.now().minusDays(1),
// LocalDate.now().plusDays(3),
// "Wiesenhof",
// 6.49));

// plebensmittel.add(new PantryItem(
// "Apples",
// Unit.KG,
// 2.0,
// Category.VEGETABLE,
// LocalDate.now().minusDays(4),
// LocalDate.now().plusDays(10),
// "BioFarm",
// 3.79));

// plebensmittel.add(new PantryItem(
// "Tomato Sauce",
// Unit.ML,
// 350,
// Category.FRUIT,
// LocalDate.now().minusMonths(1),
// LocalDate.now().plusMonths(18),
// "Cirio",
// 1.49));

// plebensmittel.add(new PantryItem(
// "Rice",
// Unit.KG,
// 1.0,
// Category.STARCH,
// LocalDate.now().minusWeeks(2),
// LocalDate.now().plusYears(2),
// "Uncle Ben’s",
// 2.49));

// }

// @Override
// public Parent getView() {
// VBox root = new VBox(15);
// root.setPadding(new Insets(20));

// /* speisekammer box */
// VBox SpeisekammerBox = new VBox(10);
// Label SpeisekammerBoxLabel = new Label("Speisekammer:");
// SpeisekammerBoxLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
// mealPlanner.getPantry().

// ObservableList<String> names = FXCollections.observableArrayList();
// for (PantryItem i : plebensmittel) {
// names.add(i.getName());
// }
// ListView<String> LebensmittelList = new ListView<String>(names);

// SpeisekammerBox.getChildren().addAll(SpeisekammerBoxLabel, LebensmittelList);

// /* lebensmittel box */
// VBox LebensmittenInfoBox = new VBox(10);
// Label LebensmittenInfoBoxLabel = new Label("Lebensmitteldetails:");
// LebensmittenInfoBoxLabel.setStyle("-fx-font-size: 18px; -fx-font-weight:
// bold;");

// VBox itemInfo = new VBox(10);
// itemInfo.getChildren().add(new Label("No item selected"));

// LebensmittelList.getSelectionModel().selectedIndexProperty().addListener((obs,
// oldVal, newVal) -> {
// this.plebensmittelIdx = (newVal == null) ? -1 : newVal.intValue();
// updateLebensmittelInfoBox(itemInfo);
// });

// LebensmittenInfoBox.getChildren().addAll(LebensmittenInfoBoxLabel, itemInfo);

// /* mainpage consisting of speisekammer and details */
// HBox siteMain = new HBox(10);
// siteMain.setPrefHeight(600);
// siteMain.getChildren().addAll(SpeisekammerBox, LebensmittenInfoBox);

// /* buttons at bottom */
// HBox buttonBox = new HBox(10);
// buttonBox.setAlignment(Pos.CENTER);
// Button addLebensmittel = new Button("Lebensmittel hinzufügen");

// addLebensmittel.setOnAction(e -> {
// // input Dialog
// Dialog<PantryItem> dialog = new Dialog<>();
// dialog.setTitle("Neues Lebensmittel hinzufügen");
// dialog.setHeaderText("Fülle die Angaben aus:");

// // Set buttons
// ButtonType addButtonType = new ButtonType("Hinzufügen",
// ButtonBar.ButtonData.OK_DONE);
// dialog.getDialogPane().getButtonTypes().addAll(addButtonType,
// ButtonType.CANCEL);

// VBox Names = new VBox(18);
// VBox InputFields = new VBox(10);

// Names.getChildren().addAll(
// new Label("Name:"),
// new Label("Menge:"),
// new Label("Einheit:"),
// new Label("Kategorie:"),
// new Label("Marke:"),
// new Label("Preis (€):"),
// new Label("Kaufdatum (dd.MM.yyyy):"),
// new Label("Verfallsdatum (dd.MM.yyyy):"));

// TextField nameField = new TextField("Lebensmittel");
// TextField amountField = new TextField("0");
// ChoiceBox<Unit> unitBox = new
// ChoiceBox<>(FXCollections.observableArrayList(Unit.values()));
// unitBox.setValue(Unit.KG);
// ChoiceBox<Category> categoryBox = new
// ChoiceBox<>(FXCollections.observableArrayList(Category.values()));
// categoryBox.setValue(Category.STARCH);
// TextField brandField = new TextField("Marke");
// TextField priceField = new TextField("0.0");
// TextField purchaseField = new TextField(
// LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")));
// TextField expField = new TextField(
// LocalDate.now().plusDays(14).format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")));

// InputFields.getChildren().addAll(nameField,
// amountField,
// unitBox,
// categoryBox,
// brandField,
// priceField,
// purchaseField,
// expField);

// HBox content = new HBox(10);
// content.getChildren().addAll(Names, InputFields);
// dialog.getDialogPane().setContent(content);

// // Convert result to PantryItem when OK is clicked
// dialog.setResultConverter(dialogButton -> {
// if (dialogButton == addButtonType) {
// try {
// String name = nameField.getText();
// double amount = Double.parseDouble(amountField.getText());
// Unit unit = unitBox.getValue();
// Category category = categoryBox.getValue();
// String brand = brandField.getText();
// double price = Double.parseDouble(priceField.getText());
// LocalDate purchaseDate = LocalDate.parse(purchaseField.getText(),
// java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"));
// LocalDate expDate = LocalDate.parse(expField.getText(),
// java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"));

// return new PantryItem(name, unit, amount, category, expDate, purchaseDate,
// brand, price);
// } catch (Exception ex) {
// // If parsing fails, just return null (no popup needed)
// return null;
// }
// }
// return null;
// });

// dialog.showAndWait().ifPresent(newItem -> {
// if (newItem != null) {
// plebensmittel.add(newItem);
// names.add(newItem.getName());
// }
// });
// });

// Button remLebensmittel = new Button("Lebensmittel entfernen");
// remLebensmittel.setOnAction(e -> {
// if (this.plebensmittelIdx != -1) {
// this.plebensmittel.remove(this.plebensmittelIdx);
// names.remove(this.plebensmittelIdx);
// this.plebensmittelIdx = -1;
// updateLebensmittelInfoBox(itemInfo);
// }
// });
// Button asd = new NavigationButton("asd", Route.ADD_GROCERY, navigator);
// Button homeButton = new NavigationButton("Zurück zum Hauptmenü", Route.MAIN,
// navigator);
// buttonBox.getChildren().addAll(addLebensmittel, remLebensmittel, asd,
// homeButton);

// root.getChildren().addAll(siteMain, buttonBox);

// return root;
// }

// private void updateLebensmittelInfoBox(VBox itemInfo) {
// itemInfo.getChildren().clear();
// if (this.plebensmittelIdx == -1) {
// itemInfo.getChildren().add(new Label("No item selected"));
// } else {
// Label sel = new
// Label(plebensmittel.get(this.plebensmittelIdx).getDetails(locale));
// itemInfo.getChildren().add(sel);
// }
// }
// }
