package com.hardwin.ecommerce.service;

import com.hardwin.ecommerce.dto.OrderDto;
import com.hardwin.ecommerce.entity.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);
}
