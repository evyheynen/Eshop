package be.vdab.dao.impl;

import be.vdab.be.vdab.dao.ProductDAO;
import be.vdab.entiteiten.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductDAOImpl implements ProductDAO {
    private static Logger LOGGER= LogManager.getLogger();
    List<Product> productList;

    @Override
    public List<Product> findProducts(String productname) {
        productList=new ArrayList<>();
        String sql="Select * from Product where Name='"+productname+"';";

        try(Connection con=ConnectionDB.getConnection();
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery()){

            while(rs.next()){
                int id=rs.getInt("id");
                String productName=rs.getString("Name");
                Double price=rs.getDouble("Price");
                int stock1=rs.getInt("Stock");

                productList.add(new Product(id,productName,price));
                LOGGER.debug("Products found");
            }
        } catch (SQLException e) {
            LOGGER.error("Products not found"+e);
            e.printStackTrace();
        }

        return productList;
    }
}
