package be.vdab.be.vdab.dao;

import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> findOrdersForCustomer(Customer customer);
    void saveOrder(Order order);
}
