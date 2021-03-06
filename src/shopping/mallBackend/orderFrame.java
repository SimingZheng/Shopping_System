package shopping.mallBackend;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Vector;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import shopping.mall.order;
import shopping.mall.product;

public class orderFrame {
    JTable orderTable;
    JFrame emptyorderGui = new JFrame("Order");
    JFrame orderGui = new JFrame("Order");
    Vector<Vector<Object>> vDate = new Vector<Vector<Object>>();//Table content
    Vector<String> vName = new Vector<String>();//Table head
    static CardLayout orderCard = new CardLayout();
    static JPanel centerPanel = new JPanel(orderCard);

    public orderFrame(String name, int point) {
        initorderGui(name, point);
    }

    public void initorderGui(String name, int point) {

        orderGui.setLayout(null);
        orderGui.setResizable(false);
        // orderGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        orderGui.setLayout(new BorderLayout());

        // Title
        JPanel panel1 = new JPanel(new FlowLayout());
        JLabel jl1 = new JLabel("My Order");
        jl1.setFont(new Font("Adobe Gothic Std B", Font.BOLD, 30));
        panel1.add(jl1);
        panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
        orderGui.add(panel1, BorderLayout.NORTH);

        //Empty Order
        JPanel panel0 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ImageIcon icon = new ImageIcon("image/empty-order.jpg");
        JLabel label = new JLabel(icon);
        panel0.add(label);

        //Order
        JPanel panel2 = new JPanel(new FlowLayout());
        JPanel p0 = new JPanel(new FlowLayout());


        vName.add("Product ID");vName.add("Name");vName.add("Unit price (€)");vName.add("Amount");vName.add("Total");

        DefaultTableModel model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.setDataVector(vDate,vName);
        orderTable = new JTable(model);// Create a Table
        windowSetting.setTable(orderTable);

        JScrollPane orderScrollPane = new JScrollPane(orderTable);
        orderScrollPane.setBorder(null);


        panel2.add(p0);
        panel2.add(orderScrollPane);
        panel2.setBorder(new EmptyBorder(10, 10, 40, 10));

        centerPanel.add(panel0,"emptyOrder");
        centerPanel.add(panel2,"Order");
        if( getvDate().isEmpty() ) {
            setOrderCenterPanel(0);
        }else {
            setOrderCenterPanel(1);
        }
        orderGui.add(centerPanel);

        // Copyright
        JPanel panel3 = new JPanel(new FlowLayout());
        JLabel jl3 = new JLabel("Shopping System");
        jl3.setFont(new Font("Adobe Gothic Std B", Font.PLAIN, 15));
        jl3.setHorizontalAlignment(SwingConstants.CENTER);

        panel3.add(jl3);
        orderGui.add(panel3, BorderLayout.SOUTH);

        // Display the window.
        orderGui.setSize(550, 750);
        orderGui.setVisible(false);

        windowSetting.setFrameNear(orderGui);
    }


    public JTable getOrder() {
        return orderTable;
    }

    public void setOrder(JTable order) {
        this.orderTable = order;
    }

    public JFrame getOrderGui() {
        return orderGui;
    }

    public void setOrderGui(JFrame orderGui) {
        this.orderGui = orderGui;
    }


    public Vector<Vector<Object>> getvDate() {
        return vDate;
    }

    public void setvDate(Vector<Vector<Object>> vDate) {
        this.vDate = vDate;
    }

    public void importList(order orderlist) { //Import order into table
        // TODO Auto-generated method stub
        for(product e:orderlist.getList()){
            Vector<Object> v=new Vector<Object>();
            v.add(e.getId());
            v.add(e.getName());
            v.add(e.getPrice());
            v.add(e.getNum());
            double n=e.getPrice()*e.getNum();
            v.add(n);
            vDate.add(v);
        }
        Vector<Object>
        row= new Vector<Object>();row.add(null);row.add(null);row.add(null);row.add("Total:");row.add(orderlist.getTotal());
        vDate.add(row);
        row=new Vector<Object>();row.add(null);row.add(null);row.add(null);row.add("Membership discount:");row.add(orderlist.getDiscount());
        vDate.add(row);
        row=new Vector<Object>();row.add(null);row.add(null);row.add(null);row.add("Point discount:");row.add("-" + orderlist.getDiscountPoint() + " (" + orderlist.getDiscountPoint()*5 + ")");
        vDate.add(row);
        row=new Vector<Object>();row.add(null);row.add(null);row.add(null);row.add("Point reward:");row.add("+" + orderlist.getCurrent_point());
        vDate.add(row);
        row=new Vector<Object>();row.add(null);row.add(null);row.add(null);row.add("Delivery fee:");row.add(orderlist.getDeliverFee());
        vDate.add(row);
        orderTable.updateUI();
    }

    public static void setOrderCenterPanel(int x) {
        if( x == 0 ) {
            orderCard.show(centerPanel,"emptyOrder");
        }else {
            orderCard.show(centerPanel,"Order");
        }
    }
}

