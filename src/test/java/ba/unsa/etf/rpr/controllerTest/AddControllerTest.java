package ba.unsa.etf.rpr.controllerTest;

import ba.unsa.etf.rpr.business.ItemsManager;
import ba.unsa.etf.rpr.controllers.AdminController;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.exceptions.MarketException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AddControllerTest extends ApplicationTest {

    private Scene scene;

    /**
     * Method to set up admin page
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/add.fxml"));
        stage.setScene(scene = new Scene(loader.load(),300,300));
        stage.show();
    }

    /**
     * Test for Add Item button in AddController
     */
    @Test
    public void testAddItem() throws MarketException {
        FxRobot robot = new FxRobot();
        robot.clickOn("#txtItemName").write("Apple");
        robot.clickOn("#txtItemPrice").write("2 KM");
        robot.clickOn("#ItemDescription").write("Description");
        robot.clickOn("#CategoryId").write("15");
        robot.clickOn("#AddItem");

        Items item = new Items();
        ItemsManager itemsManager = new ItemsManager();
        for(Items tmp : itemsManager.getAll()){
            if(tmp.getItemName().equals("Apple") && tmp.getPrice().equals("2 KM") && tmp.getDescription().equals("Description")
            && tmp.getCategoryID() == 15)
                item = tmp;
        }
        assertNotNull(item);
        assertEquals("Apple", item.getItemName());
        assertEquals("2 KM", item.getPrice());
        assertEquals("Description", item.getDescription());
        assertEquals(15, item.getCategoryID());
    }


}
