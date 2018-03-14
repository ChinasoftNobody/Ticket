package com.lgh.chinasoft.ticket.server.service.impl;

import com.lgh.chinasoft.ticket.server.common.Const;
import com.lgh.chinasoft.ticket.server.common.ServerException;
import com.lgh.chinasoft.ticket.server.dao.ExamineRepo;
import com.lgh.chinasoft.ticket.server.dao.StoreRepo;
import com.lgh.chinasoft.ticket.server.model.Examine;
import com.lgh.chinasoft.ticket.server.model.Store;
import com.lgh.chinasoft.ticket.server.service.StoreService;
import com.lgh.chinasoft.ticket.server.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Resource
    private StoreRepo storeRepo;

    @Resource
    private ExamineRepo examineRepo;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Store register(Store store) {
        if(store == null || StringUtils.isEmpty(store.getName())
                || StringUtils.isEmpty(store.getOwner()) || StringUtils.isEmpty(store.getOwnerPhone())){
            throw new ServerException("store info not complete");
        }
        Store existStore = storeRepo.queryByName(store.getName());
        if(existStore != null){
            throw new ServerException("store name exist");
        }
        store.setId(UUIDUtil.uuid());
        int i = storeRepo.save(store);
        if(i <= 0){
            throw new ServerException("save store failed");
        }
        return store;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String examine(String storeId) {
        if(StringUtils.isEmpty(storeId)){
            throw new ServerException("store info is empty");
        }
        Store store = storeRepo.queryById(storeId);
        if(store == null){
            throw new ServerException("store not found");
        }
        Examine examine = examineRepo.queryByStoreId(storeId);
        if(examine != null){
            throw new ServerException("store is already examined");
        }
        examine = packageExamine(storeId);
        int i = examineRepo.save(examine);
        if(i <= 0){
            throw new ServerException("examine failed, please try again");
        }
        return examine.getStatus();
    }

    @Override
    public String examineStatus(String storeId) {
        if(StringUtils.isEmpty(storeId)){
            throw new ServerException("store info is empty");
        }
        Examine examine = examineRepo.queryByStoreId(storeId);
        if(examine == null){
            throw new ServerException("store is not examined yet");
        }
        return examine.getStatus();
    }

    private Examine packageExamine(String storeId) {
        Examine examine = new Examine();
        examine.setId(UUIDUtil.uuid());
        examine.setExaminerId("");
        examine.setMessage("");
        examine.setStatus(Const.EXAMINE_STATUS_DURING);
        examine.setStoreId(storeId);
        return examine;
    }
}
