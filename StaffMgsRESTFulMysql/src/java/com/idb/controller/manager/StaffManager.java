
package com.idb.controller.manager;


import com.idb.db.sqlquery.StaffSqlQueryHandler;
import com.idb.dbconfig.DbConnection;
import com.idb.model.Staff;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class StaffManager {

    public ArrayList<Staff> getAllProducts() {
        ArrayList<Staff> list = new ArrayList<Staff>();

        try {
            DbConnection db = new DbConnection();
            Connection connection = db.getConnection();
            StaffSqlQueryHandler handler = new StaffSqlQueryHandler();
            list = handler.getAllProducts(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void addNewProduct(Staff staff) throws Exception {

        DbConnection db = new DbConnection();
        Connection connection = db.getConnection();
        StaffSqlQueryHandler handler = new StaffSqlQueryHandler();
        handler.addNewProduct(connection, staff);

    }

    public void removeProdById(String id) {
        try {
            DbConnection db = new DbConnection();
            Connection connection = db.getConnection();
            StaffSqlQueryHandler handler = new StaffSqlQueryHandler();
            handler.removeProdById(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Staff getProductById(String id) {
        Staff staff = new Staff();

        try {
            DbConnection db = new DbConnection();
            Connection connection = db.getConnection();
            StaffSqlQueryHandler handler = new StaffSqlQueryHandler();
            staff = handler.getProdById(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return staff;
    }

    public void updateProductById(Staff aProd) {
        try {
            DbConnection db = new DbConnection();
            Connection connection = db.getConnection();
            StaffSqlQueryHandler handler = new StaffSqlQueryHandler();
            handler.updateProdById(connection, aProd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
