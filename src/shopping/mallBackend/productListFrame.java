package shopping.mallBackend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import shopping.bundling.*;
import shopping.composite.compositeOperating;
import shopping.composite.leafEletricProduct;
import shopping.composite.leafFurniture;
import shopping.mall.dataTransform;
import shopping.mall.mall;
import shopping.visitor.computer;
import shopping.visitor.computerPart;
import shopping.visitor.computerPartDisplayVisitor;

public class productListFrame {

    JTable productListTable;
    JFrame productListGui = new JFrame("Mall");

    public productListFrame(shoppingCartFrame shoppingCart, mall mall) {
        initComponents(shoppingCart, mall);
    }

    private void initComponents(shoppingCartFrame shoppingCart, mall mall) {

        compositeOperating operating = new compositeOperating(0,"operating");

        productListGui.setLayout(null);
        productListGui.setResizable(false);

        productListGui.setLayout(new BorderLayout()); // New BorderLayout Layout

        // Content
        JPanel panel2 = new JPanel(new FlowLayout());

        DefaultTableModel model = new DefaultTableModel() { // Set table data unchangeable
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Vector<Vector<Object>> date = new Vector<Vector<Object>>();
        Vector<String> names = new Vector<String>();
        names.add("Product ID");
        names.add("Product Name");
        names.add("Unit price (€)");
        dataTransform.changeList(mall.getProlist(),date);
        model.setDataVector(date, names);

        JTable productListTable = new JTable(model);//Create a table and set row data and table head
        windowSetting.setTable(productListTable); // Set Table

        JScrollPane ProductListScrollPane = new JScrollPane(productListTable);

        panel2.add(ProductListScrollPane);
        panel2.setBorder(new EmptyBorder(10, 10, 10, 10));
        productListGui.add(panel2, BorderLayout.CENTER);

        // Title
        JPanel panel1 = new JPanel(new GridLayout(2, 0));
        JLabel jl1 = new JLabel("Product List");
        jl1.setFont(new Font("Adobe Gothic Std B", Font.BOLD, 25)); // Set font
        JLabel jl2 = new JLabel("Total " + productListTable.getRowCount() + " items");
        jl2.setFont(new Font("Times New Roma", Font.PLAIN, 19)); // Set font
        panel1.add(jl1);
        panel1.add(jl2);
        panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
        productListGui.add(panel1, BorderLayout.NORTH);

        // Copyright
        JPanel panel3 = new JPanel(new GridLayout(2, 0));
        JButton jb1 = new JButton("add to shopping cart");
        jb1.setFont(new java.awt.Font("Times New Roma", 1, 20));
        JLabel jl3 = new JLabel("Shopping System");
        jl3.setFont(new Font("Times New Roma", Font.PLAIN, 15)); // Set font
        jl3.setHorizontalAlignment(SwingConstants.CENTER);
        panel3.add(jb1, JPanel.RIGHT_ALIGNMENT);
        panel3.add(jl3);
        productListGui.add(panel3, BorderLayout.SOUTH);

        // Display the window.
        productListGui.setSize(450, 800);
        productListGui.setVisible(false);
        // Set Windows mediate
        windowSetting.setFrameNear(productListGui);

        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // AddProduct();
                String inputValue = JOptionPane.showInputDialog("Please enter number of items you want to add");
                int a = Integer.parseInt(inputValue);
                DefaultTableModel dtm = (javax.swing.table.DefaultTableModel) productListTable.getModel();

                int row = productListTable.getSelectedRow();
                // the bundling function
                double cost = 0;
                bundleBuilder builder = new bundleBuilder();
                System.out.println("here");

                int flag = 0;

                if (dtm.getValueAt(row, 1).equals("furniture bundling")) {
                    bundleProduct furniture = builder.prepareFurniture();
                    System.out.println("furniture bundling");
                    furniture.showItems();
                    System.out.println("Total Cost: " + furniture.getCost());
                    cost = furniture.getCost();

                    leafFurniture Furniture = new leafFurniture(furniture.getCost(), "Furniture Bundling");
                    operating.addProduct(Furniture);

                    flag = 1;
                }

                if (dtm.getValueAt(row, 1).equals("mobile bundling")) {
                    bundleProduct mobile = builder.prepareElectricalProduct();
                    System.out.println("\n\nmobile bundling");
                    mobile.showItems();
                    System.out.println("Total Cost: " + mobile.getCost());
                    cost = mobile.getCost();

                    leafEletricProduct EletricProduct = new leafEletricProduct(mobile.getCost(), "Electric Product Bundling");
                    operating.addProduct(EletricProduct);

                    flag = 1;
                }

                if (dtm.getValueAt(row, 1).equals("mobile bundling")) {
                    bundleProduct mobile = builder.prepareElectricalProduct();
                    System.out.println("\n\nmobile bundling");
                    mobile.showItems();
                    System.out.println("Total Cost: " + mobile.getCost());
                    cost = mobile.getCost();

                    leafEletricProduct EletricProduct = new leafEletricProduct(mobile.getCost(), "Electric Product Bundling");
                    operating.addProduct(EletricProduct);

                    flag = 1;
                }

                if (dtm.getValueAt(row, 1).equals("computer")) {
                    bundleProduct computer = builder.prepareElectricalProduct();
                    computer.showItems();
                    cost = computer.getCost();

                    // Use ComputerPartDisplayVisitor to display the components of Computer
                    computerPart computerpart = new computer();
                    computerpart.accept(new computerPartDisplayVisitor());
                }

                if (flag == 1){
                    operating.printProduct();
                }

                cost += (double)dtm.getValueAt(row, 2);

                Vector<Object> v = new Vector<Object>();
                v.add(dtm.getValueAt(row, 0));
                v.add(dtm.getValueAt(row, 1));
                v.add(cost);
                v.add(a);
                double b = (double) dtm.getValueAt(row, 2);
                double vSum = a * cost;
                v.add(vSum);
                dataTransform pro = new dataTransform();

                shopping.mall.shoppingCart cart = shoppingCart.getShoppingCart();
                int index = cart.addProduct(pro.productTransform(v));

                if (index != -1) {// add items in shopping cart
                    DefaultTableModel dd = (DefaultTableModel) shoppingCart.shoppingCartTable.getModel();
                    dd.setValueAt(cart.getProlist().get(index).getNum(), index, 3);
                    double total = cart.getProlist().get(index).getNum()* cart.getProlist().get(index).getPrice();
                    dd.setValueAt(total, index, 4);
                } else {// add a row of new items
                    shoppingCart.getDate().add(v);
                    shoppingCart.getShoppingCartTable().updateUI();
                    shoppingCart.getJl2().setText("A total of " + shoppingCart.getShoppingCartTable().getRowCount() + " items");
                    shoppingCart.getJl0().setText("Total " + cart.getTotal() + " €");
                }


                shoppingCartFrame.setShoppingCartCenterPanel(1);
            }
        });
    }

    public JTable getProductList() {
        return productListTable;
    }

    public void setProductList(JTable productList) {
        productListTable = productList;
    }

    public JFrame getShoppingCarGui() {
        return productListGui;
    }

    public void setShoppingCarGui(JFrame shoppingCarGui) {
        productListGui = shoppingCarGui;
    }

}
