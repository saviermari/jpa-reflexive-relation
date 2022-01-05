package com.smari.reflexive.mapper;

import com.smari.reflexive.entity.Employee;
import com.smari.reflexive.dto.EmployeeModel;
import org.springframework.stereotype.Component;

/**
 * @author smari
 */
@Component
public class EmployeeMapper {
    public  EmployeeModel convertEntityToModel(Employee entity){
        EmployeeModel employeeModel = new EmployeeModel();
        if(entity != null){
            if(entity.getId() != null) employeeModel.setId(entity.getId());
            employeeModel.setFirstName(entity.getFirstName());
            employeeModel.setLastName(entity.getLastName());
            EmployeeModel managerModel = new EmployeeModel();
            if(entity.getManager() != null){
                if(entity.getManager().getId() != null) managerModel.setId(entity.getManager().getId());
                managerModel.setFirstName(entity.getManager().getFirstName());
                managerModel.setLastName(entity.getManager().getLastName());
                employeeModel.setManager(managerModel);
            }
        }
        return employeeModel;
    }

    public  Employee convertModelToEntity(EmployeeModel model){
        Employee employee = new Employee();
        if(model != null){
            if(model.getId() != null) employee.setId(model.getId());
            employee.setFirstName(model.getFirstName());
            employee.setLastName(model.getLastName());
            Employee manager = new Employee();
            if(model.getManager() != null){
                if(model.getManager().getId() != null) manager.setId(model.getManager().getId());
                manager.setFirstName(model.getManager().getFirstName());
                manager.setLastName(model.getManager().getLastName());
                employee.setManager(manager);
            }
        }
        return employee;
    }
}
