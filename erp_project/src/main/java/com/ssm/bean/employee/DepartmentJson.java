package com.ssm.bean.employee;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DepartmentJson {
    int total;
    List<Department> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Department> getRows() {
        return rows;
    }

    public void setRows(List<Department> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "DepartmentJson{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
