package com.halo.api;

import com.google.common.collect.ImmutableMap;
import com.halo.controller.BaseController;
import com.halo.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Map;

/**
 * @author SAIKAII
 * @date 2018/6/15
 */
@RestController
@RequestMapping("/api/halo/backstage/ordermanage")
@Validated
public class BackstageOrderManageRestApi extends BaseController{

    @Autowired
    private OrderService orderService;

    @GetMapping("/page")
    public Map<String, Object> getNumOfPages(@RequestParam("pageCount") @Min(1) Integer pageCount){
        return rtnParam(0, ImmutableMap.of("pages", orderService.getNumOfPages(pageCount)));
    }

    @GetMapping("/orders")
    public Map<String, Object> getOrders(@RequestParam("pageIndex") @Min(1) Integer pageIndex,
                                         @RequestParam("pageCount") @Min(1) Integer pageCount){
        return rtnParam(0, ImmutableMap.of("orders", orderService.getOrders(pageIndex, pageCount)));
    }

    @GetMapping("/{status}")
    public Map<String, Object> getOrdersByStatus(@PathVariable("status") Short status,
                                                 @RequestParam("pageIndex") @Min(1) Integer pageIndex,
                                                 @RequestParam("pageCount") @Min(1) Integer pageCount){
        return rtnParam(0, ImmutableMap.of("orders", orderService.getOrdersByStatus(status, pageIndex, pageCount)));
    }

    @PatchMapping("/status")
    public Map<String, Object> updateOrderStatusById(@RequestParam("id") @Min(1) String id,
                                                     @RequestParam("status") Short status){
        orderService.updateOrderStatusById(id, status);
        return rtnParam(0, ImmutableMap.of("msg", "更新成功"));
    }
}
