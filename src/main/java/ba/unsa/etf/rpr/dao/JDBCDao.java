package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class JDBCDao {

    private static final String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_Tech_Market";
    private static final String usrnm = "freedb_ezuga1";
    private static final String pw = "yCjgsz%m#TSQ*3q";
    private static final String insertQuery = "INSERT INTO User (username, email_address, password) VALUES (?, ?, ?)";

    //Step 1: Establishing a Connection and try-catch resource statement will auto close the connection.

    public void insertUser(String name, String email, String password){
        //Step 1: Establishing a Connection, auto close the connection.

        try(Connection conn = DriverManager.getConnection(url,usrnm,pw);
            //Step 2: Create a statement using connection object
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3,password);
            System.out.println(preparedStatement);
            //Step 3: Execute the query or update query
            preparedStatement.executeUpdate();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }




}
