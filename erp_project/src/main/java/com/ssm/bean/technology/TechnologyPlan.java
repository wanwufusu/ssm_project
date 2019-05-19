package com.ssm.bean.technology;

import java.util.Date;

public class TechnologyPlan {
    private String technologyPlanId;

    private String technologyId;

    private Integer batchAmount;

    private String startPlan;

    private String endPlan;

    private String commitPlan;

    private String technologyPlanStart;

    private String technologyPlanEnd;

    public String getTechnologyPlanId() {
        return technologyPlanId;
    }

    public void setTechnologyPlanId(String technologyPlanId) {
        this.technologyPlanId = technologyPlanId == null ? null : technologyPlanId.trim();
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId == null ? null : technologyId.trim();
    }

    public Integer getBatchAmount() {
        return batchAmount;
    }

    public void setBatchAmount(Integer batchAmount) {
        this.batchAmount = batchAmount;
    }

    public String getStartPlan() {
        return startPlan;
    }

    public void setStartPlan(String startPlan) {
        this.startPlan = startPlan;
    }

    public String getEndPlan() {
        return endPlan;
    }

    public void setEndPlan(String endPlan) {
        this.endPlan = endPlan;
    }

    public String getCommitPlan() {
        return commitPlan;
    }

    public void setCommitPlan(String commitPlan) {
        this.commitPlan = commitPlan;
    }

    public String getTechnologyPlanStart() {
        return technologyPlanStart;
    }

    public void setTechnologyPlanStart(String technologyPlanStart) {
        this.technologyPlanStart = technologyPlanStart;
    }

    public String getTechnologyPlanEnd() {
        return technologyPlanEnd;
    }

    public void setTechnologyPlanEnd(String technologyPlanEnd) {
        this.technologyPlanEnd = technologyPlanEnd;
    }
}