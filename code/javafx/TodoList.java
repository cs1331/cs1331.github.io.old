import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TodoList extends Application {

    private ObservableList<String> todos;

    @Override public void start(Stage stage) {
        ObservableList<String> todos = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<String>(todos);

        Button addButton = new Button();
        addButton.setText("Add");

        TextField inputField = new TextField();

        addButton.setOnAction(e -> {
            todos.add(inputField.getText());
            inputField.setText("");
            inputField.requestFocus();
        });

        addButton.disableProperty()
            .bind(Bindings.isEmpty(inputField.textProperty()));

        HBox entryBox = new HBox();
        entryBox.getChildren().addAll(inputField, addButton);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(listView, entryBox);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("Todos");
        stage.show();
    }
}
