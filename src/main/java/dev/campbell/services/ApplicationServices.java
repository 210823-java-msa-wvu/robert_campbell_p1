package dev.campbell.services;

import dev.campbell.models.Employee;
import dev.campbell.models.Reimbursement;
import dev.campbell.models.Update;
import dev.campbell.repositories.ApplicationRepo;
import dev.campbell.repositories.EmployeeRepo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ApplicationServices {

    ApplicationRepo ar = new ApplicationRepo();
    EmployeeRepo emprepo = new EmployeeRepo();


    public void addReimbursement(Reimbursement r) {

        System.out.println("hello from addReimbursement");

        int employeeId = r.getEmpId();
        Employee e = emprepo.getById(employeeId);


        BigDecimal reimburseAmount = e.getReimbursement();
        BigDecimal reimburseProj = r.getReimbursementProject();

        ar.create(r);

        e.setReimbursement(reimburseAmount.subtract(reimburseProj));

        emprepo.update(e);


    }

    public ArrayList<Reimbursement> getByEmployeeID(Integer id){

         return ar.getByEmployeeID(id);

    }

    public ArrayList<Reimbursement> getByDeptID(int dept) {

        return ar.getByDeptID(dept);
    }

    public ArrayList<Reimbursement> getBySuperID(int id) {

        return ar.getBySuperID(id);
    }

    public ArrayList<Reimbursement> getByAccept() {

        return ar.getByAccept();

    }

    public void bencoUpdate(Update u) {

        if (u.isAppaccept()){
            ar.bencoUpdate(u);
        } else {
            ar.bencoUpdate(u);
            Employee e = emprepo.getById(u.getEmpid());
            Reimbursement r = ar.getById(u.getAppid());

            e.setReimbursement(e.getReimbursement().add(r.getReimbursementProject()));

            emprepo.update(e);
        }

    }

    public void directsuperUpdate(Update u) {
        if (u.isAppaccept()){
            ar.directsuperUpdate(u);
        } else {
            ar.directsuperUpdate(u);
            Employee e = emprepo.getById(u.getEmpid());
            Reimbursement r = ar.getById(u.getAppid());

            e.setReimbursement(e.getReimbursement().add(r.getReimbursementProject()));

            emprepo.update(e);
        }
    }

    public void deptheadUpdate(Update u) {
        if (u.isAppaccept()){
            ar.deptheadUpdate(u);
        } else {
            ar.deptheadUpdate(u);
            Employee e = emprepo.getById(u.getEmpid());
            Reimbursement r = ar.getById(u.getAppid());


            e.setReimbursement(e.getReimbursement().add(r.getReimbursementProject()));


            emprepo.update(e);
        }
    }
}
