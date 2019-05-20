package com.ssm.mapper.employee;

import com.ssm.bean.employee.Employee;
import com.ssm.bean.employee.EmployeeJson;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface EmployeeMapper {
    List<Employee> selectEmployeeList();

    Employee selectByPrimaryKey(String employeeId);

    List<Employee> searchEmployeeListById(String id);

    List<Employee> searchEmployeeListByName(String name);

    List<Employee> searchEmployeeListByDepartmentName(String name);

    int insertEmployee(Employee employee);

    void deleteEmployeeById(String ids);

    void editEmployee(Employee employee);
}