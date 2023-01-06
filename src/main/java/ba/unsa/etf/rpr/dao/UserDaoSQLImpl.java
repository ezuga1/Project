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
    public UserDaoSQLImpl() {

        super("User");
    }

    @Override
    public User row2object(ResultSet rs) throws MarketException {
        try{
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setUsername(rs.getString("surname"));
            user.setEmailAddress(rs.getString("email_address"));
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
        return item;
    }


    public User getByUsername(User username) throws MarketException {
        String query = "SELECT * FROM User WHERE username = ?";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setInt(1, username.getId());
            ResultSet rs = stmt.executeQuery();
            User user = new User();
            if(rs.next())
                user = row2object(rs);
            return user;
        }
        catch (SQLException e){
            throw new MarketException(e.getMessage(), e);
        }
    }
    public User getByEmailAddress(User email) throws MarketException {
        String query = "SELECT * FROM User WHERE email_address = ?";
        try{
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setInt(1, email.getId());
            ResultSet rs = stmt.executeQuery();
            User user = new User();
            if(rs.next())
                user = row2object(rs);
            return user;
        }
        catch (SQLException e){
            throw new MarketException(e.getMessage(), e);
        }
    }
}
