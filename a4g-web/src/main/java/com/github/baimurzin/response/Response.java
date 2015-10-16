package com.github.baimurzin.response;

import org.apache.http.HttpStatus;

/**
 * Created by vlad on 16.10.15.
 */
public class Response {
    private int code;
    private Object response;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
