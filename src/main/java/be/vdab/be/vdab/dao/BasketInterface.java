package be.vdab.be.vdab.dao;

import be.vdab.entiteiten.Basket;
import be.vdab.entiteiten.Product;

public interface BasketInterface {
   /* void saveOrUdateBasket(Basket basket);
    void addProductToBasket(Product product);
    void removeProductFromBasket(Product product);
    Basket getBasket();
    void clearBasket();
    */

    public void addToBasket(Product p, int amount);

    public void removerProductFromBasket(Product product) ;

    public void clearBasket() ;

    void  updateProduct(Product product);
}
