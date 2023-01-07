package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.JDBCDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import ba.unsa.etf.rpr.dao.JDBCDao;

public class RegisterController {
    @FXML
    private TextField userNameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

   @FXML
    public void register(ActionEvent actionEvent){

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
        JDBCDao jdbcDao = new JDBCDao();
        jdbcDao.insertUser(userNameField.getText(), emailField.getText(), passwordField.getText());




        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration successfully!", userNameField.getText() + " welcome to our shop");
    }



    private void showAlert(Alert.AlertType alertType, Window owner, String s, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(s);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }




}
