package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.ItemsManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class MarketController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    public void onClickHome(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/market.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void randomItem(ActionEvent actionEvent) {
        ItemsManager random = new ItemsManager();
        infoBox(null, "Item you might like", "Random item from our shop");
    }

    public void onClickContact(ActionEvent actionEvent) {


    }

    public void onClickLogOut(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onAddToCart1(ActionEvent actionEvent) {
    }

    public void onAddToCart2(ActionEvent actionEvent) {
    }

    public void onAddToCart3(ActionEvent actionEvent) {
    }

    public void onSearchByCategory(ActionEvent actionEvent) {
    }

    public void onSearchByPrice(ActionEvent actionEvent) {
    }


   public static void infoBox(String message, String text, String title){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(text);
        alert.setContentText(message);
        alert.show();
   }
}
