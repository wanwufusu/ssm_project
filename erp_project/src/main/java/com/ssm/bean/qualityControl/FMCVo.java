package com.ssm.bean.qualityControl;


import java.util.List;

/**
 * FinalMeasureCheck的分页
 */
public class FMCVo {
    private int total;
    private List<FinalMeasuretCheck> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<FinalMeasuretCheck> getRows() {
        return rows;
    }

    public void setRows(List<FinalMeasuretCheck> rows) {
        this.rows = rows;
    }
}
