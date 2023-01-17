package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.exceptions.MarketException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL Implementation for DAO
 * @author Ernad Zuga
 */

public class ItemsDaoSQLImpl extends AbstractDao<Items> implements ItemsDao {

    private static ItemsDaoSQLImpl instance = null;

    public ItemsDaoSQLImpl() {
        super("Items");
    }

    public static ItemsDaoSQLImpl getInstance(){
        if(instance == null)
            instance = new ItemsDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance != null)
            instance = null;
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
        item.put("category_id", object.getCategoryID());
        item.put("user_id", object.getUserID());
        return item;
    }



    /**
     *
     * @param category search string for items
     * @return list of items
     * @throws MarketException
     */
    @Override
    public List<Items> searchByCategory(Category category) throws MarketException {
        return executeQuery("SELECT * FROM Items WHERE category_id = ?", new Object[]{category.getId()});
    }

    @Override
    public List<Items> searchByPrice(String price1, String price2) throws MarketException {
        return executeQuery("SELECT * FROM Items WHERE price BETWEEN ? AND ?", new Object[]{price1, price2});
    }

    @Override
    public Items randomItem() throws MarketException{
        return executeQueryUnique("SELECT * FROM Items ORDER BY RAND() LIMIT 1", null);
    }
}
