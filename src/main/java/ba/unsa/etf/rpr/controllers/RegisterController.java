package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.JDBCDao;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MarketException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import ba.unsa.etf.rpr.dao.JDBCDao;

import java.io.IOException;
import java.sql.*;

public class RegisterController {

    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

   @FXML
    public void register(ActionEvent actionEvent) throws IOException, MarketException {

        Window owner = registerButton.getScene().getWindow();

        System.out.println(userNameField.getText());
        System.out.println(emailField.getText());
        System.out.println(passwordField.getText());

        if(userNameField.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR, owner, "Ooops, Registration error!", "Please enter your name");
            return;
        }

        if(emailField.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR, owner, "Ooops, Registration error!", "Please enter your email");
            return;
        }
        if(passwordField.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR, owner, "Ooops, Registration error!","Please enter your password");
            return;
        }
       UserManager userManager = new UserManager();
        User user = new User();
        user.setUsername(userNameField.getText());
        user.setEmailAddress(emailField.getText());
        user.setPassword(passwordField.getText());

        for(User u : userManager.getAll()){
            if (u.getUsername().equals(user.getUsername())){
                System.out.println("User already exists");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this username, it already exists");
                alert.show();
                break;
            }
        }
        userManager.add(user);
        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration successfully", user.getUsername() + " welcome to our shop");
       root = FXMLLoader.load(getClass().getResource("/fxml/market.fxml"));
       stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
       scene=new Scene(root);
       stage.setScene(scene);
       stage.show();
       /*PreparedStatement psCheckUserExists = null;
       ResultSet resultSet = null;
       Connection conn = null;*/
       /*try {


           /*conn = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_Tech_Market", "freedb_ezuga1", "yCjgsz%m#TSQ*3q");
           psCheckUserExists = conn.prepareStatement("SELECT * FROM User WHERE username = ?");
           psCheckUserExists.setString(1,userNameField.getText());
           resultSet = psCheckUserExists.executeQuery();*/

           /*if(resultSet.isBeforeFirst()){
               System.out.println("User already exists");
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("You cannot use this username, it already exists");
               alert.show();
           }
           else{
               JDBCDao jdbcDao = new JDBCDao();

               jdbcDao.insertUser(userNameField.getText(), emailField.getText(), passwordField.getText());
               showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration successfully!", userNameField.getText() + " welcome to our shop");

               root = FXMLLoader.load(getClass().getResource("/fxml/market.fxml"));
               stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
               scene=new Scene(root);
               stage.setScene(scene);
               stage.show();
           }
       }
       catch (SQLException e) {
           throw new RuntimeException(e);
       }*/

    }
  



    private void showAlert(Alert.AlertType alertType, Window owner, String s, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(s);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }


    public void adminLogin(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/admin.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
