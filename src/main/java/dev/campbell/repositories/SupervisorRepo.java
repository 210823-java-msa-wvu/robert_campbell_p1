package dev.campbell.repositories;

import dev.campbell.models.Supervisor;
import dev.campbell.utils.ConnectionUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupervisorRepo implements CrudInterface<Supervisor>{

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
    
    @Override
    public Supervisor add(Supervisor supervisor) {
        return null;
    }

    @Override
    public Supervisor getById(Integer id) {
        return null;
    }
    
    public Supervisor getByUsername(String username) {
        
        try (Connection conn = cu.getConnection()){

            System.out.println("Hello From SupervisorRepo");

            String sql = "select * from supervisors where username = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Supervisor sup = new Supervisor(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("position"),
                        rs.getInt("department"),
                        rs.getString("email")
                );
                return sup;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
    @Override
    public void update(Supervisor supervisor) {

    }

    @Override
    public void delete(Integer id) {

    }
}
