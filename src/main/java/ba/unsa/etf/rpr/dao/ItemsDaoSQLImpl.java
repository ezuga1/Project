package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.exceptions.MarketException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        try {
            Items item = new Items();
            item.setId(rs.getInt("item_id"));
            item.setItemName(rs.getString("item_name"));
            item.setPrice(rs.getString("price"));
            item.setDescription(rs.getString("description"));
            item.setCategoryID(rs.getInt("category_id"));
            item.setUserID(rs.getInt("user_id"));
            return item;
        }catch (Exception e){
            throw new MarketException(e.getMessage(),e);
        }
    }

    /**
     *
     * @param object
     * @return
     */

    @Override
    public Map<String, Object> object2row(Items object) {
        Map<String, Object> item = new TreeMap<String, Object>();
        item.put("item_id", object.getId());
        item.put("item_name", object.getItemName());
        item.put("price", object.getPrice());
        item.put("description", object.getDescription());
        item.put("category_name", object.getCategoryID());
        item.put("user_id", object.getUserID());
        return item;
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
