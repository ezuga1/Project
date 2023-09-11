package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.CategoryManager;
import ba.unsa.etf.rpr.business.ItemsManager;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MarketException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for adding Item to database
 * @author Ernad Zuga
 */
public class AddController {
    @FXML
    private TextField txtItemName;
    @FXML
    private TextField txtItemPrice;
    @FXML
    private TextField ItemDescription;
    @FXML
    private TextField Categoryname;
    private Stage stage;
    private Scene scene;
    private Parent root;

    ItemsManager itemsManager = new ItemsManager();
    CategoryManager categoryManager = new CategoryManager();

    /**
     * Method for Add Item button, where admin can add item to database.
     * @param actionEvent
     * @throws MarketException
     */
    public void onAddItem(ActionEvent actionEvent) throws MarketException {
        Items item = new Items();
        Category category = new Category();
        boolean exists = false;
        category.setName(Categoryname.getText());
        List<Category> categoryList = new ArrayList<>(categoryManager.getAll());
        for(Category cat : categoryList) {
            if (cat.getName().equals(category.getName())) {
                exists = true;
                category = cat;
                break;
            }
        if(!exists) {
            category.setId(0);
            category.setStatus("available");
            category = categoryManager.add(category);
        }
        }
        String itemName = txtItemName.getText();
        String itemPrice = txtItemPrice.getText();
        String itemDescription = ItemDescription.getText();
        item.setItemName(itemName);
        item.setPrice(itemPrice);
        item.setDescription(itemDescription);
        item.setCategoryID(category);
        item.setUserID(2);
        itemsManager.add(item);

    }

    /**
     * Method for Cancel Button, it sends us to admin page.
     * @param actionEvent
     * @throws IOException
     */
    public void onCancel(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/admin.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void showAlert(Alert.AlertType alertType, Window owner, String s, String message){
        Alert alert = new Alert(alertType);
        alert.setTitle(s);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
