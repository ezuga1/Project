package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.exceptions.MarketException;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * MySQL Implementation for DAO
 * @author Ernad Zuga
 */

public class ItemsDaoSQLImpl extends AbstractDao<Items> implements ItemsDao {
    public ItemsDaoSQLImpl() {
        super("items");
    }

    @Override
    public Items row2object(ResultSet rs) throws MarketException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Items object) {
        return null;
    }

    @Override
    public Items add(Items item) throws MarketException {
        return null;
    }

    @Override
    public List<Items> searchByText(String text) throws MarketException {
        return null;
    }

    @Override
    public List<Items> searchByCategory(Category category) throws MarketException {
        return null;
    }

    @Override
    public List<Items> searchByPrice(String price) throws MarketException {
        return null;
    }
}
