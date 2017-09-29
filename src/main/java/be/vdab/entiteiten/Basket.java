package be.vdab.entiteiten;

import be.vdab.be.vdab.dao.BasketInterface;
import be.vdab.dao.impl.ConnectionDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class Basket implements BasketInterface {
    private static final Logger LOGGER = LogManager.getLogger();
    private Map<Product, Integer> basket;
    private Product product;

    public Basket() {
        basket = new HashMap<>();
    }

    public Map<Product, Integer> getBasket() {
        return basket;
    }

    public void setBasket(Map<Product, Integer> basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "producten=" + basket +
                '}';
    }

    @Override
    public void addToBasket(Product p, int amount) {
        basket.put(p, amount);
    }

    @Override
    public void removeProductFromBasket(Product product) {
        basket.remove(product);
    }

    @Override
    public void clearBasket() {
        basket.clear();
    }

        @Override
        public void saveBasket (Order order){
            String SQL_ORDERINSERT = "INSERT INTO eshop.order (id,Payment method, Order Total, Date, customer_id1, eshop_id1) VALUES (null,?, ?, ?, ?, ?)";
            String SQL_ORDERDETAIL = "INSERT INTO eshop.orderdetail (Amount, product_id1, order_id1) VALUES (?, ?, ?)";
            String SQL_PRODUCT="UPDATE eshop.product SET Stock=? WHERE product_id1=? ";

            try (Connection connection = ConnectionDB.getConnection();
                 PreparedStatement statement = connection.prepareStatement(SQL_ORDERINSERT, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement detailStatement = connection.prepareStatement(SQL_ORDERDETAIL);
                 PreparedStatement productstatement=connection.prepareStatement(SQL_PRODUCT)) {

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

                //basket.getBasket().forEach()
                detailStatement.setDouble(1, order.getAmount());
                detailStatement.setLong(2, order.getIdProduct());
                detailStatement.setLong(3, orderId);        //orderId is pas in de vorige stap aangemaakt. Deze kan je met getGeneratedKeys() ophalen op het statement.

                System.out.println(statement);

                detailStatement.executeUpdate();

                productstatement.setInt(2,order.getIdProduct());
                productstatement.setInt(1,product.getStock()-order.getAmount());
                productstatement.executeUpdate();

                connection.commit();
                clearBasket();
                LOGGER.debug("Basket saved in database");

            } catch (SQLException e) {
                LOGGER.error("Basket is not saved in database"+e);
                e.printStackTrace();
            }


        }

    }

