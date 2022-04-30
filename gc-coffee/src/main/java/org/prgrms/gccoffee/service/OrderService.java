package org.prgrms.gccoffee.service;

import org.prgrms.gccoffee.model.Email;
import org.prgrms.gccoffee.model.Order;
import org.prgrms.gccoffee.model.OrderItem;

import java.util.List;

public interface OrderService {

    Order createOrder(Email email, String address, String postcode, List<OrderItem> orderItems);
}
