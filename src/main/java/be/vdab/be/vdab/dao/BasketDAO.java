package be.vdab.be.vdab.dao;

public interface BasketDAO {
    void saveOrUdateBasket(BasketDAO basket);
    void addProductToBasket(ProductDAO productDAO);
    void removeProductFromBasket(ProductDAO productDAO);
    BasketDAO getBasket();
    void clearBasket();
}
