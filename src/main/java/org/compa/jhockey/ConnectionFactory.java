/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compa.jhockey;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ElKebabHenry
 */
public class ConnectionFactory {
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        String user = "root";
        String password ="";
        String url = "jdbc:mysql://localhost/";
        String database = "webbshop";
        Class.forName("com.mysql.jdbc.Driver");
        return (Connection) DriverManager.getConnection(url+database, user, password);
    }
    
}
