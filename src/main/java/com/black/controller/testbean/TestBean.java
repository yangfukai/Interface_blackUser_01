package com.black.controller.testbean;

public class TestBean {

    private String first_name;
    private String last_name;
    private String position;
    private String office;
    private String start_date;
    private String salary;

    public TestBean(String first_name, String last_name, String position, String office, String start_date, String salary) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.office = office;
        this.start_date = start_date;
        this.salary = salary;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPosition() {
        return position;
    }

    public String getOffice() {
        return office;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getSalary() {
        return salary;
    }
}
