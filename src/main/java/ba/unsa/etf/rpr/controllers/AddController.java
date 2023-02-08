package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ItemsManager;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MarketException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
    private TextField CategoryId;
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Method for Add Item button, where admin can add item to database.
     * @param actionEvent
     * @throws MarketException
     */
    public void onAddItem(ActionEvent actionEvent) throws MarketException {
        ItemsManager itemsManager = new ItemsManager();
        Items item = new Items();

        String itemName = txtItemName.getText();
        String itemPrice = txtItemPrice.getText();
        String itemDescription = ItemDescription.getText();
        int categoryId = Integer.parseInt(CategoryId.getText());

        item.setItemName(itemName);
        item.setPrice(itemPrice);
        item.setDescription(itemDescription);
        item.setCategoryID(categoryId);
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
}
