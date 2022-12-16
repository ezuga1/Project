package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Idable;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
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
    
}
