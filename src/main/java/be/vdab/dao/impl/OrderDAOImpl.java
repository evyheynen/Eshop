package be.vdab.dao.impl;

import be.vdab.be.vdab.dao.OrderDAO;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    List<Order> orderlist;
    private static Logger LOGGER= LogManager.getLogger();

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
                    LOGGER.debug("found orders for customer");
            }


        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("no orders found for customer"+e);
        }
        return orderlist;
    }


    @Override
    public void saveOrder(Order order) {
        String sql = "INSERT INTO Order (id, Payment method, Order Total, Date) VALUES(?,?,?,?);";

        try (Connection con = ConnectionDB.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, order.getIdOrder());
            stmt.setString(2, order.getPaymentMethod());
            stmt.setInt(3, order.getOrderTotal());
            stmt.setDate(4, (Date) order.getDate());

            int result = stmt.executeUpdate();
            LOGGER.debug(result + " orders saved");

        } catch (SQLException e) {
            LOGGER.error("no orders saved " + e);
        }
    }

    }

