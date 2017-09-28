package be.vdab.entiteiten;

import be.vdab.be.vdab.dao.BasketInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class BasketTest {

    private Basket basket = new Basket();
    private Product dreft;
    @Before
    public void init(){
        Product cola=new Product(100,"Cola",3.20);
        Product fanta=new Product(101,"Fanta",3.50);
        dreft = new Product(102,"Dreft",2.00);
        Map<Product, Integer> map= new HashMap<>();
        map.put(cola, 3);
        map.put(fanta, 6);
        map.put(dreft, 1);
        basket.setBasket(map);

    }
    @Test
    public void getBasket() {
        Map<Product, Integer> map = this.basket.getBasket();
        assertThat(map).hasSize(3);
    }

    @Test
    public void addToBasket(){
       Product sprite =  new Product(103,"Sprite",3.60);

        basket.addToBasket(sprite,6);
        assertThat(basket.getBasket()).hasSize(4);
        assertThat(basket.getBasket().get(sprite)).isEqualTo(6);
    }

    @Test
    public void removerProductFromBasket() {
        basket.removerProductFromBasket(dreft);
        assertThat(basket.getBasket()).hasSize(2);
    }

    @Test
    public void clearBasket() {
        basket.clearBasket();
        assertThat(basket.getBasket()).isEmpty();
    }

}