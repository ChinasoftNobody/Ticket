package com.lgh.chinasoft.ticket.server.util;

import com.lgh.chinasoft.ticket.server.common.Response;

/**
 * @author Administrator
 */
public class ResponseUtil {
    public static <T> Response<T> success(T result){
        return new Response<T>(result,true,null);
    }

    public static <T> Response failed(String message){
        return new Response<T>(null,false,message);
    }
}
