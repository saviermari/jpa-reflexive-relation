package com.smari.reflexive.controller;

import com.smari.reflexive.dto.EmployeeModel;
import com.smari.reflexive.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author smari
 */
@RestController
@RequestMapping(value = "/rest/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @PostMapping("/employees")
    public EmployeeModel createEmployee(@RequestBody EmployeeModel model){
        return service.createEmployee(model);
    }
    @PutMapping("/employees/{id}")
    public EmployeeModel updateEmployee(@PathVariable Long id, @RequestBody EmployeeModel model){
          return  service.updateEmployee(id,model);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
    }

    @GetMapping("/employees/{id}")
    public EmployeeModel getEmployee(@PathVariable Long id){
        return service.getEmployee(id);
    }

    @GetMapping("/employees")
    public List<EmployeeModel> getAllEmployee(){
        return service.getAllEmployees();
    }

    @GetMapping("/employees/{id}/reports")
    public List<EmployeeModel> getEmployees(@PathVariable Long id){
        return service.getReports(id);
    }

}
