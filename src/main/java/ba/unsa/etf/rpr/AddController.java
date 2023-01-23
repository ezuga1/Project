package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AddController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void onAddItem(ActionEvent actionEvent) {

    }

    public void onCancel(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/admin.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
