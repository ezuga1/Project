package ba.unsa.etf.rpr.business;
import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MarketException;

import java.util.List;

/**
 * Business Logic Layer for Users
 *
 * @author Ernad Zuga
 */
public class UserManager {
    /**
     * Method for getting list of all users from database
     * @return
     * @throws MarketException
     */
    public List<User> getAll() throws MarketException{
        return DaoFactory.userDao().getAll();
    }

    /**
     * Method for deleting user from database
     * @param id
     * @throws MarketException
     */
    public void delete (int id) throws MarketException{
        DaoFactory.userDao().delete(id);
    }

    /**
     * Method for adding user to database
     * @param user
     * @return
     * @throws MarketException
     */
    public User add(User user) throws MarketException{
        return DaoFactory.userDao().add(user);

    }
    /**
     * Method for updating user in database
     */
    public void update(User user) throws MarketException{
        DaoFactory.userDao().update(user);
    }

    /**
     * Method for validating user. Checks if user exists in database.
     * @param name
     * @param password
     * @return
     * @throws MarketException
     */
    public boolean validate(String name, String password) throws MarketException {
        UserManager userManager = new UserManager();
        for(User u : userManager.getAll()){
            if(u.getUsername().equals(name) && u.getPassword().equals(password))
                return true;
        }
        return false;
    }
}
