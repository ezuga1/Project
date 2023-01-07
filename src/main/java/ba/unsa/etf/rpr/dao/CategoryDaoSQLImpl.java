package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.exceptions.MarketException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL implementation of the DAO
 * @author Ernad Zuga
 */

public class CategoryDaoSQLImpl extends AbstractDao<Category> implements CategoryDao {
    private static CategoryDaoSQLImpl instance = null;
    public CategoryDaoSQLImpl() {
        super("category");
    }


    public static CategoryDaoSQLImpl getInstance(){
        if(instance == null)
            instance = new CategoryDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance != null)
                instance = null;
    }
    @Override
    public Category row2object(ResultSet rs) throws MarketException {
        try {
            Category cat = new Category();
            cat.setId(rs.getInt("category_id"));
            cat.setName(rs.getString("name"));
            cat.setName(rs.getString("status"));
            return cat;
        } catch (SQLException e) {
            throw new MarketException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Category object) {
        Map<String, Object> row = new TreeMap<String, Object>();
        row.put("category_id", object.getId());
        row.put("name", object.getName());
        row.put("status", object.getStatus());
        return row;
    }
}
