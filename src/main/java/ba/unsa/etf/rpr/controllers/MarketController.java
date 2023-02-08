package ba.unsa.etf.rpr.controllers;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 * Controller for Market, main page
 * @author Ernad Zuga
 */
public class MarketController {
    @FXML
    public ImageView ImageView;
    @FXML
    private ChoiceBox<Category> categoryChoice;
    @FXML
    private TextField Price;
    @FXML
    private TableView<Items> itemsTable;
    @FXML
    private TableColumn<Items, String> colName;
    @FXML
    private TableColumn<Items, String> colPrice;
    @FXML
    private TableColumn<Items, String> colDesc;

    /**
     * Method for setting up market page, with list of available items, searching by category or price and other functions
     * @throws MarketException
     */
    public void initialize() throws MarketException{
        ImageView.setImage(new Image("/zzmarket.JPG"));
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

    /**
     * Method for Home button, which return us to home page
     * @param actionEvent
     * @throws IOException
     */
    public void onClickHome(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/market.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method for Random Item button, it returns some random item from database
     * @param actionEvent
     * @throws MarketException
     */
    public void randomItem(ActionEvent actionEvent) throws MarketException {
        ItemsManager random = new ItemsManager();
        infoBox(null, "Item you might like from our shop: \n" + random.randomItem() + "\nIf you want to buy it, you can find it in the list of our items.", "Random item from our shop");
    }

    /**
     * Method for Contact button, it sends us to Contact page
     * @param actionEvent
     * @throws IOException
     */
    public void onClickContact(ActionEvent actionEvent) throws IOException{
         root = FXMLLoader.load(getClass().getResource("/fxml/contact.fxml"));
         stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

    /**
     * Method for Logout button, it returns us to login page
     * @param actionEvent
     * @throws IOException
     */
    public void onClickLogOut(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method for search by price field, returns list of items with entered price
     * @param actionEvent
     * @throws MarketException
     */

    public void onSearchByPrice(ActionEvent actionEvent) throws MarketException {
        String price = Price.getText();
        ItemsManager itemsManager = new ItemsManager();
        List<Items> items = itemsManager.searchItems(price);
        itemsTable.setItems(FXCollections.observableArrayList(items));
    }

    /**
     * Method for interaction with customer
     * @param message
     * @param text
     * @param title
     */

   public static void infoBox(String message, String text, String title){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(text);
        alert.setContentText(message);
        alert.show();
   }

    /**
     * Method for Buy button, where user can buy selected item from item list
     * @param actionEvent
     * @throws MarketException
     */
    public void Buy(ActionEvent actionEvent) throws MarketException {
        Items selectedItem = itemsTable.getSelectionModel().getSelectedItem();
        if(selectedItem != null){
            ItemsManager itemsManager = new ItemsManager();
            itemsTable.getItems().remove(selectedItem);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("You have successfully bought " + selectedItem.getItemName());
            alert.setContentText("We hope you will visit us again");
            alert.show();
            itemsTable.refresh();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No item selected");
            alert.setContentText("Please select an item from the table if you want to buy something");
            alert.show();
        }
    }
}
