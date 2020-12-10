package shopping.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shopping.mall.mall;


public class menu {
    public menu(String name, String membership, int point) {
        initmenuGui(name, membership, point);
    }
    //Menu GUI
    public void initmenuGui(String name, String membership, int point) {

        mall mall=new mall();//New mall
        shopping.mall.mall.importMall1(mall.getProlist());//Import product information of Mall 1



        orderFrame ordergui=new orderFrame(name, point);//New order interface
        shoppingCartFrame shoppingcartgui= new shoppingCartFrame(ordergui, name, membership, point);//New shopping cart interface
        productListFrame productlistgui=new productListFrame(shoppingcartgui,mall);//New product list interface
        searchFrame search=new searchFrame(shoppingcartgui,mall);//New search interface


        JFrame menu = new JFrame("Menu navigation");

        menu.setLayout(null); // Clear layout function
        menu.setResizable(false); // Set the window size to be immutable
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu.setLayout(new BorderLayout()); // New BorderLayout layout

        // Welcome Message
        JPanel panel1 = new JPanel(new FlowLayout());
        JLabel jl1 = new JLabel("Welcome "+ name + " you are "+ membership + " user");
        jl1.setFont(new Font("Adobe Gothic Std B", Font.BOLD, 30)); // Set font, style, size
        panel1.add(jl1);
        panel1.setBorder(new EmptyBorder(10, 100, 0, 100));
        menu.add(panel1, BorderLayout.NORTH);

        // Menu button
        JPanel panel2 = new JPanel(new GridLayout(5, 1));
        JButton jb1 = new JButton("Item list");
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productlistgui.getShoppingCarGui().setVisible(true);
            }
        });

        JButton jb2 = new JButton("Find item");
        jb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search.searchGui.setVisible(true);
            }
        });

        JButton jb3 = new JButton("My Cart");
        jb3.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoppingcartgui.getShoppingCarGui().setVisible(true);
            }
        });

        JButton jb4 = new JButton("My order");
        jb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordergui.getOrderGui().setVisible(true);
            }
        });

        JButton jb5 = new JButton("Quit");
        jb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        int w = 10;
        int h = 50;
        jb1.setPreferredSize(new Dimension(w, h));
        jb2.setPreferredSize(new Dimension(w, h));
        jb3.setPreferredSize(new Dimension(w, h));
        jb4.setPreferredSize(new Dimension(w, h));
        jb5.setPreferredSize(new Dimension(w, h));

        jb1.setFont(new java.awt.Font("Adobe Gothic Std B", 1, 20));
        jb2.setFont(new java.awt.Font("Adobe Gothic Std B", 1, 20));
        jb3.setFont(new java.awt.Font("Adobe Gothic Std B", 1, 20));
        jb4.setFont(new java.awt.Font("Adobe Gothic Std B", 1, 20));
        jb5.setFont(new java.awt.Font("Adobe Gothic Std B", 1, 20));

        panel2.add(jb1);
        panel2.add(jb2);
        panel2.add(jb3);
        panel2.add(jb4);
        panel2.add(jb5);

        panel2.setBorder(new EmptyBorder(20, 20, 20, 20));
        menu.add(panel2);

        JPanel panel3 = new JPanel(new FlowLayout());
        JLabel jl3 = new JLabel("Shopping system");
        jl3.setFont(new Font("Adobe Gothic Std B", Font.PLAIN, 15)); // Set font, style, size
        panel3.add(jl3);
        menu.add(panel3, BorderLayout.SOUTH);

        // Display the window.
        menu.pack();
        menu.setVisible(true);
        // The setting window is displayed in the center
        windowSetting.setFrameCenter(menu);
    }

}
