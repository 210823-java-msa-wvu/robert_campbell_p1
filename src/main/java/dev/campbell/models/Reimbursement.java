package dev.campbell.models;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reimbursement {

    //private variables for Reimbursement model
    private int id;
    private int empId;
    private String empFirstName;
    private String empLastName;
    private Date eventDate;
    private Date applyDate;
    private String location;
    private String description;
    private BigDecimal cost;
    private int gradeRequirement;
    private String workJustification;
    private BigDecimal reimbursementProject;
    private boolean dsapproval = false;
    private boolean dsreject = false;
    private String dscomment;
    private boolean dhapproval = false;
    private boolean dhreject = false;
    private String dhcomment;
    private boolean bcapproval = false;
    private boolean bcreject = false;
    private String bccomment;
    private boolean urgent = false;
    private int dsid;
    private boolean approved = false;
    private boolean denied = false;
    private boolean payed = false;
    private boolean rejected = false;
    private boolean passed = false;
    private boolean failed = false;

    public Reimbursement() {
    }

    public Reimbursement(int id, int empId, String empFirstName, String empLastName, Date eventDate, Date applyDate, String location, String description, BigDecimal cost, int gradeRequirement, String workJustification, BigDecimal reimbursementProject, boolean dsapproval, boolean dsreject, String dscomment, boolean dhapproval, boolean dhreject, String dhcomment, boolean bcapproval, boolean bcreject, String bccomment, boolean urgent, int dsid, boolean approved, boolean denied, boolean payed, boolean rejected) {
        this.id = id;
        this.empId = empId;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.eventDate = eventDate;
        this.applyDate = applyDate;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.gradeRequirement = gradeRequirement;
        this.workJustification = workJustification;
        this.reimbursementProject = reimbursementProject;
        this.dsapproval = dsapproval;
        this.dsreject = dsreject;
        this.dscomment = dscomment;
        this.dhapproval = dhapproval;
        this.dhreject = dhreject;
        this.dhcomment = dhcomment;
        this.bcapproval = bcapproval;
        this.bcreject = bcreject;
        this.bccomment = bccomment;
        this.urgent = urgent;
        this.dsid = dsid;
        this.approved = approved;
        this.denied = denied;
        this.payed = payed;
        this.rejected = rejected;
    }

    public Reimbursement(int id, int empId, String empFirstName, String empLastName, Date eventDate, Date applyDate, String location, String description, BigDecimal cost, int gradeRequirement, String workJustification, BigDecimal reimbursementProject, boolean dsapproval, boolean dsreject, String dscomment, boolean dhapproval, boolean dhreject, String dhcomment, boolean bcapproval, boolean bcreject, String bccomment, boolean urgent, int dsid, boolean approved, boolean denied, boolean payed, boolean rejected, boolean passed, boolean failed) {
        this.id = id;
        this.empId = empId;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.eventDate = eventDate;
        this.applyDate = applyDate;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.gradeRequirement = gradeRequirement;
        this.workJustification = workJustification;
        this.reimbursementProject = reimbursementProject;
        this.dsapproval = dsapproval;
        this.dsreject = dsreject;
        this.dscomment = dscomment;
        this.dhapproval = dhapproval;
        this.dhreject = dhreject;
        this.dhcomment = dhcomment;
        this.bcapproval = bcapproval;
        this.bcreject = bcreject;
        this.bccomment = bccomment;
        this.urgent = urgent;
        this.dsid = dsid;
        this.approved = approved;
        this.denied = denied;
        this.payed = payed;
        this.rejected = rejected;
        this.passed = passed;
        this.failed = failed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getGradeRequirement() {
        return gradeRequirement;
    }

    public void setGradeRequirement(int gradeRequirement) {
        this.gradeRequirement = gradeRequirement;
    }

    public String getWorkJustification() {
        return workJustification;
    }

    public void setWorkJustification(String workJustification) {
        this.workJustification = workJustification;
    }

    public BigDecimal getReimbursementProject() {
        return reimbursementProject;
    }

    public void setReimbursementProject(BigDecimal reimbursementProject) {
        this.reimbursementProject = reimbursementProject;
    }

    public boolean isDsapproval() {
        return dsapproval;
    }

    public void setDsapproval(boolean dsapproval) {
        this.dsapproval = dsapproval;
    }

    public boolean isDsreject() {
        return dsreject;
    }

    public void setDsreject(boolean dsreject) {
        this.dsreject = dsreject;
    }

    public String getDscomment() {
        return dscomment;
    }

    public void setDscomment(String dscomment) {
        this.dscomment = dscomment;
    }

    public boolean isDhapproval() {
        return dhapproval;
    }

    public void setDhapproval(boolean dhapproval) {
        this.dhapproval = dhapproval;
    }

    public boolean isDhreject() {
        return dhreject;
    }

    public void setDhreject(boolean dhreject) {
        this.dhreject = dhreject;
    }

    public String getDhcomment() {
        return dhcomment;
    }

    public void setDhcomment(String dhcomment) {
        this.dhcomment = dhcomment;
    }

    public boolean isBcapproval() {
        return bcapproval;
    }

    public void setBcapproval(boolean bcapproval) {
        this.bcapproval = bcapproval;
    }

    public boolean isBcreject() {
        return bcreject;
    }

    public void setBcreject(boolean bcreject) {
        this.bcreject = bcreject;
    }

    public String getBccomment() {
        return bccomment;
    }

    public void setBccomment(String bccomment) {
        this.bccomment = bccomment;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public int getDsid() {
        return dsid;
    }

    public void setDsid(int dsid) {
        this.dsid = dsid;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isDenied() {
        return denied;
    }

    public void setDenied(boolean denied) {
        this.denied = denied;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public boolean isRejected() {
        return rejected;
    }

    public void setRejected(boolean rejected) {
        this.rejected = rejected;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", empId=" + empId +
                ", empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                ", eventDate=" + eventDate +
                ", applyDate=" + applyDate +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", gradeRequirement=" + gradeRequirement +
                ", workJustification='" + workJustification + '\'' +
                ", reimbursementProject=" + reimbursementProject +
                ", dsapproval=" + dsapproval +
                ", dsreject=" + dsreject +
                ", dscomment='" + dscomment + '\'' +
                ", dhapproval=" + dhapproval +
                ", dhreject=" + dhreject +
                ", dhcomment='" + dhcomment + '\'' +
                ", bcapproval=" + bcapproval +
                ", bcreject=" + bcreject +
                ", bccomment='" + bccomment + '\'' +
                ", urgent=" + urgent +
                ", dsid=" + dsid +
                ", approved=" + approved +
                ", denied=" + denied +
                ", payed=" + payed +
                ", rejected=" + rejected +
                ", passed=" + passed +
                ", failed=" + failed +
                '}';
    }
}
