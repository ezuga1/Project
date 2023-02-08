package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ItemsManager;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * Controller for admin page
 * @author Ernad Zuga
 */
public class AdminController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private TableView<Items> itemsTable;
    @FXML
    private TableColumn<Items,String> colName;
    @FXML
    private TableColumn<Items, String> colPrice;
    @FXML
    private TableColumn<Items,String> colDesc;

    /**
     * Method to set up admin page with list of currently existing items
     * @throws MarketException
     */
    public void initialize() throws MarketException {
        colName.setCellValueFactory(new PropertyValueFactory<Items, String>("itemName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Items, String>("price"));
        colDesc.setCellValueFactory(new PropertyValueFactory<Items, String>("description"));
        ItemsManager itemsManager = new ItemsManager();
        List<Items> itemsList = itemsManager.getAll();
        ObservableList<Items> items = FXCollections.observableList(itemsList);
        itemsTable.setItems(FXCollections.observableArrayList(itemsList));


    }

    /**
     * Method for Add Item button, where admin or employee can add item to database
     * @param actionEvent
     * @throws IOException
     */
    public void addItem(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/add.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method for Delete Item button, where admin or employee can delete item from database
     * @param actionEvent
     * @throws MarketException
     */
    public void deleteItem(ActionEvent actionEvent) throws MarketException {
        Items selectedItem = itemsTable.getSelectionModel().getSelectedItem();
       if(selectedItem != null){
           ItemsManager itemsManager = new ItemsManager();
           itemsManager.delete(selectedItem.getId());
           itemsTable.getItems().remove(selectedItem);
           itemsTable.refresh();
       }else {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText("No item selected");
           alert.setContentText("Please select an item from the table");
       }
    }

    /**
     * Method for Add Category button, where admin or employee can add category to database
     * @param actionEvent
     * @throws IOException
     */
    public void addCategory(ActionEvent actionEvent) throws IOException {
            root = FXMLLoader.load(getClass().getResource("/fxml/category.fxml"));
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    /**
     * Method for Logout button, it returns us to login page
     * @param actionEvent
     * @throws IOException
     */
    public void Logout(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
