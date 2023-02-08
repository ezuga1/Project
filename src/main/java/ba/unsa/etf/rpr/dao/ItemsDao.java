package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.exceptions.MarketException;

import java.util.List;

/**
 * Dao interface for Items domain bean
 * @author Ernad Zuga
 */
public interface ItemsDao extends Dao<Items> {

    /**
     * Returns all items that contains given category.
     *
     * @param category search string for items of given category
     * @return list of items
     */
    List<Items> searchByCategory(Category category) throws MarketException;

    /**
     * Return all items in range for wanted price.
     * @params price1 and price1
     * @return list of items between given prices
     *
     */
    List<Items> searchByPrice(String price) throws MarketException;

    /**
     * Return random item from database
     *
     * @return random item
     * @throws MarketException
     */
    Items randomItem() throws MarketException;
}
