package ba.unsa.etf.rpr.controllerTest;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.controllers.RegisterController;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MarketException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;
import javafx.application.Platform.*;
import java.io.IOException;

import static javafx.application.Platform.runLater;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    /**
     * Test for registration with correct input
     */
    @Test
    public void testRegister() throws MarketException {
        FxRobot robot = new FxRobot();
        robot.clickOn("#userNameField").write("Test1");
        robot.clickOn("#emailField").write("test1@test");
        robot.clickOn("#passwordField").write("test1");
        robot.clickOn("#registerButton");

        User user = new User();
        UserManager userManager = new UserManager();
        for(User u : userManager.getAll()){
            if(u.getUsername().equals("Test1") && u.getEmailAddress().equals("test1@test") && u.getPassword().equals("test1"))
                user = u;
        }
        assertNotNull(user);
        assertEquals("Test1", user.getUsername());
        assertEquals("test1@test", user.getEmailAddress());
        assertEquals("test1", user.getPassword());

    }
    /**
     * Test for login, user is registered
     */
    @Test
    public void testLogin() throws IOException {
        runLater(() ->{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
            try {
                stage.setScene(scene = new Scene(loader.load(),300,300));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.show();
            FxRobot robot = new FxRobot();
            robot.clickOn("#userNameField").write("Test1");
            robot.clickOn("#passwordField").write("test1");
            robot.clickOn("#loginButton");

        });


    }
}
