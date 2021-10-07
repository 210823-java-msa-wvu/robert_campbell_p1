package dev.campbell.servlets;

import dev.campbell.controllers.FrontController;
import org.apache.catalina.servlets.DefaultServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontControllerServlet extends DefaultServlet {

    private RequestHandler rh = new RequestHandler();

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // first check if trying to access static resources
        String uriNoContext = request.getRequestURI().substring(request.getContextPath().length());
        //log.trace(uriNoContext);
        System.out.println("hello from FrontControllerServlet");

        if (uriNoContext.startsWith("/static")) {
            //log.trace("Accessing static resources and trying to forward....");
            System.out.println("hello from if fcs");
            super.doGet(request, response);
        } else {
            // We want to 'get' the correct servlet based on the uri
            //log.trace("Not static...Getting the appropriate controller...");
            System.out.println("hello from else fcs");
            FrontController fc = rh.handle(request, response);

            // check first to make sure it's not null
            if (fc != null) {
                //log.trace("Processing request...");
                fc.process(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

}
