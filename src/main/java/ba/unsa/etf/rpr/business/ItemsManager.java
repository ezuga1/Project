package ba.unsa.etf.rpr.business;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.exceptions.MarketException;

import java.util.List;

/**
 * Business Logic Layer for Items
 *
 * @author Ernad Zuga
 */

public class ItemsManager {
    public List<Items> getAll() throws MarketException {
        return DaoFactory.itemsDao().getAll();
    }

}
