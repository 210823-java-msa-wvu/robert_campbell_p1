package dev.campbell.services;

import dev.campbell.models.Employee;
import dev.campbell.models.Reimbursement;
import dev.campbell.repositories.ApplicationRepo;
import dev.campbell.repositories.EmployeeRepo;

import java.math.BigDecimal;

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
}
