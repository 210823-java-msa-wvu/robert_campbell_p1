package dev.campbell.repositories;

import dev.campbell.models.Reimbursement;
import dev.campbell.models.Update;
import dev.campbell.utils.ConnectionUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

    public ArrayList<Reimbursement> getByEmployeeID(Integer id){

        ArrayList<Reimbursement> reimbursements = new ArrayList<>();

        try (Connection conn = cu.getConnection()){

            String sql = "select * from reimbursements where employeeid = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Reimbursement r = new Reimbursement();

                r.setId(rs.getInt("id"));
                r.setEmpId(rs.getInt("employeeid"));
                r.setEmpFirstName(rs.getString("employeefirstname"));
                r.setEmpLastName(rs.getString("employeelastname"));
                r.setEventDate(rs.getDate("eventdate"));
                r.setApplyDate(rs.getDate("applydate"));
                r.setLocation(rs.getString("eventlocation"));
                r.setDescription(rs.getString("description"));
                r.setCost(rs.getBigDecimal("cost"));
                r.setGradeRequirement(rs.getInt("graderequirement"));
                r.setWorkJustification(rs.getString("workjustification"));
                r.setReimbursementProject(rs.getBigDecimal("reimbursementprojection"));
                r.setDsapproval(rs.getBoolean("directsupervisorapproval"));
                r.setDsreject(rs.getBoolean("directsupervisorreject"));
                r.setDscomment(rs.getString("directsupervisorcomment"));
                r.setDhapproval(rs.getBoolean("deptheadapprove"));
                r.setDhreject(rs.getBoolean("deptheadreject"));
                r.setDhcomment(rs.getString("deptheadcomment"));
                r.setBcapproval(rs.getBoolean("bencoapprove"));
                r.setBcreject(rs.getBoolean("bencoreject"));
                r.setBccomment(rs.getString("bencocomment"));
                r.setUrgent(rs.getBoolean("urgent"));
                r.setDsid(rs.getInt("directsupervisorid"));
                r.setApproved(rs.getBoolean("approved"));
                r.setDenied(rs.getBoolean("denied"));
                r.setPayed(rs.getBoolean("payed"));
                r.setRejected(rs.getBoolean("rejected"));
                r.setPassed(rs.getBoolean("passed"));
                r.setFailed(rs.getBoolean("failed"));

                reimbursements.add(r);
            }

            return reimbursements;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public Reimbursement getById(Integer id) {

        try (Connection conn = cu.getConnection()){

            String sql = "select * from reimbursements where id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Reimbursement r = new Reimbursement();

                r.setId(rs.getInt("id"));
                r.setEmpId(rs.getInt("employeeid"));
                r.setEmpFirstName(rs.getString("employeefirstname"));
                r.setEmpLastName(rs.getString("employeelastname"));
                r.setEventDate(rs.getDate("eventdate"));
                r.setApplyDate(rs.getDate("applydate"));
                r.setLocation(rs.getString("eventlocation"));
                r.setDescription(rs.getString("description"));
                r.setCost(rs.getBigDecimal("cost"));
                r.setGradeRequirement(rs.getInt("graderequirement"));
                r.setWorkJustification(rs.getString("workjustification"));
                r.setReimbursementProject(rs.getBigDecimal("reimbursementprojection"));
                r.setDsapproval(rs.getBoolean("directsupervisorapproval"));
                r.setDsreject(rs.getBoolean("directsupervisorreject"));
                r.setDscomment(rs.getString("directsupervisorcomment"));
                r.setDhapproval(rs.getBoolean("deptheadapprove"));
                r.setDhreject(rs.getBoolean("deptheadreject"));
                r.setDhcomment(rs.getString("deptheadcomment"));
                r.setBcapproval(rs.getBoolean("bencoapprove"));
                r.setBcreject(rs.getBoolean("bencoreject"));
                r.setBccomment(rs.getString("bencocomment"));
                r.setUrgent(rs.getBoolean("urgent"));
                r.setDsid(rs.getInt("directsupervisorid"));
                r.setApproved(rs.getBoolean("approved"));
                r.setDenied(rs.getBoolean("denied"));
                r.setPayed(rs.getBoolean("payed"));
                r.setRejected(rs.getBoolean("rejected"));
                r.setPassed(rs.getBoolean("passed"));
                r.setFailed(rs.getBoolean("failed"));

                return r;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(Reimbursement reimbursement) {

    }

    @Override
    public void delete(Integer id) {

    }

    public ArrayList<Reimbursement> getByDeptID(int dept) {
        ArrayList<Reimbursement> reimbursements = new ArrayList<>();

        try (Connection conn = cu.getConnection()){

            String sql = "select r.* from reimbursements r left join employees e  on r.employeeid = e.id where e.department = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, dept);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Reimbursement r = new Reimbursement();

                r.setId(rs.getInt("id"));
                r.setEmpId(rs.getInt("employeeid"));
                r.setEmpFirstName(rs.getString("employeefirstname"));
                r.setEmpLastName(rs.getString("employeelastname"));
                r.setEventDate(rs.getDate("eventdate"));
                r.setApplyDate(rs.getDate("applydate"));
                r.setLocation(rs.getString("eventlocation"));
                r.setDescription(rs.getString("description"));
                r.setCost(rs.getBigDecimal("cost"));
                r.setGradeRequirement(rs.getInt("graderequirement"));
                r.setWorkJustification(rs.getString("workjustification"));
                r.setReimbursementProject(rs.getBigDecimal("reimbursementprojection"));
                r.setDsapproval(rs.getBoolean("directsupervisorapproval"));
                r.setDsreject(rs.getBoolean("directsupervisorreject"));
                r.setDscomment(rs.getString("directsupervisorcomment"));
                r.setDhapproval(rs.getBoolean("deptheadapprove"));
                r.setDhreject(rs.getBoolean("deptheadreject"));
                r.setDhcomment(rs.getString("deptheadcomment"));
                r.setBcapproval(rs.getBoolean("bencoapprove"));
                r.setBcreject(rs.getBoolean("bencoreject"));
                r.setBccomment(rs.getString("bencocomment"));
                r.setUrgent(rs.getBoolean("urgent"));
                r.setDsid(rs.getInt("directsupervisorid"));
                r.setApproved(rs.getBoolean("approved"));
                r.setDenied(rs.getBoolean("denied"));
                r.setPayed(rs.getBoolean("payed"));
                r.setRejected(rs.getBoolean("rejected"));
                r.setPassed(rs.getBoolean("passed"));
                r.setFailed(rs.getBoolean("failed"));

                reimbursements.add(r);
            }

            return reimbursements;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public ArrayList<Reimbursement> getBySuperID(int id) {

        ArrayList<Reimbursement> reimbursements = new ArrayList<>();

        try (Connection conn = cu.getConnection()){

            String sql = "select * from reimbursements where directsupervisorid = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Reimbursement r = new Reimbursement();

                r.setId(rs.getInt("id"));
                r.setEmpId(rs.getInt("employeeid"));
                r.setEmpFirstName(rs.getString("employeefirstname"));
                r.setEmpLastName(rs.getString("employeelastname"));
                r.setEventDate(rs.getDate("eventdate"));
                r.setApplyDate(rs.getDate("applydate"));
                r.setLocation(rs.getString("eventlocation"));
                r.setDescription(rs.getString("description"));
                r.setCost(rs.getBigDecimal("cost"));
                r.setGradeRequirement(rs.getInt("graderequirement"));
                r.setWorkJustification(rs.getString("workjustification"));
                r.setReimbursementProject(rs.getBigDecimal("reimbursementprojection"));
                r.setDsapproval(rs.getBoolean("directsupervisorapproval"));
                r.setDsreject(rs.getBoolean("directsupervisorreject"));
                r.setDscomment(rs.getString("directsupervisorcomment"));
                r.setDhapproval(rs.getBoolean("deptheadapprove"));
                r.setDhreject(rs.getBoolean("deptheadreject"));
                r.setDhcomment(rs.getString("deptheadcomment"));
                r.setBcapproval(rs.getBoolean("bencoapprove"));
                r.setBcreject(rs.getBoolean("bencoreject"));
                r.setBccomment(rs.getString("bencocomment"));
                r.setUrgent(rs.getBoolean("urgent"));
                r.setDsid(rs.getInt("directsupervisorid"));
                r.setApproved(rs.getBoolean("approved"));
                r.setDenied(rs.getBoolean("denied"));
                r.setPayed(rs.getBoolean("payed"));
                r.setRejected(rs.getBoolean("rejected"));
                r.setPassed(rs.getBoolean("passed"));
                r.setFailed(rs.getBoolean("failed"));

                reimbursements.add(r);
            }

            return reimbursements;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<Reimbursement> getByAccept() {
        ArrayList<Reimbursement> reimbursements = new ArrayList<>();

        try (Connection conn = cu.getConnection()){

            String sql = "select * from reimbursements r where deptheadapprove = true and directsupervisorapproval = true;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Reimbursement r = new Reimbursement();

                r.setId(rs.getInt("id"));
                r.setEmpId(rs.getInt("employeeid"));
                r.setEmpFirstName(rs.getString("employeefirstname"));
                r.setEmpLastName(rs.getString("employeelastname"));
                r.setEventDate(rs.getDate("eventdate"));
                r.setApplyDate(rs.getDate("applydate"));
                r.setLocation(rs.getString("eventlocation"));
                r.setDescription(rs.getString("description"));
                r.setCost(rs.getBigDecimal("cost"));
                r.setGradeRequirement(rs.getInt("graderequirement"));
                r.setWorkJustification(rs.getString("workjustification"));
                r.setReimbursementProject(rs.getBigDecimal("reimbursementprojection"));
                r.setDsapproval(rs.getBoolean("directsupervisorapproval"));
                r.setDsreject(rs.getBoolean("directsupervisorreject"));
                r.setDscomment(rs.getString("directsupervisorcomment"));
                r.setDhapproval(rs.getBoolean("deptheadapprove"));
                r.setDhreject(rs.getBoolean("deptheadreject"));
                r.setDhcomment(rs.getString("deptheadcomment"));
                r.setBcapproval(rs.getBoolean("bencoapprove"));
                r.setBcreject(rs.getBoolean("bencoreject"));
                r.setBccomment(rs.getString("bencocomment"));
                r.setUrgent(rs.getBoolean("urgent"));
                r.setDsid(rs.getInt("directsupervisorid"));
                r.setApproved(rs.getBoolean("approved"));
                r.setDenied(rs.getBoolean("denied"));
                r.setPayed(rs.getBoolean("payed"));
                r.setRejected(rs.getBoolean("rejected"));
                r.setPassed(rs.getBoolean("passed"));
                r.setFailed(rs.getBoolean("failed"));

                reimbursements.add(r);
            }

            return reimbursements;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public void bencoUpdate(Update u) {
        try (Connection conn = cu.getConnection()){

            System.out.println("Hello from bencoupdate");

            String sql = "update reimbursements set bencoapprove = ?, bencoreject = ?, bencocomment = ?, passed = ?, failed = ?, payed = ? where id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, u.isAppaccept());
            ps.setBoolean(2, u.isAppreject());
            ps.setString(3, u.getComment());
            ps.setBoolean(4, u.isGrapass());
            ps.setBoolean(5, u.isGrafail());
            ps.setBoolean(6, u.isPayed());
            ps.setInt(7, u.getAppid());


            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void directsuperUpdate(Update u) {
        try (Connection conn = cu.getConnection()){

            System.out.println("Hello from directsuperupdate");

            String sql = "update reimbursements set directsupervisorapproval = ?, directsupervisorreject = ?, directsupervisorcomment = ? where id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, u.isAppaccept());
            ps.setBoolean(2, u.isAppreject());
            ps.setString(3, u.getComment());
            ps.setInt(4, u.getAppid());

            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deptheadUpdate(Update u) {
        try (Connection conn = cu.getConnection()){

            System.out.println("Hello from deptheadupdate");

            String sql = "update reimbursements set deptheadapprove = ?, deptheadreject = ?, deptheadcomment = ? where id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, u.isAppaccept());
            ps.setBoolean(2, u.isAppreject());
            ps.setString(3, u.getComment());
            ps.setInt(4, u.getAppid());

            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
