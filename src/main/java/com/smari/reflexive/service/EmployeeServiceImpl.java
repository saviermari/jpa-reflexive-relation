package com.smari.reflexive.service;

import com.smari.reflexive.dao.EmployeeRepository;
import com.smari.reflexive.entity.Employee;
import com.smari.reflexive.mapper.EmployeeMapper;
import com.smari.reflexive.dto.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author smari
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeMapper mapper;

    @Override
    public EmployeeModel createEmployee(EmployeeModel model) {
          Employee employee = mapper.convertModelToEntity(model);
          Employee manager = mapper.convertModelToEntity(model.getManager());
          if(model.getManager() != null && model.getManager().getId()!=null){
              manager = repository.getById(model.getManager().getId());
              employee.setManager(manager);
          }else{
              employee.setManager(manager);
          }
         return mapper.convertEntityToModel(repository.save(employee));
    }

    @Override
    public EmployeeModel updateEmployee(Long id, EmployeeModel model) {
        Employee employee = repository.getById(id);
        employee.setFirstName(model.getFirstName());
        employee.setLastName(model.getLastName());
        if(model.getManager() != null && model.getManager().getId()!=null) {
            Employee manager = repository.getById(model.getManager().getId());
            employee.setManager(manager);
        }
        return mapper.convertEntityToModel(repository.save(employee));
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    @Override
    public EmployeeModel getEmployee(Long id) {
        return mapper.convertEntityToModel(repository.getById(id));
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<Employee> employees = repository.findAll();
        List<EmployeeModel>  employeeModels = employees.stream().map(mapper::convertEntityToModel).collect(Collectors.toList());
        return employeeModels;
    }

    @Override
    public List<EmployeeModel> getReports(Long id) {
        Employee manager = repository.getById(id);
        List<Employee> employees = manager.getEmployees();
        List<EmployeeModel>  employeeModels = employees.stream().map(mapper::convertEntityToModel).collect(Collectors.toList());
        return employeeModels;
    }
}
