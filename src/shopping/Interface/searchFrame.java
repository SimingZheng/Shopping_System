package shopping.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import shopping.model.dataTransform;
import shopping.model.mall;
import shopping.model.product;

public class searchFrame {
    JFrame searchGui = new JFrame("Search");


    public searchFrame(shoppingCartFrame shoppingcar, mall mall) {
        initSearchGui(shoppingcar,mall);
    }

    public void initSearchGui(shoppingCartFrame shoppingcar, mall mall) {


        searchGui.setLayout(null); // clean
        searchGui.setResizable(false); // Set the form size to be immutable

        searchGui.setLayout(new BorderLayout());

        // Title
        JPanel panel1 = new JPanel(new FlowLayout());
        JLabel jl1 = new JLabel("Product Search");
        jl1.setFont(new Font("Times New Roma", Font.BOLD, 35)); // set font
        panel1.add(jl1);
        searchGui.add(panel1, BorderLayout.NORTH);

        //content
        JPanel panel2 = new JPanel(new FlowLayout());
        JPanel p0 = new JPanel(new FlowLayout());
        JLabel jl2 = new JLabel("Please enter the product name：");
        jl2.setFont(new Font("Times New Roma", Font.BOLD, 15)); // set font
        JTextField jt1 = new JTextField(12); // Create text box
        JButton jb1 = new JButton("Search");

        p0.add(jl2);
        p0.add(jt1);
        p0.add(jb1);
        JPanel p1 = new JPanel(new FlowLayout());
        JButton jb2= new JButton("add to shopping cart");
        p1.add(jb2);

        Vector<Vector<Object>> vDate = new Vector<Vector<Object>>();
        Vector<String> vName = new Vector<String>();
        vName.addElement("products number");vName.addElement("products name");vName.addElement("Unit price (€)");
        DefaultTableModel model = new DefaultTableModel() { // Table data cannot be changed

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.setDataVector(vDate,vName);

        JTable searchList = new JTable(model);// Create a table that specifies all row data and table headers
        windowSetting.setTable(searchList); // Set the table
        searchList.setPreferredScrollableViewportSize(new Dimension(400, 210));
        JScrollPane searchtListScrollPane = new JScrollPane(searchList);

        panel2.add(searchtListScrollPane);

        panel2.add(p0);
        panel2.add(searchtListScrollPane);
        panel2.add(p1);
        searchGui.add(panel2);

        // Copyright ownership
        JPanel panel3 = new JPanel(new FlowLayout());
        JLabel jl3 = new JLabel("Shopping System");
        jl3.setFont(new Font("Times New Roma", Font.PLAIN, 15)); // Set font
        jl3.setHorizontalAlignment(SwingConstants.CENTER); // Sets the left and right center alignment of the control

        panel3.add(jl3);
        searchGui.add(panel3, BorderLayout.SOUTH);

        // Display the window.
        searchGui.setSize(550, 450);
        searchGui.setVisible(false);
        // Set the window to center
        windowSetting.setFrameNear(searchGui);

        jb1.addActionListener(new ActionListener() {//Search for goods

            public void actionPerformed(ActionEvent e) {
                vDate.clear();
                String pro=jt1.getText();
                ArrayList<product> prolist=mall.searchProduct(pro);
                dataTransform.changeList(prolist,vDate);
                searchList.updateUI();
            }
        });
        jb2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {//Add items to shopping cart
                String inputValue = JOptionPane.showInputDialog("Please enter the number of items added");
                int a=Integer.parseInt(inputValue);
                DefaultTableModel dtm=(javax.swing.table.DefaultTableModel)searchList.getModel();
                int row=searchList.getSelectedRow();
                Vector<Object> v=new Vector<Object>();
                v.add(dtm.getValueAt(row, 0));
                v.add(dtm.getValueAt(row, 1));
                v.add(dtm.getValueAt(row, 2));
                v.add(a);
                double b=(double) dtm.getValueAt(row, 2);
                double sum=a*b;
                v.add(sum);
                dataTransform pro = new dataTransform();

                int i=shoppingcar.getShoppingCart().addProduct(pro.productTransform(v));
                if(i!=-1) {//Add existing products to cart
                    DefaultTableModel dd=(DefaultTableModel)shoppingcar.shoppingCartTable.getModel();
                    dd.setValueAt(shoppingcar.getShoppingCart().getProlist().get(i).getNum(), i, 3);
                    double total=shoppingcar.getShoppingCart().getProlist().get(i).getNum()*shoppingcar.getShoppingCart().getProlist().get(i).getPrice();
                    dd.setValueAt(total, i, 4);
                }
                else {//Add a new line of products
                    shoppingcar.getDate().add(v);
                    shoppingcar.getShoppingCartTable().updateUI();
                    shoppingcar.getJl2().setText("A total of " + shoppingcar.getShoppingCartTable().getRowCount() + " item");
                    double price=Double.parseDouble(v.get(2).toString());
                    shoppingcar.getJl0().setText("Total " + shoppingcar.getShoppingCart().getTotal() + " €");
                }

                shoppingcar.setShoppingCartCenterPanel(1);
            }
        });
    }

    public JFrame getSearchGui() {
        return searchGui;
    }

    public void setSearchGui(JFrame searchGui) {
        this.searchGui = searchGui;
    }

}
