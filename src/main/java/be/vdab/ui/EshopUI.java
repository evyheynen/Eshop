package be.vdab.ui;

import javax.swing.*;
import java.awt.*;

public class EshopUI extends JFrame {
    private String userName;
    private String password;
    private final JLabel labelInloggen = new JLabel();
    private final JTextField tekstName = new JTextField();
    private final JTextField tekstPassword = new JTextField();
    private final JButton button = new JButton("Inloggen");

    public EshopUI() {
        super("UserID");
                setSize(300,100);

        setLayout(new GridLayout(3,2));
        add(new JLabel("Username: "));
        add(tekstName);
        add(new JLabel("Password: "));
        add(tekstPassword);
        add(button,3,2);
        button.addActionListener(inloggen -> createUser());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createUser() {
        if (userName == null || userName.isEmpty()) {
            JOptionPane.showMessageDialog(this,"Username has to be filled in");
        } else
            userName = tekstName.getText();

        if (password==null || password.isEmpty()){
        JOptionPane.showMessageDialog(this,"Password has to be filled in");
    }
        password = tekstPassword.getText();

    }
}
