package be.vdab.be.vdab.dao;

import be.vdab.entiteiten.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findProducts(String productname);
}
