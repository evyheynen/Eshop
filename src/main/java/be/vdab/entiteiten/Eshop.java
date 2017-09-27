package be.vdab.entiteiten;

public class Eshop {
    private int idShop;
    private String info;
    private String address;

    public Eshop(int idShop, String info, String address) {
        this.idShop = idShop;
        this.info = info;
        this.address = address;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Eshop{" +
                "idShop=" + idShop +
                ", info='" + info + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
