package be.vdab.dao.impl;

import be.vdab.be.vdab.dao.OrderDAO;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.Order;
import be.vdab.entiteiten.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    List<Order> orderlist;

    @Override
    public List<Order> findOrdersForCustomer(Customer customer) {
        orderlist = new ArrayList<>();

        String sql = "select * from eshop.order where customer_id1=?";

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, customer.getId());
            ResultSet rs=stmt.executeQuery();
                while (rs.next()){
                    int id=rs.getInt("id");
                    String paymentMethod=rs.getString("Payment method");
                    int orderTotal=rs.getInt("Order Total");
                    Date date=rs.getDate("Date");
                    int customerId=rs.getInt("customer_id1");
                    int eshopid=rs.getInt("eshop_id1");

                    orderlist.add(new Order(id,paymentMethod,orderTotal,date));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderlist;
    }


    @Override
    public void saveOrder(OrderDAO orderDAO) {

    }
}
