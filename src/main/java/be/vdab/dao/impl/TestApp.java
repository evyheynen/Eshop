package be.vdab.dao.impl;

import be.vdab.be.vdab.dao.CustomerDAO;
import be.vdab.be.vdab.dao.ShopDAO;

public class TestApp {
    private static ShopDAO s=new ShopDAOImpl();
    private static CustomerDAO c= new CustomerDAOImpl();
    private static CustomerDAO c2=new CustomerDAOImpl();


    public static void main(String[] args) {

        s.listAllShops().forEach(System.out::println);
        System.out.println(c.findCustomer("Jansen","Ann","Anneke"));
        System.out.println(c2.findByLoginAndUsername("Luc","Luc123"));
    }
}
