package org.example.service;

import junit.framework.TestCase;
import org.example.model.Order;
import org.example.model.Product;

import java.util.List;

public class OrderServiceTest extends TestCase {

    public void testInsertOrder() {

        OrderService orderService = new OrderService();

        // Given a sample data
        Product product = Fixtures.getProduct();
        Order order = Fixtures.getOrder();

        // When we insert the data
        Order result = orderService.insertOrder(order);

        // Then we expect the data to be inserted
        assertEquals(order.getUuid(), result.getUuid());
    }

    public void testGetOrder() {
        OrderService orderService = new OrderService();

        // Given an Order
        Order order = Fixtures.getOrder();
        orderService.insertOrder(order);

        // When we get the order
        Order result = orderService.getOrder(order.getUuid().toString());

        // Then we expect the order to be returned
        assertNotNull(result);
        assertEquals(order.getUuid(), result.getUuid());
        assertEquals(order.getUserUUID(), result.getUserUUID());

    }

    public void testGetAllOrders() {
        OrderService orderService = new OrderService();
        orderService.deleteAllOrders();

        // Given some orders
        Order order1 = Fixtures.getOrder();
        Order order2 = Fixtures.getOrder();
        Order order3 = Fixtures.getOrder();
        Order order4 = Fixtures.getOrder();
        Order order5 = Fixtures.getOrder();
        orderService.insertOrder(order1);
        orderService.insertOrder(order2);
        orderService.insertOrder(order3);
        orderService.insertOrder(order4);
        orderService.insertOrder(order5);

        // When call the service to get all the orders
        List<Order> result = orderService.getAllOrders();

        // Then we expect the orders to be returned
        assertNotNull(result);
        assertEquals(result.size(), 5);

    }
}