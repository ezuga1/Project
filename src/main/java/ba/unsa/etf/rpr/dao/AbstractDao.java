package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Idable;
import ba.unsa.etf.rpr.exceptions.MarketException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public abstract class AbstractDao <T extends Idable> implements Dao<T>{
    private Connection connection;
    private String tableName;

    public AbstractDao(String tableName){
        try {
            this.tableName = tableName;
            Properties p = new Properties();
            p.load(ClassLoader.getSystemResource("app.properties").openStream());
            this.connection = DriverManager.getConnection(p.getProperty("db.connection_string"), p.getProperty("db.username"),p.getProperty("db.password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.connection;
    }
    public abstract T row2object(ResultSet rs) throws MarketException;
    public abstract Map<String, Object> object2row(T object);

    public T getById(int id) throws MarketException{
        String query = "SELECT * FROM "+this.tableName+"WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){ // result set is iterator.
                T result = row2object(rs);
                rs.close();
                return result;
            }
            else{
                throw new MarketException("Object not found");
            }
        }
        catch (SQLException e){
            throw new MarketException(e.getMessage(), e);
        }
    }
    public List<T> getAll() throws MarketException{
        String query = "SELECT * FROM " + tableName;
        List<T> results = new ArrayList<T>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){ // result set is iterator.
                T object = row2object(rs);
                results.add(object);
            }
            rs.close();
            return results;
        }catch (SQLException e){
            throw new MarketException(e.getMessage(), e);
        }
    }

    public void delete(int id) throws MarketException{
        String sql = "DELETE FROM "+tableName+" WHERE id = ?";
        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new MarketException(e.getMessage(), e);
        }
    }
}
