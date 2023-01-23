package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.ItemsManager;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.exceptions.MarketException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class AdminController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private TableView<Items> itemsTable;
    @FXML
    private TableColumn<Items,String> colName;
    @FXML
    private TableColumn<Items, String> colPrice;
    @FXML
    private TableColumn<Items,String> colDesc;


    public void initialize() throws MarketException {
        colName.setCellValueFactory(new PropertyValueFactory<Items, String>("itemName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Items, String>("price"));
        colDesc.setCellValueFactory(new PropertyValueFactory<Items, String>("description"));
        ItemsManager itemsManager = new ItemsManager();
        List<Items> itemsList = itemsManager.getAll();
        ObservableList<Items> items = FXCollections.observableList(itemsList);
        itemsTable.setItems(FXCollections.observableArrayList(itemsList));


    }
    public void addItem(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/add.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void deleteItem(ActionEvent actionEvent) {
    }

    public void addCategory(ActionEvent actionEvent) throws IOException {
            root = FXMLLoader.load(getClass().getResource("/fxml/category.fxml"));
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
}
