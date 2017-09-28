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
        String SQL_ORDERINSERT = "INSERT INTO eshop.order (paymentMethod, Order Total, Date, customer_id1, eshop_id1) VALUES (?, ?, ?, ?, ?)";
        String SQL_ORDERDETAIL = "INSERT INTO orderdetail (Amount, product_id1, order_id1) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ORDERINSERT, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement detailStatement = connection.prepareStatement(SQL_ORDERDETAIL)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);

            statement.setString(1, order.getPaymentMethod());
            statement.setDouble(2, order.getOrderTotal());
            statement.setDate(3, order.getDate());
            statement.setLong(4, order.getIdCustomer());
            statement.setLong(5, order.getIdEshop());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            int orderId = resultSet.getInt(1);

            System.out.println(statement);

            detailStatement.setDouble(1, order.getAmount());
            detailStatement.setLong(2, order.getIdProduct());
            detailStatement.setLong(3, orderId);        //orderId is pas in de vorige stap aangemaakt. Deze kan je met getGeneratedKeys() ophalen op het statement.
            System.out.println(detailStatement);
            detailStatement.executeUpdate();

            connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }

