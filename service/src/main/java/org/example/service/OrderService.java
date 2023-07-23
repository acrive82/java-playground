package org.example.service;

import org.example.model.Order;
import org.example.service.persistence.AbstractPersistenceService;
import org.example.service.persistence.FilePersistenceService;

import java.util.List;

public class OrderService {

    private final AbstractPersistenceService persistenceService;

    public OrderService() {
        this.persistenceService = new FilePersistenceService();
    }

    public Order insertOrder(Order order) {
        try {
            return persistenceService.insert(order);
        } catch (Exception e) {
            System.err.println("Error while inserting order:" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Order getOrder(String id) {
        try {
            return persistenceService.get(id, Order.class);
        } catch (Exception e) {
            System.err.println("Error while getting order:" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<Order> getAllOrders() {
        try {
            return persistenceService.getAll(Order.class);
        } catch (Exception e) {
            System.err.println("Error while getting all orders:" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void deleteAllOrders() {
        try {
            persistenceService.deleteAll(Order.class);
        } catch (Exception e) {
            System.err.println("Error while deleting all orders:" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
