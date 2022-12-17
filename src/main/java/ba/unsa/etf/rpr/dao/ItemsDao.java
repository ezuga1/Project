package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.exceptions.MarketException;

import java.util.List;

public interface ItemsDao extends Dao<Items> {
    /**
     * Returns all items that contains given text.
     *
     * @param text search string for quotes
     * @return list of quotes
     */
    List<Items> searchByText(String text) throws MarketException;

    /**
     * Returns all quotes that contains given text.
     *
     * @param category search string for items
     * @return list of quotes
     */
    List<Items> searchByCategory(Category category) throws MarketException;

    List<Items> searchByPrice(String price) throws MarketException;
}
