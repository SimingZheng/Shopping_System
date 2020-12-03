package shopping.Interface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import shopping.model.user;
import shopping.model.userInitial;

public class login {
    public login() {
        initInterGui();
    }
    //  Login interface GUI
    public void initInterGui() {
        JFrame inter = new JFrame("Please login");

        inter.setLayout(null); // Clear layout function
        inter.setResizable(false); // Set the window size to be immutable
        inter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inter.setLayout(new BorderLayout()); // New BorderLayout layout

        // background
        JPanel panel0 = new JPanel(new FlowLayout());
        ImageIcon icon = new ImageIcon("image/Cart.png");
        JLabel label = new JLabel(icon);
        panel0.add(label);
        inter.add(panel0, BorderLayout.NORTH);

        // Account password box
        JPanel panel1 = new JPanel(new GridLayout(2, 1, 0, 20));
        panel1.setBorder(new EmptyBorder(10, 10, 10, 60));

        JLabel jl1 = new JLabel("account"); // Create account label
        jl1.setFont(new Font("Adobe Gothic Std B", Font.BOLD, 16)); // Set font, style, size
        jl1.setHorizontalAlignment(JTextField.CENTER); // Set horizontal center
        JTextField jt1 = new JTextField(10); // Create text box
        jt1.setFont(new Font("Adobe Gothic Std B", Font.PLAIN, 16)); // Set font, style, size

        JLabel jl2 = new JLabel("password"); // Create a password label
        jl2.setFont(new Font("Adobe Gothic Std B", Font.BOLD, 16)); // Set font, style, size
        jl2.setHorizontalAlignment(JTextField.CENTER); // Set centered
        JPasswordField jt2 = new JPasswordField(10); // Create a password text box
        jt2.setEchoChar('*'); // Set the echo character to *
        jt2.setFont(new Font("Adobe Gothic Std B", Font.PLAIN, 16)); // Set font, style, size

        panel1.add(jl1);
        panel1.add(jt1);
        panel1.add(jl2);
        panel1.add(jt2);

        inter.add(panel1, BorderLayout.CENTER);

        // Login button
        JPanel panel2 = new JPanel(new FlowLayout());

        JButton jb1 = new JButton("login");
        // Login button trigger event
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jb1.setText("login......");
                String userName = jt1.getText();
                String password = new String(jt2.getPassword());
                userInitial ud = new userInitial();
                user user = ud.isLogin(userName, password);
                if (user != null) {
                    inter.setVisible(false);
                    String name = user.getUserName();
                    String membership = user.getMembership();
                    int point = user.getPoint();
                    new menu(name, membership, point);
                } else {
                    JOptionPane.showMessageDialog(inter, "The password you entered does not match the account name");
                    jt2.setText("");
                    jb1.setText("login");
                }
            }
        });


        panel2.add(jb1);

        inter.add(panel2, BorderLayout.SOUTH);

        // Display the window.
        inter.pack();
        inter.setVisible(true);
        // The setting window is displayed in the center
        windowSetting.setFrameCenter(inter);

    }

}
