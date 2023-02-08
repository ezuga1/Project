package ba.unsa.etf.rpr.business;
import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.exceptions.MarketException;

import java.util.List;

/**
 * Business Logic Layer for Items
 *
 * @author Ernad Zuga
 */

public class ItemsManager {
    /**
     * Method for getting list of all items in database
     * @return
     * @throws MarketException
     */
    public List<Items> getAll() throws MarketException {
        return DaoFactory.itemsDao().getAll();
    }

    /**
     * Method for searching item in database based on it's price
     * @param price
     * @return
     * @throws MarketException
     */

 public List<Items> searchItems(String price) throws MarketException {
        return DaoFactory.itemsDao().searchByPrice(price);
 }

    /**
     * Method for searching item in database based on it's category
     * @param category
     * @return
     * @throws MarketException
     */
 public List<Items> searchItemsByCategory(Category category) throws MarketException{
        return DaoFactory.itemsDao().searchByCategory(category);
 }

    /**
     * Method for deleting item from database
     * @param id
     * @throws MarketException
     */
    public void delete (int id) throws MarketException {
        DaoFactory.itemsDao().delete(id);
}

    /**
     * Method to get item from database by item id
     * @param itemsId
     * @return
     * @throws MarketException
     */
    public Items getById(int itemsId) throws MarketException {
        return DaoFactory.itemsDao().getById(itemsId);
}

    /**
     * Method for updating item in database
     * @param item
     * @throws MarketException
     */
    public void update(Items item) throws MarketException {
DaoFactory.itemsDao().update(item);
}

    /**
     * Method for adding item to database
     * @param item
     * @return
     * @throws MarketException
     */
    public Items add(Items item) throws MarketException {
        return DaoFactory.itemsDao().add(item);
}

    /**
     * Method which returns random item from database
     * @return
     * @throws MarketException
     */
    public Items randomItem() throws MarketException {
        return DaoFactory.itemsDao().randomItem();

}

}
