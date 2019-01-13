
package com.idb.dbconfig;

import java.sql.*;

public class DbConnection {

    public Connection getConnection() throws Exception {
        try {
            String connectionURL = "jdbc:mysql://localhost:3306/staff_mng";
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, "root", "root");
            return connection;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
}
