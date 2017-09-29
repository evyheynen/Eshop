package be.vdab.dao.impl;

import be.vdab.be.vdab.dao.CustomerDAO;
import be.vdab.be.vdab.dao.OrderDAO;
import be.vdab.be.vdab.dao.ProductDAO;
import be.vdab.be.vdab.dao.ShopDAO;
import be.vdab.entiteiten.Basket;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.Order;

import java.sql.Date;


public class TestApp {
    private static ShopDAO s = new ShopDAOImpl();
    private static CustomerDAO c = new CustomerDAOImpl();
    private static CustomerDAO c2 = new CustomerDAOImpl();
    private static ProductDAO p = new ProductDAOImpl();
    private static Customer luc = new Customer(2, "Luc", "Luc123", "Van der Perre", "Luc", "luc.vdp@hotmail.com", "Lage Kaart 3, Balen");
    private static OrderDAO order=new OrderDAOImpl();
    private static Basket basket=new Basket();

    public static void main(String[] args) {

        s.listAllShops().forEach(System.out::println);
        System.out.println(c.findCustomer("Jansen", "Ann", "Anneke"));
        System.out.println(c2.findByLoginAndUsername("Luc", "Luc123"));
        p.findProducts("toilettas").forEach(System.out::println);
        order.findOrdersForCustomer(luc);
        //order.saveOrder(new Order("paypal",30, new Date(2017,9,28),1,1,6,2));
        basket.saveBasket(new Order("mastercard",100, new Date(2017,9,29), 2, 1, 5, 1));
    }
}
