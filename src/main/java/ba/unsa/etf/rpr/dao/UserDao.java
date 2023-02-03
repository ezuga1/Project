package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MarketException;

import java.util.List;

public interface UserDao extends Dao<User> {
    public boolean validate(String username, String password) throws MarketException;

}
