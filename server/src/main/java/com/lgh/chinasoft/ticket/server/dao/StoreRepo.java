package com.lgh.chinasoft.ticket.server.dao;

import com.lgh.chinasoft.ticket.server.model.Store;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Repository
public interface StoreRepo {
    /**
     * 根据名称查询store
     * @param name 名称
     * @return store
     */
    Store queryByName(@Param("name") String name);

    /**
     * 保存商户
     * @param store 商户信息
     * @return 保存结果
     */
    int save(@Param("store") Store store);

    /**
     * 根据ID查询商户信息
     * @param storeId 商户ID
     * @return 商户信息
     */
    Store queryById(@Param("storeId") String storeId);
}
