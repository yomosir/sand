package org.zheng.sand.common;

import java.io.Serializable;

/**
 * 封装返回结果为json的类，格式为{data:"",err_code:"",err_msg:""}
 */
public class Response implements Serializable {

    private static final long serialVersionUID = 6423083342437876060L;

    public String data;
    public String err_code;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public String err_msg;

    @Override
    public String toString() {
        return "Response{" +
                "data='" + data + '\'' +
                ", err_code='" + err_code + '\'' +
                ", err_msg='" + err_msg + '\'' +
                '}';
    }
}
