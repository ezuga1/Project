package ba.unsa.etf.rpr.dao;




/**
 * Factory method for singleton implementation of DAOs
 *
 * @author Ernad Zuga
 */
public class DaoFactory {
    private static final CategoryDao categoryDao = new CategoryDaoSQLImpl();
    private static final ItemsDao itemsDao = new ItemsDaoSQLImpl();
    private static final UserDao userDao = new UserDaoSQLImpl();

    private DaoFactory(){

    }

    public static CategoryDao categoryDao(){
        return categoryDao;
    }

    public static ItemsDao itemsDao(){
        return itemsDao;
    }

}
