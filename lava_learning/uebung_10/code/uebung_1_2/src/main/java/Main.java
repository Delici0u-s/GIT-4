
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  private class Person {
    String Name;
    final int Geburtsjahr;
    boolean verheiratet;

    Person(String Name, int Gebj, boolean verheiratet) {
      this.Name = Name;
      this.Geburtsjahr = Gebj;
      this.verheiratet = verheiratet;
    }
  }

  private class PersonInputField {

    private TextField nameBox;
    private ChoiceBox<Integer> gebjahrBox;
    private CheckBox Stand;
    private ArrayList<Person> PersonList;

    PersonInputField(ArrayList<Person> PersonList) {
      this.PersonList = PersonList;

    }

    Pane addToScene() {
      VBox mainBox = new VBox(10);
      HBox InputBlock = new HBox(10);
      VBox names = new VBox(20);
      names.getChildren().addAll(new Label("Name: "),
          new Label("Geburtzjahr: "),
          new Label("Stand: "));

      VBox fields = new VBox(10);

      nameBox = new TextField();

      ObservableList<Integer> itemlist = FXCollections.observableArrayList();
      for (int i = 2025; i > 1900; i--) {
        itemlist.add(i);
      }
      gebjahrBox = new ChoiceBox<>(itemlist);

      Stand = new CheckBox();

      fields.getChildren().addAll(nameBox, gebjahrBox, Stand);

      InputBlock.getChildren().addAll(names, fields);
      HBox buttonBox = new HBox();
      Button okB = new Button("Ok");
      okB.setOnAction(e -> addDataToList());

      Button clearB = new Button("Neu");
      clearB.setOnAction(e -> reset());

      buttonBox.getChildren().addAll(clearB, okB);
      mainBox.getChildren().addAll(InputBlock, buttonBox);
      reset();
      return mainBox;
    }

    private void addDataToList() {
      PersonList.add(new Person(nameBox.getText(), (int) gebjahrBox.getValue(), Stand.selectedProperty().getValue()));
    }

    void reset() {
      nameBox.setText("");
      gebjahrBox.setValue(gebjahrBox.getItems().get(0));
      Stand.selectedProperty().setValue(false);

    }

  }

  @Override
  public void start(Stage stage) {
    VBox mainBox = new VBox(10);
    Scene scene = new Scene(mainBox, 300, 200);

    ArrayList<Person> Personlist = new ArrayList<>();

    mainBox.getChildren().addAll(new PersonInputField(Personlist).addToScene());
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }

}
