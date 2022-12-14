package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.JDBCDao;
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
import java.awt.*;
import java.io.IOException;
import java.util.*;
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
    @FXML
    public void login(ActionEvent actionEvent) throws IOException {
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
        JDBCDao jdbcDao = new JDBCDao();
        boolean valid = jdbcDao.validate(userNameField.getText(), passwordField.getText());

        if(valid){
            infoBox("Login successful!", null, "Failed");

            root = FXMLLoader.load(getClass().getResource("/fxml/market.fxml"));
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }else{
            infoBox("Please enter correct username and password or create account (Click Register button)", null, "Failed");
        }



    }
    public static void infoBox(String message, String text, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(text);
        alert.show();
    }
    public static void showAlert(Alert.AlertType alertType, Window owner, String s, String message){
        Alert alert = new Alert(alertType);
        alert.setTitle(s);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    public void register(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/register.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
