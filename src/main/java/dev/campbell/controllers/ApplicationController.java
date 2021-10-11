package dev.campbell.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.campbell.models.Employee;
import dev.campbell.models.Reimbursement;
import dev.campbell.models.Supervisor;
import dev.campbell.models.Update;
import dev.campbell.services.ApplicationServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class ApplicationController implements FrontController{

    private ObjectMapper om = new ObjectMapper();


    private ApplicationServices as = new ApplicationServices();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        om.setDateFormat(df);
        String uri = request.getRequestURI();

        if (uri.equals("/project1/apply")) {
            System.out.println("Hello from applicationcontroller");

            System.out.println(request);
            Reimbursement r = om.readValue(request.getReader(), Reimbursement.class);
            System.out.println("readvalue = " + r);

            as.addReimbursement(r);

        } else if (uri.equals("/project1/directsuperquery")){
            System.out.println(request);
            Supervisor s = om.readValue(request.getReader(), Supervisor.class);
            System.out.println("readvalue = " + s);
            int id = s.getId();
            response.getWriter().write(om.writeValueAsString(as.getBySuperID(id)));
            response.setStatus(200);

        } else if (uri.equals("/project1/deptheadquery")){
            System.out.println(request);
            Supervisor s = om.readValue(request.getReader(), Supervisor.class);
            System.out.println("readvalue = " + s);
            int dept = s.getDepartment();
            response.getWriter().write(om.writeValueAsString(as.getByDeptID(dept)));
            response.setStatus(200);

        } else if (uri.equals("/project1/bencoquery")){
            System.out.println(request);
            Supervisor s = om.readValue(request.getReader(), Supervisor.class);
            System.out.println("readvalue = " + s);
            //int id = e.getId();
            response.getWriter().write(om.writeValueAsString(as.getByAccept()));
            response.setStatus(200);

        } else if (uri.equals("/project1/empquery")){
            System.out.println(request);
            Employee e = om.readValue(request.getReader(), Employee.class);
            System.out.println("readvalue = " + e);
            int id = e.getId();
            response.getWriter().write(om.writeValueAsString(as.getByEmployeeID(id)));
            response.setStatus(200);

        } else if (uri.equals("/project1/bencoupdate")){
            System.out.println(request);
            Update u  = om.readValue(request.getReader(), Update.class);
            System.out.println("readvalue = " + u);
            as.bencoUpdate(u);

        } else if (uri.equals("/project1/directsuperupdate")){
            System.out.println(request);
            Update u  = om.readValue(request.getReader(), Update.class);
            System.out.println("readvalue = " + u);
            as.directsuperUpdate(u);

        } else if (uri.equals("/project1/deptheadupdate")){
            System.out.println(request);
            Update u  = om.readValue(request.getReader(), Update.class);
            System.out.println("readvalue = " + u);
            as.deptheadUpdate(u);

        }

    }
}
