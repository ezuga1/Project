package ba.unsa.etf.rpr.controllerTest;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MarketControllerTest extends ApplicationTest {
    /**
     * Method for loading market page
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/market.fxml"));
        stage.setScene(new Scene(loader.load(),300,300));
        stage.show();
    }

    /**
     * Test to check does Choice Box with Categories work ok
     */
    @Test
    public void searchByCategoryTest(){
        FxRobot robot = new FxRobot();
        ChoiceBox choiceCategory = robot.lookup("#categoryChoice").queryAs(ChoiceBox.class);
        assertNotNull(choiceCategory);
        Platform.runLater(() -> choiceCategory.show());
        try {
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        robot.clickOn("Laptop");

    }

    /**
     * Test to check dose Logout button work ok
     */
    @Test
    public void LogOutTest(){
        FxRobot robot = new FxRobot();
        robot.clickOn("#logout");

        Label username = robot.lookup("#username").queryAs(Label.class);
        assertNotNull(username);

    }
}
