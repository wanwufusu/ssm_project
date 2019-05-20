package com.ssm.bean.employee;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EmployeeJson {
    private int total;
    private List<Employee> rows;

    public EmployeeJson(int total, List<Employee> rows) {
        this.total = total;
        this.rows = rows;
    }

    public EmployeeJson() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Employee> getRows() {
        return rows;
    }

    public void setRows(List<Employee> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "EmployeeJson{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
