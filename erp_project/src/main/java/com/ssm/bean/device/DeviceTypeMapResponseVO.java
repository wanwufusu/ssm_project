package com.ssm.bean.device;

import java.util.LinkedHashMap;
import java.util.Map;

public class DeviceTypeMapResponseVO {
    private LinkedHashMap<String,Object> ObjectMap;

    public LinkedHashMap<String, Object> getObjectMap() {
        return ObjectMap;
    }

    public void setObjectMap(LinkedHashMap<String, Object> objectMap) {
        ObjectMap = objectMap;
    }
}
