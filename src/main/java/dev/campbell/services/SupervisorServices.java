package dev.campbell.services;

import dev.campbell.models.Supervisor;
import dev.campbell.repositories.SupervisorRepo;

public class SupervisorServices {

    SupervisorRepo suprepo = new SupervisorRepo();

    public Supervisor login(String username, String password){

        Supervisor s = suprepo.getByUsername(username);

        if (s != null){
            if (username.equals(s.getUsername()) && password.equals(s.getPassword())){
                System.out.println("S:" + s);
                System.out.println("logged in");
                return s;
            }
        }
        return null;
    }

}
