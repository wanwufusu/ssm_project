package com.ssm.service.employee;

import com.ssm.bean.employee.Employee;
import com.ssm.bean.employee.EmployeeJson;
import com.ssm.mapper.employee.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public List<Employee> selectEmployeeList() {
        List<Employee> employees = employeeMapper.selectEmployeeList();
        return employees;
    }

    @Override
    public List<Employee> searchEmployeeListById(String id) {
        return employeeMapper.searchEmployeeListById(id);
    }

    @Override
    public List<Employee> searchEmployeeListByName(String name) {
        List<Employee> employees = employeeMapper.searchEmployeeListByName(name);
        return employees;
    }

    @Override
    public List<Employee> searchEmployeeListByDepartmentName(String name) {
        return employeeMapper.searchEmployeeListByDepartmentName(name);
    }

    @Override
    public int insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    @Override
    public void deleteEmployeeById(String ids) {
        employeeMapper.deleteEmployeeById(ids);
    }

    @Override
    public void editEmployee(Employee employee) {
        employeeMapper.editEmployee(employee);
    }

    @Override
    public Employee queryEmployeeByEmployeeId(String employeeId) {
        return employeeMapper.selectByPrimaryKey(employeeId);
    }
}
