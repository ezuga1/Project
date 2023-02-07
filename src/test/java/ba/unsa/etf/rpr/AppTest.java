package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.CategoryManager;
import ba.unsa.etf.rpr.controllers.AddCategoryController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for Project.
 * @author Ernad Zuga
 */
public class AppTest 
{   private AddCategoryController addCategoryController;
    private CategoryManager categoryManager;

    /**
     * setting up page for adding category
     */
    @BeforeEach
    public void setUp() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addCategory.fxml"));
        Parent root = loader.load();
        addCategoryController = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        categoryManager = new CategoryManager();
    }
    /**
     * Test for add button
     */
    @Test
    public void testAddButton(){

    }
}
