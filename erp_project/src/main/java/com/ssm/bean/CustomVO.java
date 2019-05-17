package com.ssm.bean;


import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/17
 * @since 1.0.0
 */

public class CustomVO {
    private int total;
    private List<Custom> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Custom> getRows() {
        return rows;
    }

    public void setRows(List<Custom> rows) {
        this.rows = rows;
    }
}
