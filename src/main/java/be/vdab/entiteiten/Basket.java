package be.vdab.entiteiten;

import be.vdab.be.vdab.dao.BasketInterface;

import java.util.HashMap;
import java.util.Map;

public class Basket implements BasketInterface {
    private Map<Product, Integer> basket;

    public Basket() {
        basket = new HashMap<>();
    }

    public Map<Product, Integer> getBasket() {
        return basket;
    }

    public void setBasket(Map<Product, Integer> basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "producten=" + basket +
                '}';
    }

    @Override
    public void addToBasket(Product p, int amount) {
        basket.put(p, amount);
    }

    @Override
    public void removerProductFromBasket(Product product) {
    basket.remove(product);
    }

    @Override
    public void clearBasket() {
        basket.clear();
    }

}
