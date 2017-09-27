package be.vdab.dao.impl;

import be.vdab.entiteiten.Eshop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ShopDAOImpl implements be.vdab.be.vdab.dao.ShopDAO {
    List<Eshop> eshops;
    //private static final Logger LOGGER = Logger.getLogger(ShopDAOImpl.class);

    public List<Eshop> listAllShops() {
        eshops=new ArrayList<>();

        String sql = "Select id,info,address from eshop";

        try (Connection con = ConnectionDB.getConnection(); Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int idShop = rs.getInt("id");
                String info = rs.getString("info");
                String address = rs.getString("address");

                eshops.add(new Eshop(idShop,info,address));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           //LOGGER.error("Could nog connect to database: " + ex);
        }
        return eshops;
    }

}
