package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.CategoryManager;
import ba.unsa.etf.rpr.business.ItemsManager;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.exceptions.MarketException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class MarketController {
    @FXML
    private ChoiceBox<Category> categoryChoice;


    @FXML
    private TableView<Items> itemsTable;
    @FXML
    private TableColumn<Items, String> colName;
    @FXML
    private TableColumn<Items, String> colPrice;
    @FXML
    private TableColumn<Items, String> colDesc;

    public void initialize() throws MarketException{
        colName.setCellValueFactory(new PropertyValueFactory<Items, String>("itemName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Items, String>("price"));
        colDesc.setCellValueFactory(new PropertyValueFactory<Items, String>("description"));
        ItemsManager itemsManager =  new ItemsManager();
        List<Items> itemsList = itemsManager.getAll();
        ObservableList<Items> items = FXCollections.observableList(itemsList);
        itemsTable.setItems(FXCollections.observableArrayList(itemsList));

        CategoryManager categoryManager = new CategoryManager();
        categoryChoice.setItems(FXCollections.observableList(categoryManager.getAll()));
        categoryChoice.valueProperty().addListener(((observableValue, category, t1) -> {
            if(t1 != null){
                try {
                    ObservableList<Items> newItems = FXCollections.observableArrayList(itemsManager.searchItemsByCategory((Category)  t1));
                    itemsTable.setItems(newItems);
                }
                catch (MarketException e){
                    e.printStackTrace();
                }
            }
        }));
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



    public void onSearchByPrice(ActionEvent actionEvent) {

    }


   public static void infoBox(String message, String text, String title){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(text);
        alert.setContentText(message);
        alert.show();
   }

    public void Buy(ActionEvent actionEvent) {
    }
}
