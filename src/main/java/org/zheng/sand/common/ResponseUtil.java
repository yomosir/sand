package org.zheng.sand.common;

public class ResponseUtil {
    public static Response<Object> success(Object object) {
        Response<Object> result = new Response<>();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    public static Response success() {
        return success(null);
    }

    public static Response error(Integer code, String msg) {
        Response result = new Response();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
