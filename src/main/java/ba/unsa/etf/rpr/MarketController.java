package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    public void onClickShop(ActionEvent actionEvent) {
    }

    public void onClickContact(ActionEvent actionEvent) {
    }

    public void onClickLogin(ActionEvent actionEvent) {
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
}
