package org.zheng.sand.common;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 封装返回结果为json的类，格式为{data:"",err_code:"",err_msg:""}
 */
/**
 * http请求返回的最外层对象
 * Created by wzh-zhua on 2018/10/1.
 */
public class Response<T> {
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体的内容. */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}