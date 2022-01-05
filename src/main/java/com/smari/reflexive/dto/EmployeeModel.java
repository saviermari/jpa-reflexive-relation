package com.smari.reflexive.dto;

/**
 * @author smari
 */
public class EmployeeModel {
    private Long id;
    private String firstName;
    private String lastName;
    private EmployeeModel manager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmployeeModel getManager() {
        return manager;
    }

    public void setManager(EmployeeModel manager) {
        this.manager = manager;
    }
}
