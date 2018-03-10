package com.lgh.chinasoft.ticket.server.common;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class Response<T> implements Serializable {
    private T result;
    private boolean success;
    private String message;

    public Response(T result, boolean success, String message) {
        this.result = result;
        this.success = success;
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
