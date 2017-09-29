package be.vdab.ui;

import be.vdab.entiteiten.Basket;
import be.vdab.entiteiten.Eshop;

import javax.swing.*;
import java.awt.*;

public class ShopKeuze extends JFrame {
    private String userName;
    private Eshop eshop;

    private final JLabel label = new JLabel();
    private final JButton button = new JButton("Maak keuze");


    public ShopKeuze() {
        super("Shop keuze scherm");
        setSize(300, 300);

        add(new JLabel("Welkom "+userName+"maak je shop keuze om verder te gaan."),BorderLayout.CENTER);
        add(new JLabel("Shop keuze: "),BorderLayout.WEST);

        JMenuBar bar=new JMenuBar();
        setJMenuBar(bar);
        JMenu shop=new JMenu("Shop x");
        bar.add(shop);
        JMenuItem shopx=new JMenuItem("shop x en x");
        add((button),BorderLayout.EAST);
        button.addActionListener(keuze -> keuzeShop());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void keuzeShop() {
        Basket basket = new Basket();
    }

}
