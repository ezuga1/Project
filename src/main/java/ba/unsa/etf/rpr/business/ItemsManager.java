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
 public List<Items> searchItems(String price) throws MarketException {
        return DaoFactory.itemsDao().searchByPrice(price);
 }
public void delete (int id) throws MarketException {
        DaoFactory.itemsDao().delete(id);
}
public Items getById(int itemsId) throws MarketException {
        return DaoFactory.itemsDao().getById(itemsId);
}
public void update(Items item) throws MarketException {
DaoFactory.itemsDao().update(item);
}
public Items add(Items item) throws MarketException {
        return DaoFactory.itemsDao().add(item);
}
}
