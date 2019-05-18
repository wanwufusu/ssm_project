package com.ssm.bean.material;

import java.util.Date;

public class MaterialReceive {
    private String receiveId;
    private String materialId;
    private int amount;
    private Date receiveDate;
    private String sender;
    private String receiver;
    private String note;

    public MaterialReceive() {
    }

    public MaterialReceive(String receiveId, String materialId, int amount, Date receiveDate, String sender, String receiver, String note) {
        this.receiveId = receiveId;
        this.materialId = materialId;
        this.amount = amount;
        this.receiveDate = receiveDate;
        this.sender = sender;
        this.receiver = receiver;
        this.note = note;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
