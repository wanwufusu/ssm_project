package com.ssm.bean.material;

import org.springframework.stereotype.Component;

public class Material {
    private String materialId;
    private String materialType;
    private String status;
    private int remaining;
    private String note;

    public Material() {
    }

    public Material(String materialId, String materialType, String status, int remaining, String note) {
        this.materialId = materialId;
        this.materialType = materialType;
        this.status = status;
        this.remaining = remaining;
        this.note = note;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
