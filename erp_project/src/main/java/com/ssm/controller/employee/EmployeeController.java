package com.ssm.controller.employee;

import com.ssm.bean.employee.Employee;
import com.ssm.bean.employee.EmployeeJson;
import com.ssm.bean.employee.QueryStatus;
import com.ssm.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeJson employeeJson;


    /*List*/
    @RequestMapping("find")
    public String employee1(){
        return "employee_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public EmployeeJson employee2(){
        List<Employee> employees = employeeService.selectEmployeeList();
        employeeJson.setTotal(employees.size());
        employeeJson.setRows(employees);
        return employeeJson;
    }

    /*新增功能*/
    @RequestMapping("add_judge")
    public String employee3(){
        return "employee_add";
    }

    @RequestMapping("add")
    public String employee4(){
        return "employee_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public QueryStatus employee5(Employee employee){
        if(!employee.getIdCode().matches("\\d{18}")){
            QueryStatus queryStatus = new QueryStatus(100,"请输入正确身份证号",null);
            return queryStatus;
        }else{
            List<Employee> employees = employeeService.searchEmployeeListById(employee.getEmpId());
            if(employees.size() != 0){
                return new QueryStatus(100,"已存在该员工编号",null);
            } else{
                employeeService.insertEmployee(employee);
                return new QueryStatus(200,"新增员工成功",null);
            }
        }
    }

    /*搜索功能*/
    @RequestMapping("search_employee_by_employeeId")
    @ResponseBody
    public EmployeeJson employee6(String searchValue){
        List<Employee> employees = employeeService.searchEmployeeListById(searchValue);
        employeeJson.setTotal(employees.size());
        employeeJson.setRows(employees);
        return employeeJson;
    }

    @RequestMapping("search_employee_by_employeeName")
    @ResponseBody
    public EmployeeJson employee7(String searchValue){
        List<Employee> employees = employeeService.searchEmployeeListByName(searchValue);
        employeeJson.setTotal(employees.size());
        employeeJson.setRows(employees);
        return employeeJson;
    }

    @RequestMapping("search_employee_by_departmentName")
    @ResponseBody
    public EmployeeJson employee8(String searchValue){
        List<Employee> employees = employeeService.searchEmployeeListByDepartmentName(searchValue);
        employeeJson.setTotal(employees.size());
        employeeJson.setRows(employees);
        return employeeJson;
    }

    /*删除功能*/
    @RequestMapping("delete_judge")
    public String employee9(){
        return "employee_list";
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public QueryStatus employee10(String ids){
        employeeService.deleteEmployeeById(ids);
        QueryStatus queryStatus = new QueryStatus(200, "OK", null);
        return queryStatus;
    }

    /*编辑功能*/
    @RequestMapping("edit_judge")
    public String employee11(){
        return "employee_edit";
    }

    @RequestMapping("edit")
    public String employee12(){
        return "employee_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public QueryStatus employee13(Employee employee){
        employeeService.editEmployee(employee);
        QueryStatus queryStatus = new QueryStatus(200, "成功", "1");
        return queryStatus;
    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<Employee> employee14(){
        List<Employee> employees = employeeService.selectEmployeeList();
        return employees;
    }

    @RequestMapping("get/{employeeId}")
    @ResponseBody
    public Employee employee15(@PathVariable("employeeId") String employeeId){
        return employeeService.queryEmployeeByEmployeeId(employeeId);
    }
}
