package ba.unsa.etf.rpr.business;
import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MarketException;

import java.util.List;

public class UserManager {
    public List<User> getAll() throws MarketException{
        return DaoFactory.userDao().getAll();
    }

    public void delete (int id) throws MarketException{
        DaoFactory.userDao().delete(id);
    }
    public User add(User user) throws MarketException{
        return DaoFactory.userDao().add(user);

    }
    public void update(User user) throws MarketException{
        DaoFactory.userDao().update(user);
    }
}
