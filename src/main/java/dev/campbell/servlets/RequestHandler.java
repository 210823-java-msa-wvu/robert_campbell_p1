package dev.campbell.servlets;

import dev.campbell.controllers.ApplicationController;
import dev.campbell.controllers.FrontController;
import dev.campbell.controllers.LoginController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler {

    // A map to hold the different controllers that we will be creating
    private Map<String, FrontController> controllerMap;

    {
        controllerMap = new HashMap<String, FrontController>();

        controllerMap.put("emplogin", new LoginController());
        controllerMap.put("suplogin", new LoginController());
        controllerMap.put("apply", new ApplicationController());

    }

    // a method to return the appropriate controller
    public FrontController handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // This is where the logic will go to parse the URI and send back the appropriate controller
        StringBuilder uriString = new StringBuilder(request.getRequestURI()); // uri = /LibraryServlet/books/1
        System.out.println("hello from request uri");
        System.out.println(uriString);

        // Remove context path
        uriString.replace(0, request.getContextPath().length() + 1, ""); // now we have => books/1
        System.out.println("hello from contextpath");
        System.out.println(uriString);


        if (uriString.indexOf("html") != -1) {
            request.setAttribute("static", uriString.toString());
            System.out.println("hello from static");
            return controllerMap.get(uriString.toString());
        }

        if (uriString.indexOf("/") != -1) {
            request.setAttribute("path", uriString.substring(uriString.indexOf("/") + 1)); // this will set the attribute 'path' to '1'
            uriString.replace(uriString.indexOf("/"), uriString.length() +1, ""); // at this point uriString = 'books'
            System.out.println(uriString.replace(uriString.indexOf("/"), uriString.length() +1, ""));
        }

        return controllerMap.get(uriString.toString());

    }

}
