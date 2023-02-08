package ba.unsa.etf.rpr.controllerTest;

import ba.unsa.etf.rpr.business.CategoryManager;
import ba.unsa.etf.rpr.controllers.AddCategoryController;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.exceptions.MarketException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxRobot;
import java.io.IOException;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for AddCategoryController.
 * @author Ernad Zuga
 */
public class AddCategoryControllerTest extends ApplicationTest {
   private Parent root;
   private Stage stage;
   private Scene scene;

   private AddCategoryController addCategoryController;

    /**
     * Method to set up page for adding category
     */

   @Override
   public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/category.fxml"));
        stage.setScene(scene = new Scene(loader.load(),300,300));
        stage.show();
   }

    /**
     * Test for Add button in AddCategoryController
     */
    @Test
    public void testAddCategory() throws MarketException {
        FxRobot robot = new FxRobot();
        robot.clickOn("#categoryName").write("Fruits");
        robot.clickOn("#categoryStatus").write("Active");
        robot.clickOn("#AddCategory");

        Category c = new Category();
        CategoryManager categoryManager = new CategoryManager();
        for (Category tmp : categoryManager.getAll()) {
            if (tmp.getName().equals("Fruits") && tmp.getStatus().equals("Active")) {
                c = tmp;
            }
        }
        assertNotNull(c);
        assertEquals("Fruits", c.getName());
        assertEquals("Active", c.getStatus());
    }


}
