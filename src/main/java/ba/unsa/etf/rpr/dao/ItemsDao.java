package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.exceptions.MarketException;

import java.util.List;

public interface ItemsDao extends Dao<Items> {

    /**
     * Returns all items that contains given text.
     *
     * @param category search string for items
     * @return list of items
     */
    List<Items> searchByCategory(Category category) throws MarketException;

    /**
     * Return all items in range for wanted price.
     * @params price1 and price1
     * @return list of items between given prices
     *
     */
    List<Items> searchByPrice(String price1, String price2) throws MarketException;

    /**
     * Return random item from database
     *
     * @return random item
     * @throws MarketException
     */
    Items randomItem() throws MarketException;
}
