package com.lgh.chinasoft.ticket.server.service;


import com.lgh.chinasoft.ticket.server.model.Store;

/**
 * @author Administrator
 */
public interface StoreService {

    /**
     * register store
     * @param store store info
     * @return registered store
     */
    Store register(Store store);

    /**
     * 审核商户
     * @param storeId 商户ID
     * @return 审核结果
     */
    String examine(String storeId);

    /**
     * 根据商户ID查询商户审核状态
     * @param storeId 商户ID
     * @return 审核状态
     */
    String examineStatus(String storeId);
}
