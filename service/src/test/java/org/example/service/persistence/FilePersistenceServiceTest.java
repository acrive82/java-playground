package org.example.service.persistence;

import junit.framework.TestCase;
import org.example.model.Order;
import org.example.model.Product;
import org.example.service.Fixtures;

import java.util.List;

public class FilePersistenceServiceTest extends TestCase {

    public void testInsert() throws Exception {

        // Given a sample data
        Product product = Fixtures.getProduct();
        Order order = Fixtures.getOrder();

        // When we insert the data
        FilePersistenceService filePersistenceService = new FilePersistenceService();
        filePersistenceService.insert(order);

        // Then we expect the data to be inserted
        assertTrue(true);
    }

    public void testGet() throws Exception {
        FilePersistenceService filePersistenceService = new FilePersistenceService();

        // Given an Order
        Product product = Fixtures.getProduct();
        Order order = Fixtures.getOrder();

        filePersistenceService.insert(order);


        // When we get the order
        Order orderFound = filePersistenceService.get(order.getUuid().toString(), Order.class);

        // Then we expect the order to be returned
        assertEquals(order.getUuid(), orderFound.getUuid());

    }


    public void testGetAllOrder() throws Exception {
        FilePersistenceService filePersistenceService = new FilePersistenceService();
        filePersistenceService.deleteAll(Order.class);

        // Given some orders
        Product product = Fixtures.getProduct();
        Order order = Fixtures.getOrder();
        Order order2 = Fixtures.getOrder();
        Order order3 = Fixtures.getOrder();
        filePersistenceService.insert(order);
        filePersistenceService.insert(order2);
        filePersistenceService.insert(order3);

        // When call the service to get all the orders
        List result = filePersistenceService.getAll(Order.class);

        // Then we expect the orders to be returned
        assertEquals(3, result.size());
        assertEquals(order.getUuid(), ((Order) result.get(0)).getUuid());
        assertEquals(order2.getUuid(), ((Order) result.get(1)).getUuid());
        assertEquals(order3.getUuid(), ((Order) result.get(2)).getUuid());

    }

    public void testUpdate() {
    }

    public void testDelete() {
    }
}