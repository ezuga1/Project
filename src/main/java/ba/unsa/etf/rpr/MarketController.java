package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.ItemsManager;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.exceptions.MarketException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.List;

public class MarketController {
    @FXML
    private TextArea textArea1;

    public void initialize(){
        ItemsManager itemsManager = new ItemsManager();
        try {
            List<Items> items = itemsManager.getAll();
            StringBuilder sb = new StringBuilder();
            for(Items item : items){
                sb.append(item.toString());
            }
            textArea1.setText(sb.toString());
        } catch (MarketException e) {
            throw new RuntimeException(e);
        }
    }

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

    public void onClickContact(ActionEvent actionEvent) throws IOException{
         root = FXMLLoader.load(getClass().getResource("/fxml/contact.fxml"));
         stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
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
