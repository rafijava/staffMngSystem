package com.idb.controller;

import com.google.gson.Gson;
import com.idb.controller.manager.StaffManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.idb.model.Staff;
import java.util.List;

@Path("/demo")
public class StaffController {

    // This is the default @PATH
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Staff> getAllStaffs() {

        List<Staff> staffList = new ArrayList<Staff>();

        StaffManager manager = new StaffManager();
        staffList = manager.getAllProducts();
        Gson gson = new Gson();
        String json = gson.toJson(staffList);
		
        return staffList;
    }

    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Staff getStaffById(@PathParam("id") String id) {
        System.out.println("Getting staff by ID: " + id);
        
           Staff staff = new Staff();

        StaffManager manager = new StaffManager();
        System.out.println("The product with id: " + id + " will be gotten from the list");
        staff = manager.getProductById(id);

        if (staff != null) {
//            logger.info("Inside getStaffById, returned: " + staff.toString());
        } else {
//            logger.info("Inside getStaffById, ID: " + id + ", NOT FOUND!");
        }
        return staff;
    }

    @Path("{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Staff updateStaff(Staff staff) {

        StaffManager manager = new StaffManager();
        System.out.println("The product with id: " + staff.getId() + " will be updated");
        System.out.println(staff.toString());
        manager.updateProductById(staff);
        System.out.println("updateStaff with ID: " + staff.getId());
        if (staff != null) {
//            logger.info("Inside updateStaff, returned: " + staff.toString());
        } else {
//            logger.info("Inside updateStaff, ID: " + staff.getId() + ", NOT FOUND!");
        }
        return staff;
    }

    @Path("/search/{query}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<Staff> searchStaffByName(@PathParam("query") String query) {
        ArrayList<Staff> staffs = new ArrayList<Staff>();
        ArrayList<Staff> staffList = new ArrayList<Staff>();
        StaffManager manager = new StaffManager();

        staffList = manager.getAllProducts();
        System.out.println("Searching staff by Name: " + query);
        for (Staff c : staffs) {
            if (c.getName().toUpperCase().contains(query.toUpperCase())) {
                staffList.add(c);
            }
        }
        return staffList;
    }

    @Path("/add")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Staff addStaff(Staff staff) {
        try {

            if (staff != null) {
                System.out.println("Adding staff with ID: " + staff.getId());
                StaffManager manager = new StaffManager();
                manager.addNewProduct(staff);
                System.out.println("Staffs are now: " + staff);
            } else {
                System.out.println("Inside addStaff, Unable to add staffs...");
            }
        } catch (Exception ex) {
        }
        return staff;
    }

    @Path("{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Boolean deleteStaffById(@PathParam("id") String id) {
        System.out.println("Deleting staff with ID: " + id);

        StaffManager manager = new StaffManager();
        System.out.println("The product with id: " + id + " will be removed from the list");
        manager.removeProdById(id);

        return Boolean.TRUE;
    }
}
