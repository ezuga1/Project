package ba.unsa.etf.rpr.dao;




/**
 * Factory method for singleton implementation of DAOs
 *
 * @author Ernad Zuga
 */
public class DaoFactory {
    private static final CategoryDao categoryDao = CategoryDaoSQLImpl.getInstance();
    private static final ItemsDao itemsDao = ItemsDaoSQLImpl.getInstance();
    private static final UserDao userDao = UserDaoSQLImpl.getInstance();

    private DaoFactory(){

    }

    public static CategoryDao categoryDao(){
        return categoryDao;
    }

    public static ItemsDao itemsDao(){
        return itemsDao;
    }

    public static UserDao userDao(){
        return userDao;
    }

}
