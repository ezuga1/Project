package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for Contact page
 * @author Ernad Zuga
 */

public class ContactController {
    Parent root;
    Stage stage;
    Scene scene;

    /**
     * Method for Logout button, it returns us to login page
     * @param actionEvent
     * @throws IOException
     */
    public void onClickLogOut(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method for Home button, it returns us to home page
     * @param actionEvent
     * @throws IOException
     */
    public void onClickHome(ActionEvent actionEvent) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/fxml/market.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
