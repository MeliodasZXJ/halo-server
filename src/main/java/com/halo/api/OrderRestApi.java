package com.halo.api;

import com.google.common.collect.ImmutableMap;
import com.halo.controller.BaseController;
import com.halo.dto.OrderDetailDTO;
import com.halo.dto.OrderProductDTO;
import com.halo.service.AddressService;
import com.halo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * @author MelloChan
 * @date 2018/6/2
 */
@RestController
@RequestMapping("/api/halo/orders")
@Validated
public class OrderRestApi extends BaseController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private AddressService addressService;

    @PostMapping("/now")
    public Map<String, Object> buyNow(@RequestAttribute("uid") Integer uid, @Valid @RequestBody OrderProductDTO orderProductDTO) {
        return rtnParam(0, ImmutableMap.of("orderId",orderService.generateOrderId(uid),"address", addressService.getByUId(uid), "orderProduct", orderProductDTO));
    }

    @PostMapping("/settlement")
    public Map<String, Object> settlePrice(@RequestAttribute("uid") Integer uid, @Valid @RequestBody List<OrderProductDTO> orderProductDTOs) {
        return rtnParam(0, ImmutableMap.of("orderId",orderService.generateOrderId(uid),"address", addressService.getByUId(uid), "orderProducts", orderProductDTOs));
    }

    @PostMapping("/")
    public Map<String, Object> pay(@RequestAttribute("uid") Integer uid, @Valid @RequestBody OrderDetailDTO orderDetailDTO,
                                   HttpServletRequest request) throws UnsupportedEncodingException {
        return rtnParam(0, ImmutableMap.of("id", orderService.insertOrderInfo(uid, orderDetailDTO, request)));
    }

    @GetMapping("/products")
    public Map<String, Object> getOrderProduct(@RequestAttribute("uid") Integer uid) {
        return rtnParam(0, ImmutableMap.of(
                "orderDetailList", orderService.getOrderProductListByUserId(uid)));
    }

    @GetMapping("/{orderId}/products")
    public Map<String, Object> getOrderProductByOrderId(@PathVariable("orderId") String orderId) {
        return rtnParam(0, ImmutableMap.of(
                "status", orderService.getStatusByOrderId(orderId),
                "orderDetail", orderService.getOrderByOrderId(orderId)));
    }

}
