package com.petfeeding.server.service.biz.impl;

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
import org.springframework.stereotype.Service;

/**
 * @author jinlong
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public ApiResponse<AddOrderResult> addOrder(AddOrderRequest request) {
        return null;
    }

    @Override
    public ApiResponse<GetOrderResult> getOrder(GetOrderRequest request) {
        return null;
    }

    @Override
    public ApiResponse<UpdateOrderResult> updateOrder(UpdateOrderRequest request) {
        return null;
    }

    @Override
    public ApiResponse<DeleteOrderResult> deleteOrder(DeleteOrderRequest request) {
        return null;
    }
}
