package com.ssm.bean.device;

import java.util.Date;

public class DeviceFault {
    private String deviceFaultId;

    private String deviceId;

    private String deviceFaultCause;

    private String deviceFaultDetail;

    private String deviceFaultDate;

    private String deviceFaultMaintenance;

    private String deviceParams;

    private String deviceName;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceParams() {
        return deviceParams;
    }

    public void setDeviceParams(String deviceParams) {
        this.deviceParams = deviceParams;
    }

    public String getDeviceFaultId() {
        return deviceFaultId;
    }

    public void setDeviceFaultId(String deviceFaultId) {
        this.deviceFaultId = deviceFaultId == null ? null : deviceFaultId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDeviceFaultCause() {
        return deviceFaultCause;
    }

    public void setDeviceFaultCause(String deviceFaultCause) {
        this.deviceFaultCause = deviceFaultCause == null ? null : deviceFaultCause.trim();
    }

    public String getDeviceFaultDetail() {
        return deviceFaultDetail;
    }

    public void setDeviceFaultDetail(String deviceFaultDetail) {
        this.deviceFaultDetail = deviceFaultDetail == null ? null : deviceFaultDetail.trim();
    }

    public String getDeviceFaultDate() {
        return deviceFaultDate;
    }

    public void setDeviceFaultDate(String deviceFaultDate) {
        this.deviceFaultDate = deviceFaultDate;
    }

    /*public Date getDeviceFaultDate() {
        return deviceFaultDate;
    }

    public void setDeviceFaultDate(Date deviceFaultDate) {
        this.deviceFaultDate = deviceFaultDate;
    }*/

    public String getDeviceFaultMaintenance() {
        return deviceFaultMaintenance;
    }

    public void setDeviceFaultMaintenance(String deviceFaultMaintenance) {
        this.deviceFaultMaintenance = deviceFaultMaintenance == null ? null : deviceFaultMaintenance.trim();
    }
}