package dev.campbell.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.campbell.models.Employee;
import dev.campbell.services.EmployeeServices;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController implements FrontController{

    private EmployeeServices es = new EmployeeServices();
    private ObjectMapper om = new ObjectMapper();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Employee e = om.readValue(request.getReader(), Employee.class);
        System.out.println("readvalue" + e);

        String username = e.getUsername();
        String password = e.getPassword();
        System.out.println("Username: " + username + " Password: " + password);
        if (es.login(username, password) != null){
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
}
