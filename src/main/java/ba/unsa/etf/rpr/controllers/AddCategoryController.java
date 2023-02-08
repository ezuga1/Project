package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.CategoryManager;
import ba.unsa.etf.rpr.business.ItemsManager;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.exceptions.MarketException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

/**
 * Controller for adding category to database
 * @author Ernad Zuga
 */

public class AddCategoryController {
    private Parent root;
    private Stage stage;
    public Scene scene;
    @FXML
    private TextField categoryName;

    @FXML
    private TextField categoryStatus;

    /**
     * Method for Add Category Button.
     * @param actionEvent
     * @throws MarketException
     */
    public void onAddCategory(ActionEvent actionEvent) throws MarketException {
        try {
            String catName = categoryName.getText();
            String catStatus = categoryStatus.getText();
            Category category = new Category();
            CategoryManager categoryManager = new CategoryManager();
            category.setName(catName);
            category.setStatus(catStatus);
            categoryManager.add(category);
        }catch (MarketException e){
            e.printStackTrace();
        }
        infoBox("Category added successfully", null, "Success");

    }

    /**
     * Method for infoBox that appears when adding is successful
     * @param message
     * @param text
     * @param tittle
     */
    public static void infoBox(String message, String text, String tittle){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.setTitle(tittle);
        alert.setHeaderText(text);
        alert.show();
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
