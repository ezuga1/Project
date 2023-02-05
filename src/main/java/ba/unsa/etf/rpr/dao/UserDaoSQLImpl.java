package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MarketException;
import com.mysql.cj.x.protobuf.MysqlxPrepare;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{

    private static UserDaoSQLImpl instance = null;
    public UserDaoSQLImpl() {

        super("User");
    }

    public static UserDaoSQLImpl getInstance(){
        if(instance == null)
            instance = new UserDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance != null)
            instance = null;
    }

    @Override
    public User row2object(ResultSet rs) throws MarketException {
        try{
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setEmailAddress(rs.getString("email_address"));
            user.setPassword(rs.getString("password"));
            return user;
        }
        catch (SQLException e){
            throw new MarketException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(User object) {
        Map<String, Object> item = new TreeMap<String, Object>();
        item.put("id", object.getId());
        item.put("username", object.getUsername());
        item.put("email_address", object.getEmailAddress());
        item.put("password", object.getPassword());
        return item;
    }


    public User getByUsername(User username) throws MarketException {
        return executeQueryUnique("SELECT * FROM Users WHERE username = ?", new Object[]{username});
    }
    public User getByEmailAddress(User email) throws MarketException {
       return executeQueryUnique("SELECT * FROM Users where emai_address = ?", new Object[]{email});
    }
    @Override
    public boolean validate(String username, String password) throws MarketException{return true;}
}
