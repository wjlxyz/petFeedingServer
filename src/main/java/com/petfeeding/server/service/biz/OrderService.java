package com.petfeeding.server.service.biz;

import com.petfeeding.server.dto.request.concrete.order.AddOrderRequest;
import com.petfeeding.server.dto.request.concrete.order.DeleteOrderRequest;
import com.petfeeding.server.dto.request.concrete.order.GetOrderRequest;
import com.petfeeding.server.dto.request.concrete.order.UpdateOrderRequest;
import com.petfeeding.server.dto.response.ApiResponse;
import com.petfeeding.server.dto.response.result.order.AddOrderResult;
import com.petfeeding.server.dto.response.result.order.DeleteOrderResult;
import com.petfeeding.server.dto.response.result.order.GetOrderResult;
import com.petfeeding.server.dto.response.result.order.UpdateOrderResult;

/**
 * @author jinlong
 * @since 2020-01-03 15:19
 */
public interface OrderService {

    ApiResponse<AddOrderResult> addOrder(AddOrderRequest request);

    ApiResponse<GetOrderResult> getOrder(GetOrderRequest request);

    ApiResponse<UpdateOrderResult> updateOrder(UpdateOrderRequest request);

    ApiResponse<DeleteOrderResult> deleteOrder(DeleteOrderRequest request);
}
