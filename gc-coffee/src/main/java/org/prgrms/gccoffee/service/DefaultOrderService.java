package org.prgrms.gccoffee.service;

import org.prgrms.gccoffee.model.Email;
import org.prgrms.gccoffee.model.Order;
import org.prgrms.gccoffee.model.OrderItem;
import org.prgrms.gccoffee.model.OrderStatus;
import org.prgrms.gccoffee.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;
import static org.prgrms.gccoffee.model.OrderStatus.ACCEPTED;

@Service
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;

    public DefaultOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Email email, String address, String postcode, List<OrderItem> orderItems) {
        Order order = new Order(
                randomUUID(),
                email,
                address,
                postcode,
                orderItems,
                ACCEPTED,
                now(),
                now()
        );

        return orderRepository.insert(order);
    }
}
