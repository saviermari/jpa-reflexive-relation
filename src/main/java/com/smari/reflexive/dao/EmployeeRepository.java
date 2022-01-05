package com.smari.reflexive.dao;

import com.smari.reflexive.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author smari
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
