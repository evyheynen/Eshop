package be.vdab.entiteiten;

import java.sql.Date;

public class Order {
    private static Basket basket1;

    private int idOrder;
    private String paymentMethod;
    private int orderTotal;
    private Date date;
    private int idCustomer;
    private int idEshop;
    private int amount;
    private int idProduct;
    private Basket basket;

    public Order(int idOrder, String paymentMethod, int orderTotal, Date date, int idCustomer, int idEshop, int amount, int idProduct) {
        this.idOrder = idOrder;
        this.paymentMethod = paymentMethod;
        this.orderTotal = orderTotal;
        this.date = date;
        this.idCustomer = idCustomer;
        this.idEshop = idEshop;
        this.amount = amount;
        this.idProduct = idProduct;
        this.basket=basket;
    }

    public Order(String paymentMethod, int orderTotal, Date date, int idCustomer, int idEshop,Basket basket1) {
        this.paymentMethod = paymentMethod;
        this.orderTotal = orderTotal;
        this.date = date;
        this.idCustomer = idCustomer;
        this.idEshop = idEshop;
        this.basket1=basket1;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public int getIdEshop() {
        return idEshop;
    }

    public int getAmount() {
        return amount;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public static Basket getBasket1() {
        return basket1;
    }

    public static void setBasket1(Basket basket1) {
        Order.basket1 = basket1;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", orderTotal=" + orderTotal +
                ", date=" + date +
                ", idCustomer=" + idCustomer +
                ", idEshop=" + idEshop +
                ", amount=" + amount +
                ", idProduct=" + idProduct +
                '}';
    }
}
