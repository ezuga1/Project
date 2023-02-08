package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MarketException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * Controller for user login
 * @author Ernad Zuga
 */
public class LoginController {
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    /**
     * Method for user login with checking does user exist in database
     * @param actionEvent
     * @throws IOException
     * @throws MarketException
     */
    @FXML
    public void login(ActionEvent actionEvent) throws IOException, MarketException {
        Window owner = loginButton.getScene().getWindow();

        System.out.println(userNameField.getText());
        System.out.println(passwordField.getText());

        if(userNameField.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR, owner, "Ooops, login error", "Please enter your username");
            return;
        }
        if(passwordField.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR, owner, "Ooops, login error", "Please enter your password");
            return;
        }
        UserManager userManager = new UserManager();
        if(userManager.validate(userNameField.getText(), passwordField.getText())){
            infoBox("Login successful!", null, "Success");
            root = FXMLLoader.load(getClass().getResource("/fxml/market.fxml"));
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }else{
            infoBox("Please enter correct username and password or create account (Click Register button)", null, "Failed");
        }



    }

    /**
     * Method for Info Box that appears when user is logged in
     * @param message
     * @param text
     * @param title
     */
    public static void infoBox(String message, String text, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(text);
        alert.show();
    }

    /**
     * Method for showing alert when user did not enter correct data
     * @param alertType
     * @param owner
     * @param s
     * @param message
     */
    public static void showAlert(Alert.AlertType alertType, Window owner, String s, String message){
        Alert alert = new Alert(alertType);
        alert.setTitle(s);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    /**
     * Method for going to register page if user did not register before
     * @param actionEvent
     * @throws IOException
     */
    public void register(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/register.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
