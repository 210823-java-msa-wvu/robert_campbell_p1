package dev.campbell.repositories;

import dev.campbell.models.Reimbursement;
import dev.campbell.utils.ConnectionUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ApplicationRepo implements CrudInterface<Reimbursement>{

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();


    @Override
    public Reimbursement add(Reimbursement reimbursement) {

        return null;
    }

    public boolean create(Reimbursement reimbursement){

        try (Connection conn = cu.getConnection()){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            System.out.println("hello from application create");

            System.out.println("eventdate: " + reimbursement.getEventDate());

            String sql = "insert into reimbursements (id, employeeid, employeefirstname, employeelastname, eventdate, applydate, eventlocation, description, cost, graderequirement, workjustification, reimbursementprojection, directsupervisorid) values (default, ?, ?, ?, ?, default, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimbursement.getEmpId());
            ps.setString(2, reimbursement.getEmpFirstName());
            ps.setString(3, reimbursement.getEmpLastName());
            ps.setDate(4, Date.valueOf(dateFormat.format(reimbursement.getEventDate())));
            ps.setString(5, reimbursement.getLocation());
            ps.setString(6, reimbursement.getDescription());
            ps.setBigDecimal(7, reimbursement.getCost());
            ps.setInt(8, reimbursement.getGradeRequirement());
            ps.setString(9, reimbursement.getWorkJustification());
            ps.setBigDecimal(10, reimbursement.getReimbursementProject());
            ps.setInt(11,reimbursement.getDsid());

            boolean complete = ps.executeUpdate() != 0;


            System.out.println("Reimbursement was successful:");

            return complete;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public Reimbursement getById(Integer id) {
        return null;
    }

    @Override
    public void update(Reimbursement reimbursement) {

    }

    @Override
    public void delete(Integer id) {

    }
}
