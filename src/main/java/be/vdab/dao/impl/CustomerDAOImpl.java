package be.vdab.dao.impl;

import be.vdab.be.vdab.dao.CustomerDAO;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {
    Customer customer;
    User user;

    @Override
    public Customer findCustomer(String name, String firstname, String username) {
        String sql = "Select * from customer where Name='" + name + "' and FirstName='" + firstname + "'and Username='" + username + "';";

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                int id = rs.getInt("id");
                String nameCustomer = rs.getString("Name");
                String firstName = rs.getString("FirstName");
                String email = rs.getString("E-mail");
                String deliveryAddress = rs.getString("DeliveryAddress");
                String userName = rs.getString("Username");
                String password = rs.getString("Password");

                customer = new Customer(id, userName, password, name, firstName, email, deliveryAddress);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public User findByLoginAndUsername(String username, String password) {
        String sql = "Select * from customer where Username='" + username + "' and Password='" + password + "';";

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                String firstName = rs.getString("FirstName");
                String email = rs.getString("E-mail");
                String deliveryAddress = rs.getString("DeliveryAddress");
                String userName = rs.getString("Username");
                String password1 = rs.getString("Password");

                user = new User(id, userName, password1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
