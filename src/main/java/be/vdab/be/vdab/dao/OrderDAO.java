package be.vdab.be.vdab.dao;

import be.vdab.entiteiten.Customer;

import java.util.List;

public interface OrderDAO {
    List<OrderDAO>findOrdersForCustomer(Customer customer);
    void saveOrder(OrderDAO orderDAO);
}
