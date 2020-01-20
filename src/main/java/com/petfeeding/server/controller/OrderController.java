package com.petfeeding.server.controller;


import com.petfeeding.server.aspect.log.LogAop;
import com.petfeeding.server.aspect.token.TokenValidatorAop;
import com.petfeeding.server.dto.request.concrete.order.AddOrderRequest;
import com.petfeeding.server.dto.request.concrete.order.DeleteOrderRequest;
import com.petfeeding.server.dto.request.concrete.order.GetOrderRequest;
import com.petfeeding.server.dto.request.concrete.order.UpdateOrderRequest;
import com.petfeeding.server.dto.response.ApiResponse;
import com.petfeeding.server.dto.response.result.order.AddOrderResult;
import com.petfeeding.server.dto.response.result.order.DeleteOrderResult;
import com.petfeeding.server.dto.response.result.order.GetOrderResult;
import com.petfeeding.server.dto.response.result.order.UpdateOrderResult;
import com.petfeeding.server.service.biz.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinlong
 */
@RestController
@RequestMapping(value = "/server/api/v1/order", produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@LogAop(description = "order controller log aspect")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST, path = "/addOrder")
    @TokenValidatorAop
    public ApiResponse<AddOrderResult> addOrder(@RequestBody AddOrderRequest request) {
        return orderService.addOrder(request);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/getOrder")
    @TokenValidatorAop
    public ApiResponse<GetOrderResult> getOrder(@RequestBody GetOrderRequest request) {
        return orderService.getOrder(request);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/updateOrder")
    @TokenValidatorAop
    public ApiResponse<UpdateOrderResult> updateOrder(@RequestBody UpdateOrderRequest request) {
        return orderService.updateOrder(request);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/deleteOrder")
    @TokenValidatorAop
    public ApiResponse<DeleteOrderResult> addOrder(@RequestBody DeleteOrderRequest request) {
        return orderService.deleteOrder(request);
    }
}
