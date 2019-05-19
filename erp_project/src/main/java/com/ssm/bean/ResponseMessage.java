package com.ssm.bean;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/18
 * @since 1.0.0
 */

public class ResponseMessage {
    private int status;
    private String msg;
    private String data;

    public ResponseMessage() {
    }

    public ResponseMessage(int status, String msg, String data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    /**
     * 传入mapper的返回数量，当大于0时产生正常的状态返回信息
     * @param i
     * @return
     */
    public static ResponseMessage getMessage(int i){
        ResponseMessage message = new ResponseMessage();
        if (i >= 1) {
            message.setMsg("OK");
            message.setData(null);
            message.setStatus(200);
        } else {
            message.setMsg("FAIL");
            message.setData(null);
            message.setStatus(404);
        }
        return message;
    }
}
