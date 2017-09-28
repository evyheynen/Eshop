package be.vdab.entiteiten;

import java.sql.Date;

public class Order {
    private int idOrder;
    private String paymentMethod;
    private int orderTotal;
    private Date date;


    public Order(int idOrder, String paymentMethod, int orderTotal, Date date) {
        this.idOrder = idOrder;
        this.paymentMethod = paymentMethod;
        this.orderTotal = orderTotal;
        this.date = date;
    }

    public Order(String paymentMethod, int orderTotal, Date date) {
        this.paymentMethod = paymentMethod;
        this.orderTotal = orderTotal;
        this.date = date;
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


    @Override
    public String toString() {
        return "OrderDAO{" +
                "idOrder=" + idOrder +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", orderTotal=" + orderTotal +
                ", date=" + date +
                '}';
    }
}
