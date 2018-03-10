package com.lgh.chinasoft.ticket.server.util;

import java.util.UUID;

/**
 * @author Administrator
 */
public class UUIDUtil {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
