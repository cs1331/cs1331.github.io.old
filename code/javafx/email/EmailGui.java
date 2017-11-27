import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmailGui extends Application {

    @Override public void start(Stage stage) {
        EmailDb emailDb = new EmailDb();
        ObservableList<EmailMessage> emails =
            FXCollections.observableArrayList(emailDb.getEmails());
        TableView<EmailMessage> table = createTable(emails);

        Button viewButton = new Button("View Message");
        viewButton.setOnAction(e -> {
                EmailMessage msg = table.getSelectionModel().getSelectedItem();
                viewDialog(msg);
            });
        viewButton.disableProperty()
            .bind(Bindings.isNull(table.getSelectionModel().selectedItemProperty()));

        Button dismissButton = new Button("Dismiss");
        dismissButton.setOnAction(e -> Platform.exit());

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(viewButton, dismissButton);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(table, buttonBox);
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("Email GUI");
        stage.show();
    }

    private
    TableView<EmailMessage>
    createTable(ObservableList<EmailMessage> emails) {
        TableView<EmailMessage> table = new TableView<EmailMessage>();
        table.setItems(emails);

        TableColumn<EmailMessage, String> fromCol =
            new TableColumn<EmailMessage, String>("From");
        fromCol.setCellValueFactory(new PropertyValueFactory("from"));

        TableColumn<EmailMessage, String> toCol =
            new TableColumn<EmailMessage, String>("To");
        toCol.setCellValueFactory(new PropertyValueFactory("to"));

        TableColumn<EmailMessage, String> subjectCol =
            new TableColumn<EmailMessage, String>("Subject");
        subjectCol.setCellValueFactory(new PropertyValueFactory("subject"));

        table.getColumns().setAll(fromCol, toCol, subjectCol);
        return table;
    }

    private void viewDialog(EmailMessage msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(msg.getSubject());
        alert.setHeaderText(String.format("From: %s%nTo: %s%nSubject: %s",
                                          msg.getFrom(), msg.getTo(),
                                          msg.getSubject()));
        alert.setContentText(msg.getBody());
        alert.showAndWait();
    }
}
