package com.smari.reflexive.service;

import com.smari.reflexive.dto.EmployeeModel;

import java.util.List;

/**
 * @author smari
 */
public interface EmployeeService {
    public EmployeeModel createEmployee(EmployeeModel model);
    public EmployeeModel updateEmployee(Long id, EmployeeModel model);
    public void deleteEmployee(Long id);
    public EmployeeModel getEmployee(Long id);
    public List<EmployeeModel> getAllEmployees();
    public List<EmployeeModel> getReports(Long id);
}
