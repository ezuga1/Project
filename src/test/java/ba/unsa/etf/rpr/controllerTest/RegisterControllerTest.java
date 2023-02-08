package ba.unsa.etf.rpr.controllerTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

/**
 * Tests for registration and login
 * @author Ernad Zuga
 */
public class RegisterControllerTest extends ApplicationTest {
    private Scene scene;
    /**
     * Method to open registration page
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/register.fxml"));
       stage.setScene(scene = new Scene(loader.load(),300,300));
       stage.show();
    }
}
