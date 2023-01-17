package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.CategoryManager;
import ba.unsa.etf.rpr.business.ItemsManager;
import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.exceptions.MarketException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;


public class MainFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Category category = new Category();
        CategoryManager categoryManager = new CategoryManager();
        category.setName("Laptops");
        category.setStatus("Available");
        categoryManager.add(category);



        ItemsManager itemsManager = new ItemsManager();
        Items item = new Items();
        item.setItemName("Laptop");
        item.setPrice("1500 KM");
        item.setDescription("desc");
        item.setCategoryID(1);
        item.setUserID(1);
        itemsManager.add(item);




        System.out.println(getClass());
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage.setTitle("Tech market");
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();

    }
    public static void main(String[] args){
       launch(args);
    }


}
