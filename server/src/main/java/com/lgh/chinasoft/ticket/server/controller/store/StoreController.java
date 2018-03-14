package com.lgh.chinasoft.ticket.server.controller.store;

import com.lgh.chinasoft.ticket.server.common.Response;
import com.lgh.chinasoft.ticket.server.model.Store;
import com.lgh.chinasoft.ticket.server.service.StoreService;
import com.lgh.chinasoft.ticket.server.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/store")
@Api(tags = "store")
public class StoreController {

    @Resource
    private StoreService storeService;

    @PostMapping(value = "/register",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("register store")
    public Response register(@RequestBody Store store){
        Store result = storeService.register(store);
        return ResponseUtil.success(result);
    }

    @PostMapping(value = "/examine",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("examine store")
    public Response examine(@RequestBody String storeId){
        return ResponseUtil.success(storeService.examine(storeId));
    }

    @PostMapping(value = "/examine/status",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("examine status query")
    public Response examineStatus(String storeId){
        return ResponseUtil.success(storeService.examineStatus(storeId));
    }
}
