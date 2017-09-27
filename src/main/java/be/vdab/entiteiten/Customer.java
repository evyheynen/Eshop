package be.vdab.entiteiten;

public class Customer extends User {
    private String name;
    private String firstName;
    private String eMail;
    private String DeliveryAdress;

    public Customer(int id, String userName, String password, String name, String firstName, String eMail, String deliveryAdress) {
        super(id, userName, password);
        this.name = name;
        this.firstName = firstName;
        this.eMail = eMail;
        DeliveryAdress = deliveryAdress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getDeliveryAdress() {
        return DeliveryAdress;
    }

    public void setDeliveryAdress(String deliveryAdress) {
        DeliveryAdress = deliveryAdress;
    }

    @Override
    public String toString() {
        return super.toString()+"Customer{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", DeliveryAdress='" + DeliveryAdress + '\'' +
                '}';
    }
}
