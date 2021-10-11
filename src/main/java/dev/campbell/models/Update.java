package dev.campbell.models;

public class Update {

    private int appid;
    private int empid;
    private boolean appaccept = false;
    private boolean appreject = false;
    private String comment;
    private boolean grapass = false;
    private boolean grafail = false;
    private boolean payed = false;

    public Update() {
    }

    public Update(int appid, int empid, boolean appaccept, boolean appreject, String comment, boolean grapass, boolean grafail, boolean payed) {
        this.appid = appid;
        this.empid = empid;
        this.appaccept = appaccept;
        this.appreject = appreject;
        this.comment = comment;
        this.grapass = grapass;
        this.grafail = grafail;
        this.payed = payed;
    }

    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public boolean isAppaccept() {
        return appaccept;
    }

    public void setAppaccept(boolean appaccept) {
        this.appaccept = appaccept;
    }

    public boolean isAppreject() {
        return appreject;
    }

    public void setAppreject(boolean appreject) {
        this.appreject = appreject;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isGrapass() {
        return grapass;
    }

    public void setGrapass(boolean grapass) {
        this.grapass = grapass;
    }

    public boolean isGrafail() {
        return grafail;
    }

    public void setGrafail(boolean grafail) {
        this.grafail = grafail;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    @Override
    public String toString() {
        return "Update{" +
                "appid=" + appid +
                ", empid=" + empid +
                ", appaccept=" + appaccept +
                ", appreject=" + appreject +
                ", comment='" + comment + '\'' +
                ", grapass=" + grapass +
                ", grafail=" + grafail +
                ", payed=" + payed +
                '}';
    }
}