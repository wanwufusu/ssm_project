package com.ssm.service.employee;

import com.ssm.bean.employee.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> selectDepartmentList();

    List<Department> searchDepartmentListById(String id);

    List<Department> searchDepartmentListByName(String name);

    int insertDepartment(Department department);

    int deleteDepartmentById(String id);

    int editDepartment(String departmentId,String departmentName,String note);

    void updateNoteById(String departmentId, String note);

    //Product queryProductByProductId(String productId);

    Department queryDepartmentByDepartmentId(String departmentId);
}
