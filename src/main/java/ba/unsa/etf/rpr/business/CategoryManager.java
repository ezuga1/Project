package ba.unsa.etf.rpr.business;


import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.exceptions.MarketException;

import java.util.List;

/**
 * Business Logic Layer for management of Categories
 *
 * @author Ernad Zuga
 */

public class CategoryManager {
    /**
     * Method for validating category name. Name must be between 2 and 45 characters.
     * @param name
     * @throws MarketException
     */
    public void validateCategoryName(String name) throws MarketException {
        if (name == null || name.length() > 45 || name.length() < 2) {
            throw new MarketException("Category name must be between 2 and 45 chars");
        }

    }

    /**
     * Method for adding category to database
     * @param cat
     * @return
     * @throws MarketException
     */
    public Category add(Category cat) throws MarketException {
        if (cat.getId() != 0) {
            throw new MarketException("Can't add category with ID. ID is autogenerated");
        }
        validateCategoryName(cat.getName());

        try {
            return DaoFactory.categoryDao().add(cat);

        } catch (MarketException e) {
            if (e.getMessage().contains("UQ_NAME")) {
                throw new MarketException("Category with same name exists");
            }
            throw e;
        }
    }

    /**
     * Method for deleting category from database
     * @param categoryId
     * @throws MarketException
     */
    public void delete(int categoryId) throws MarketException {
        try {
            DaoFactory.categoryDao().delete(categoryId);
        } catch (MarketException e) {
            if (e.getMessage().contains("FOREIGN KEY")) {
                throw new MarketException("Cannot delete category which is related to items. First delete related items before deleting category");
            }
            throw e;
        }

    }

    /**
     * Method for updating category in database
     * @param cat
     * @return
     * @throws MarketException
     */
    public Category update(Category cat) throws MarketException {
            validateCategoryName(cat.getName());
            return DaoFactory.categoryDao().update(cat);
    }

    /**
     * Method for getting list of all categories in database
     * @return
     * @throws MarketException
     */
    public List<Category> getAll() throws MarketException {
        return DaoFactory.categoryDao().getAll();
    }
}