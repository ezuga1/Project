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
    public CategoryDaoSQLImpl(String tableName) {
        super("categories");
    }

    @Override
    public Category row2object(ResultSet rs) throws MarketException {
        try {
            Category cat = new Category();
            cat.setId(rs.getInt("id"));
            cat.setName(rs.getString("name"));
            return cat;
        } catch (SQLException e) {
            throw new MarketException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Category object) {
        Map<String, Object> row = new TreeMap<String, Object>();
        row.put("id", object.getId());
        row.put("name", object.getName());
        return row;
    }
}
