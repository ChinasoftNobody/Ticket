package com.lgh.chinasoft.ticket.server.dao;

import com.lgh.chinasoft.ticket.server.model.Examine;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Repository
public interface ExamineRepo {

    /**
     * 根据storeId查询审核状态
     * @param storeId 商户ID
     * @return 审核状态
     */
    Examine queryByStoreId(@Param("storeId") String storeId);

    /**
     * 保存审核信息
     * @param examine 审核信息
     * @return 保存结果
     */
    int save(@Param("examine") Examine examine);
}
