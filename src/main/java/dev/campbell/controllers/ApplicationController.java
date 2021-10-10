package dev.campbell.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.campbell.models.Reimbursement;
import dev.campbell.services.ApplicationServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ApplicationController implements FrontController{

    private ObjectMapper om = new ObjectMapper();
    private ApplicationServices as = new ApplicationServices();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Hello from applicationcontroller");

        System.out.println(request);
        Reimbursement r = om.readValue(request.getReader(), Reimbursement.class);
        System.out.println("readvalue = " + r);

        as.addReimbursement(r);

    }
}
