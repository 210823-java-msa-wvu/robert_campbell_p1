package dev.campbell.services;

import dev.campbell.models.Employee;
import dev.campbell.repositories.EmployeeRepo;

public class EmployeeServices {

    EmployeeRepo emprepo = new EmployeeRepo();

    public Employee login(String username, String password){

        Employee e = emprepo.getByUsername(username);

        if (e != null){
            if (username.equals(e.getUsername()) && password.equals(e.getPassword())){
                System.out.println(e);
                System.out.println("logged in");
                return e;
            }
        }
        return null;
    }

}
