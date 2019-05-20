package com.ssm.controller.employee;

import com.ssm.bean.employee.Department;
import com.ssm.bean.employee.DepartmentJson;
import com.ssm.bean.employee.QueryStatus;
import com.ssm.service.employee.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    DepartmentJson departmentJson;

    /*List*/
    @RequestMapping("list")
    @ResponseBody
    public DepartmentJson Department1(int page, int rows){
        List<Department> departments = departmentService.selectDepartmentList();
        List<Department> departments1 = departments.subList((page-1) * rows, ((page) * rows)>=departments.size()?departments.size():((page)*rows));
        departmentJson.setTotal(departments.size());
        departmentJson.setRows(departments1);
        return departmentJson;
    }

    @RequestMapping("find")
    public String department2(){
        return "department_list";
    }
    /*搜索功能*/
    @RequestMapping("search_department_by_departmentId")
    @ResponseBody
    public DepartmentJson department4(String searchValue){
        List<Department> departments = departmentService.searchDepartmentListById(searchValue);
        departmentJson.setTotal(departments.size());
        departmentJson.setRows(departments);
        return  departmentJson;
    }
    @RequestMapping("search_department_by_departmentName")
    @ResponseBody
    public DepartmentJson department5(String searchValue){
        List<Department> departments = departmentService.searchDepartmentListByName(searchValue);
        departmentJson.setTotal(departments.size());
        departmentJson.setRows(departments);
        return departmentJson;
    }
    /*添加功能*/
    @RequestMapping("add_judge")
    public String department3(){
        return "department_add";
    }

    @RequestMapping("add")
    public String department6(){
        return "department_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public QueryStatus department7(String departmentId, String departmentName, String note){
        Department department = new Department(departmentId, departmentName, note);
        List<Department> departments = departmentService.searchDepartmentListById(departmentId);
        //重复则提示该部门已存在
        if(departments.size() == 0){
            departmentService.insertDepartment(department);
            QueryStatus queryStatus = new QueryStatus(200, "成功", "1");
            return queryStatus;
        }else{
            return new QueryStatus(100,"该部门已存在","1");
        }

    }

    /*删除功能*/
    @RequestMapping("delete_judge")
    public String department8(){
        return "department_list";
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public QueryStatus department9(String ids){
        departmentService.deleteDepartmentById(ids);
        QueryStatus queryStatus = new QueryStatus(200, "成功", "1");
        return queryStatus;
    }

    /*编辑功能*/
    @RequestMapping("edit_judge")
    public String department10(){
        return "department_edit";
    }

    @RequestMapping("edit")
    public String department11(){
        return "department_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public QueryStatus department12(String departmentId,String departmentName,String note){
        departmentService.editDepartment(departmentId,departmentName,note);
        QueryStatus queryStatus = new QueryStatus(200, "成功", "1");
        return queryStatus;
    }

    /*update_note*/
    @RequestMapping("update_note")
    @ResponseBody
    public QueryStatus department15(String departmentId,String note){
        departmentService.updateNoteById(departmentId,note);
        QueryStatus queryStatus = new QueryStatus(200, "成功", "1");
        return queryStatus;
    }

    /*get_data*/
    @RequestMapping("get_data")
    @ResponseBody
    public List<Department> department13(){
        List<Department> departments = departmentService.selectDepartmentList();
        return departments;
    }

        @RequestMapping("get/{departmentId}")
    @ResponseBody
    public Department department14(@PathVariable("departmentId") String departmentId){
        return departmentService.queryDepartmentByDepartmentId(departmentId);
    }
}
