/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idb.db.sqlquery;

import com.idb.model.Staff;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class StaffSqlQueryHandler {

    private static String QUERY_ALL_STAFF = "SELECT * FROM STAFF";
    private static String INSERT_NEW_STAFF = "INSERT INTO STAFF (id,active, birth_date, joining_date, email, image, name) VALUES (?,?,?,?,?,?,?)";
    private static String REMOVE_STAFF = "DELETE FROM STAFF WHERE id = ?";
    private static String GET_STAFF_BY_ID = "SELECT * FROM STAFF WHERE id = ?";
    private static String UPDATE_STAFF_BY_ID = "UPDATE STAFF SET active = ?, birth_date = ?, joining_date = ?, email = ?, image = ?, name = ? WHERE id = ?";

    /**
     * This method returns all the products from the DB
     *
     * @param connection
     * @return
     * @throws SQLException
     */
    public ArrayList<Staff> getAllProducts(Connection connection) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Staff> staffList = new ArrayList<Staff>();
        try {
            ps = connection.prepareStatement(QUERY_ALL_STAFF);

            rs = ps.executeQuery();
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setId(Integer.valueOf(rs.getString("id")));
                staff.setActive(rs.getBoolean("active"));
                staff.setBirthDate(rs.getString("birth_date"));
                staff.setJoiningDate(rs.getString("joining_date"));
                staff.setEmail(rs.getString("email"));
                staff.setImage(rs.getString("image"));
                staff.setName(rs.getString("name"));
                staffList.add(staff);
            }

        } finally {
            closeStatement(ps);
            closeResultSet(rs);
            closeConnection(connection);
        }

        return staffList;
    }

   
    public void addNewProduct(Connection connection, Staff staff) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = connection
                    .prepareStatement(INSERT_NEW_STAFF);
            ps.setInt(1, staff.getId());
            ps.setBoolean(2, staff.isActive());
            ps.setString(3, staff.getBirthDate());
            ps.setString(4, staff.getJoiningDate());
            ps.setString(5, staff.getEmail());
            ps.setString(6, staff.getImage());
            ps.setString(7, staff.getName());
            System.out.println(ps);
            ps.execute();

        } finally {
            closeConnection(connection);
            closeStatement(ps);
        }

    }

    /**
     * This method removes an object based on the product ID
     *
     * @param connection
     * @param id
     * @throws SQLException
     */
    public void removeProdById(Connection connection, String id) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(REMOVE_STAFF);
            ps.setInt(1, Integer.valueOf(id));
            ps.execute();

        } finally {
            closeConnection(connection);
            closeStatement(ps);
        }
    }

    /**
     * This method retrieves a product from the DB based on its ID
     *
     * @param connection
     * @param id
     * @return
     * @throws SQLException
     */
    public Staff getProdById(Connection connection, String id) throws SQLException {
        Staff staff = new Staff();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection
                    .prepareStatement(GET_STAFF_BY_ID);

            ps.setInt(1, Integer.valueOf(id));

            rs = ps.executeQuery();

            if (rs != null && rs.next()) {
                staff.setId(rs.getInt("id"));
                staff.setActive(rs.getBoolean("active"));
                staff.setBirthDate(rs.getString("birth_date"));
                staff.setJoiningDate(rs.getString("joining_date"));
                staff.setEmail(rs.getString("email"));
                staff.setImage(rs.getString("image"));
                staff.setName(rs.getString("name"));

            }

        } finally {
            closeStatement(ps);
            closeResultSet(rs);
            closeConnection(connection);
        }

        return staff;
    }

    /**
     * This method updates a product in the DB
     *
     * @param connection
     * @param aProd
     * @throws SQLException
     */
    public void updateProdById(Connection connection, Staff staff) throws SQLException {
    
        PreparedStatement ps = null;
        try {
            ps = connection
                    .prepareStatement(UPDATE_STAFF_BY_ID);
            ps.setBoolean(1, staff.isActive());
            ps.setString(2, staff.getBirthDate());
            ps.setString(3, staff.getJoiningDate());
            ps.setString(4, staff.getEmail());
            ps.setString(5, staff.getImage());
            ps.setString(6, staff.getName());
            ps.setInt(7, staff.getId());
            System.out.println(ps);
            ps.execute();

        } finally {
            closeConnection(connection);
            closeStatement(ps);
        }
    }

    private void closeStatement(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            ps.close();
        }
    }

    private void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }

    private void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
