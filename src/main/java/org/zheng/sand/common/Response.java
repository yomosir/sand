package org.zheng.sand.common;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 封装返回结果为json的类，格式为{data:"",err_code:"",err_msg:""}
 */
public class Response implements Serializable {

    private static final long serialVersionUID = 6423083342437876060L;

    public String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Response{" +
                "data='" + data + '\'' +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public List<String> getMsg() {
        return msg;
    }

    public void setMsg(List<String> msg) {
        this.msg = msg;
    }

    public String code;
    public List<String> msg;
}
