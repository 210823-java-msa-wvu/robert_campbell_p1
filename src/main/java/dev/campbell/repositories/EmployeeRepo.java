package dev.campbell.repositories;

import dev.campbell.models.Employee;
import dev.campbell.utils.ConnectionUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRepo implements CrudInterface<Employee>{

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public Employee add(Employee employee) {
        return null;
    }

    @Override
    public Employee getById(Integer id) {
        try (Connection conn = cu.getConnection()) {

            System.out.println("Hello From EmployeeRepo get by id");

            String sql = "select * from employees where id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getBigDecimal("reimbursement"),
                        rs.getInt("department"),
                        rs.getInt("direct_supervisor_id"),
                        rs.getString("email")
                );
                return emp;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Employee getByUsername(String username) {

        try (Connection conn = cu.getConnection()) {

            System.out.println("Hello From EmployeeRepo get by username");

            String sql = "select * from employees where username = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getBigDecimal("reimbursement"),
                        rs.getInt("department"),
                        rs.getInt("direct_supervisor_id"),
                        rs.getString("email")
                );
                return emp;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(Employee employee) {

        try (Connection conn = cu.getConnection()){

            System.out.println("Hello from employeeRepo update");

            String sql = "update employees set reimbursement = ? where id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setBigDecimal(1, employee.getReimbursement());
            ps.setInt(2, employee.getId());
            System.out.println(ps);

            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public void delete(Integer id) {

    }


}
