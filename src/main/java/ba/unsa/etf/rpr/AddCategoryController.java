package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.CategoryManager;
import ba.unsa.etf.rpr.business.ItemsManager;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.exceptions.MarketException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.awt.*;


public class AddCategoryController {
    @FXML
    private TextField categoryName;

    @FXML
    private TextField categoryStatus;
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
    public static void infoBox(String message, String text, String tittle){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.setTitle(tittle);
        alert.setHeaderText(text);
        alert.show();
    }
}
