package com.ssm.bean.qualityControl;

import java.util.Date;

public class ProcessMeasureCheck {
    private String pMeasureCheckId;

    private String processId;

    private String checkItem;

    private String cdate;

    private String measureData;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    private String empId;

    private String empName;

    private String result;

    private String note;

    public String getpMeasureCheckId() {
        return pMeasureCheckId;
    }

    public void setpMeasureCheckId(String pMeasureCheckId) {
        this.pMeasureCheckId = pMeasureCheckId == null ? null : pMeasureCheckId.trim();
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem == null ? null : checkItem.trim();
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getMeasureData() {
        return measureData;
    }

    public void setMeasureData(String measureData) {
        this.measureData = measureData == null ? null : measureData.trim();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}