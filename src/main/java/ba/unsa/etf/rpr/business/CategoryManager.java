package ba.unsa.etf.rpr.business;


import ba.unsa.etf.rpr.exceptions.MarketException;

/**
 * Business Logic Layer for management of Categories
 *
 * @author Ernad Zuga
 */

public class CategoryManager {
    public void validateCategoryName(String name) throws MarketException {
        if(name == null || name.length() > 45 || name.length() <3){
            throw new MarketException("Category name must be between 3 and 45 chars");
        }

    }

}
