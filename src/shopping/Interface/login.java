package shopping.Interface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import shopping.model.membershipIdentify;
import shopping.model.user;
import shopping.model.userInitial;

public class login {
    private String [] ArrayUser = new String[3];

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
        JButton jb2 = new JButton("general");
        JButton jb3 = new JButton("vip");
        JButton jb4 = new JButton("gold");
        JButton jb5 = new JButton("supreme");
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
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jb2.setText("login......");
                inter.setVisible(false);
                membershipIdentify membershipIdentify = new membershipIdentify();
                ArrayUser = membershipIdentify.getUserMembership("General");
                String name = ArrayUser[0];
                String membership = ArrayUser[1];
                int point = Integer.parseInt(ArrayUser[2]);
                new menu(name, membership, point);
                }
        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jb3.setText("login......");
                inter.setVisible(false);
                membershipIdentify membershipIdentify = new membershipIdentify();
                ArrayUser = membershipIdentify.getUserMembership("VIP");
                String name = ArrayUser[0];
                String membership = ArrayUser[1];
                int point = Integer.parseInt(ArrayUser[2]);
                new menu(name, membership, point);
            }
        });
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jb4.setText("login......");
                inter.setVisible(false);
                membershipIdentify membershipIdentify = new membershipIdentify();
                ArrayUser = membershipIdentify.getUserMembership("Gold");
                String name = ArrayUser[0];
                String membership = ArrayUser[1];
                int point = Integer.parseInt(ArrayUser[2]);
                new menu(name, membership, point);
            }
        });
        jb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jb5.setText("login......");
                inter.setVisible(false);
                membershipIdentify membershipIdentify = new membershipIdentify();
                ArrayUser = membershipIdentify.getUserMembership("Supreme");
                String name = ArrayUser[0];
                String membership = ArrayUser[1];
                int point = Integer.parseInt(ArrayUser[2]);
                new menu(name, membership, point);
            }
        });

        panel2.add(jb1);
        panel2.add(jb2);
        panel2.add(jb3);
        panel2.add(jb4);
        panel2.add(jb5);

        inter.add(panel2, BorderLayout.SOUTH);

        // Display the window.
        inter.pack();
        inter.setVisible(true);
        // The setting window is displayed in the center
        windowSetting.setFrameCenter(inter);

    }

}
