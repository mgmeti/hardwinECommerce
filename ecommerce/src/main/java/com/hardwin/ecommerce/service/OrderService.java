package com.hardwin.ecommerce.service;

import com.hardwin.ecommerce.dto.OrderDto;
import com.hardwin.ecommerce.entity.Order;
import com.hardwin.ecommerce.exception.ResourceNotFoundException;
import com.hardwin.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService{
    private final ModelMapper modelMapper;

    private final OrderRepository orderRepository;

    @Override
    public Order placeOrder(Long userId) {
        return null;
    }

    @Override
    public OrderDto getOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .map(this::convertToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    @Override
    public List<OrderDto> getUserOrders(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders.stream()
                .map(this::convertToDto)
                .toList();
    }

    private OrderDto convertToDto(Order order){
        return modelMapper.map(order, OrderDto.class);
    }
}
