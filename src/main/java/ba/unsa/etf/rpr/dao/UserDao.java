package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MarketException;

import java.util.List;

public interface UserDao extends Dao<User> {

    User getById(int id) throws MarketException;


    User add(User item) throws MarketException;


    void delete(int id) throws MarketException;


    List<User> getAll() throws MarketException;

    User getByUsername(User username) throws MarketException;

    User getByEmailAddress(User email) throws MarketException;
}
