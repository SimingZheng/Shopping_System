package shopping.Interface;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import shopping.model.shoppingCart;
import shopping.model.order;

public class shoppingCartFrame {
    JTable shoppingCartTable;
    JFrame emptyShoppingCarGui = new JFrame("Cart");
    JFrame ShoppingCarGui = new JFrame("Cart");
    Vector<Vector<Object>> date = new Vector<Vector<Object>>();
    Vector<String> ColumnNames = new Vector<String>();
    JLabel jl2;//The number of items in shopping cart
    JLabel jl0;//The total price of items in shopping cart
    shopping.model.shoppingCart shoppingCart=new shoppingCart();
    static CardLayout card = new CardLayout();
    static JPanel centerPanel=new JPanel(card);

    public shoppingCartFrame(orderFrame order){
        initShoppingCarGui(order);
    }

    public void initShoppingCarGui(orderFrame order) {


        ShoppingCarGui.setLayout(null);
        ShoppingCarGui.setResizable(false); // Set the Windows size unchanged

        ShoppingCarGui.setLayout(new BorderLayout()); // create BorderLayout

        //
        // empty shopping cart
        JPanel panel0 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ImageIcon icon = new ImageIcon("image/empty cart.png");
        JLabel label = new JLabel(icon);
        panel0.add(label);

        //shopping cart with item
        JPanel panel2 = new JPanel(new FlowLayout(2));
        DefaultTableModel model = new DefaultTableModel() { // table data uneditable

            public boolean isCellEditable(int row, int column) {
                if( column == 3 ){
                    return true;
                }
                else return false;
            }
        };
        ColumnNames.add("item Number");ColumnNames.add("item name");ColumnNames.add("unit price (Euro)");ColumnNames.add("number");ColumnNames.add("total price");
        model.setDataVector(date,ColumnNames);
        shoppingCartTable = new JTable(model);
        windowSetting.setTable(shoppingCartTable);

        JScrollPane shoppingCarScrollPane = new JScrollPane(shoppingCartTable);
        shoppingCarScrollPane.setBorder(null);

        //Total
        JPanel p0 = new JPanel(new GridLayout(2, 0));
        JLabel jl00 = new JLabel(" ");
        jl0 = new JLabel("A total of " + shoppingCartTable.getRowCount() + " €");
        jl0.setFont(new Font("Meiryo UI", Font.PLAIN, 19)); // 设置字体、样式、大小

        JButton jb0 = new JButton("Delete item");
        jb0.setFont(new java.awt.Font("Adobe Gothic Std B", 1, 20));
        JButton jb1 = new JButton("Check out");
        jb1.setFont(new java.awt.Font("Adobe Gothic Std B", 1, 20));

        p0.add(jl00);
        p0.add(jl0);
        p0.add(jb0);
        p0.add(jb1);

        panel2.add(shoppingCarScrollPane);
        panel2.add(p0);

        panel2.setBorder(new EmptyBorder(10, 10, 10, 10));

        centerPanel.add(panel0,"emptyShoppingCart");
        centerPanel.add(panel2,"ShoppingCart");
        if( shoppingCartTable.getRowCount() == 0 ) {
            setShoppingCartCenterPanel(0);
        }else {
            setShoppingCartCenterPanel(1);
        }
        ShoppingCarGui.add(centerPanel, BorderLayout.CENTER);


        // Title
        JPanel panel1 = new JPanel(new GridLayout(2, 0));
        JLabel jl1 = new JLabel("Cart");
        jl1.setFont(new Font("Adobe Gothic Std B", Font.BOLD, 25)); // 设置字体、样式、大小
        jl2 = new JLabel("A total of " + shoppingCartTable.getRowCount() + " items");
        jl2.setFont(new Font("Adobe Gothic Std B", Font.PLAIN, 19)); // 设置字体、样式、大小
        panel1.add(jl1);
        panel1.add(jl2);
        panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
        ShoppingCarGui.add(panel1, BorderLayout.NORTH);

        // Copyright
        JPanel panel3 = new JPanel(new GridLayout(1, 0));
        JLabel jl3 = new JLabel("Shopping system");
        jl3.setFont(new Font("Adobe Gothic Std B", Font.PLAIN, 15)); // 设置字体、样式、大小
        jl3.setHorizontalAlignment(SwingConstants.CENTER); // 设置控件左右居中对齐
        panel3.add(jl3);
        ShoppingCarGui.add(panel3, BorderLayout.SOUTH);
        // Display the window.
        ShoppingCarGui.setSize(450, 850);
        ShoppingCarGui.setVisible(false);
        //
        windowSetting.setFrameNear(ShoppingCarGui);

        jb0.addActionListener(new java.awt.event.ActionListener() {//Delete the items
            public void actionPerformed(ActionEvent evt) {
                DefaultTableModel dtm=(DefaultTableModel)shoppingCartTable.getModel();
                int row=shoppingCartTable.getSelectedRow();
                String s=(String)dtm.getValueAt(row, 0);
                double n=Double.parseDouble(dtm.getValueAt(row, 4).toString());
                JOptionPane.showMessageDialog(null, "item "+ s + " successfully deleted！", "remind", JOptionPane.WARNING_MESSAGE);
                dtm.removeRow(row);
                shoppingCart.getProlist().remove(row);
                jl2.setText("A total of " + shoppingCartTable.getRowCount() + " items");
                shopping.model.shoppingCart.setTotal(shopping.model.shoppingCart.getTotal()-n);
                jl0.setText("Total " + shopping.model.shoppingCart.getTotal() + " €");
                if( shoppingCartTable.getRowCount() == 0 ) {
                    setShoppingCartCenterPanel(0);
                }
            }
        });
        jb1.addActionListener(new ActionListener() {//check out

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "successfully deleted", "remind", JOptionPane.WARNING_MESSAGE);
                if(date.isEmpty()) {
                    return;
                }
                shopping.model.order orderlist=new order(shoppingCart.getProlist(), shopping.model.shoppingCart.getTotal());
                order.importList(orderlist);
                shopping.model.shoppingCart.setTotal(0.0);
                jl2.setText("A total of  " + 0 + " item");
                jl0.setText("Total " + shopping.model.shoppingCart.getTotal() + " €");
                shoppingCart.getProlist().clear();
                date.clear();
                shoppingCartTable.updateUI();
                setShoppingCartCenterPanel(0);
                orderFrame.setOrderCenterPanel(1);
            }
        });
        shoppingCartTable.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                int col = e.getColumn();
                int row = e.getFirstRow();

                if (col == 3 ) {
                    double v4 = Double.valueOf(String.valueOf(shoppingCartTable.getValueAt(row, 4)));
                    shopping.model.shoppingCart.setTotal(shopping.model.shoppingCart.getTotal()-v4);
                    double v3 = 0;
                    try {
                        v3 = Double.valueOf(String.valueOf(shoppingCartTable.getValueAt(row, 3)));
                    } catch (NumberFormatException ex) {
                    }
                    double v2 = Double.valueOf(String.valueOf(shoppingCartTable.getValueAt(row, 2)));
                    shoppingCartTable.setValueAt(v2 * v3, row, 4);
                    v4 = Double.valueOf(String.valueOf(shoppingCartTable.getValueAt(row, 4)));
                    shopping.model.shoppingCart.setTotal(shopping.model.shoppingCart.getTotal()+v4);
                    jl0.setText("Total " + shopping.model.shoppingCart.getTotal() + " €");

                    shoppingCart.getProlist().get(row).setNum((int)v3);
                }
            }
        });
    }

    public JFrame getShoppingCarGui() {
        return ShoppingCarGui;
    }

    public void setShoppingCarGui(JFrame shoppingCarGui) {
        ShoppingCarGui = shoppingCarGui;
    }

    public shopping.model.shoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(shopping.model.shoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public JTable getShoppingCartTable() {
        return shoppingCartTable;
    }

    public void setShoppingCartTable(JTable shoppingCartTable) {
        this.shoppingCartTable = shoppingCartTable;
    }

    public JLabel getJl2() {
        return jl2;
    }

    public void setJl2(JLabel jl2) {
        this.jl2 = jl2;
    }

    public JLabel getJl0() {
        return jl0;
    }

    public void setJl0(JLabel jl0) {
        this.jl0 = jl0;
    }

    public static void setShoppingCartCenterPanel(int x) {
        if( x == 0 ) {
            card.show(centerPanel,"emptyShoppingCart");
        }else {
            card.show(centerPanel,"ShoppingCart");
        }
    }

    public Vector<Vector<Object>> getDate() {
        return date;
    }

    public void setDate(Vector<Vector<Object>> date) {
        this.date = date;
    }

}