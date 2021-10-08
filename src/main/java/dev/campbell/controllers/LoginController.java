package dev.campbell.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.campbell.models.Employee;
import dev.campbell.services.EmployeeServices;
import dev.campbell.models.User;
import dev.campbell.services.SupervisorServices;
import dev.campbell.models.Supervisor;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController implements FrontController{

    private EmployeeServices es = new EmployeeServices();
    private ObjectMapper om = new ObjectMapper();
    private SupervisorServices ss = new SupervisorServices();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        User u= om.readValue(request.getReader(), User.class);
        System.out.println("readvalue " + u);

        String username = u.getUsername();
        String password = u.getPassword();
        String position = u.getPosition();
        System.out.println("Username: " + username + " Password: " + password);

        if (position.equals("employee")) {
            if (es.login(username, password) != null) {
                System.out.println("es.login" + es.login(username, password));
                //            Cookie cookie = new Cookie("empcookie", om.writeValueAsString(es.login(username, password)));
                //            response.addCookie(cookie);
                response.getWriter().write(om.writeValueAsString(es.login(username, password)));
                response.setStatus(200);
                //System.out.println("cookie" + cookie.getValue());
                //response.sendRedirect("static/EmployeeHomePage.html");
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Login Credentials");
            }
        }

        if (position.equals("supervisor")) {
            if (ss.login(username, password) != null) {
                System.out.println("ss.login" + ss.login(username, password));
                //            Cookie cookie = new Cookie("empcookie", om.writeValueAsString(es.login(username, password)));
                //            response.addCookie(cookie);
                response.getWriter().write(om.writeValueAsString(ss.login(username, password)));
                response.setStatus(200);
                //System.out.println("cookie" + cookie.getValue());
                //response.sendRedirect("static/EmployeeHomePage.html");
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Login Credentials");
            }
        }

    }
}
