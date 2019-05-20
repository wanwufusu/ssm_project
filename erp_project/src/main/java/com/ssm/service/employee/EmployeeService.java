package com.ssm.service.employee;

import com.ssm.bean.employee.Employee;
import com.ssm.bean.employee.EmployeeJson;

import java.util.List;

public interface EmployeeService {
    List<Employee> selectEmployeeList();

    List<Employee> searchEmployeeListById(String id);

    List<Employee> searchEmployeeListByName(String name);

    List<Employee> searchEmployeeListByDepartmentName(String name);

    int insertEmployee(Employee employee);

    void deleteEmployeeById(String ids);

    void editEmployee(Employee employee);

    Employee queryEmployeeByEmployeeId(String employeeId);

}
