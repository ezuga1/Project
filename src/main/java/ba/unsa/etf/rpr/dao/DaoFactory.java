package ba.unsa.etf.rpr.dao;

/**
 * Factory method for singleton implementation of DAOs
 *
 * @author Ernad Zuga
 */
public class DaoFactory {
    private static final CategoryDao categoryDao = new CategoryDaoSQLImpl();
}
