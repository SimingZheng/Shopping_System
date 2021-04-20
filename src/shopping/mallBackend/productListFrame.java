package shopping.mallBackend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
import shopping.proxydownload.ThirdPartyYouTubeClass;
import shopping.proxydownload.YouTubeCacheProxy;
import shopping.proxydownload.YouTubeDownloader;
import shopping.visitor.bundleDiscountVisitor;
import shopping.visitor.electricProduct;
import shopping.visitor.visitable;
import shopping.visitor.visitor;

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
        names.add("Product Category");
        names.add("Brand");
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
//        JPanel panel3 = new JPanel(new GridLayout(2, 0));
//        JButton jb1 = new JButton("add to shopping cart");
//        jb1.setFont(new java.awt.Font("Times New Roma", 1, 20));

        JPanel panel3 = new JPanel(new GridLayout(2, 0));
        JButton jb1 = new JButton("add to shopping cart");
        jb1.setFont(new java.awt.Font("Times New Roma", 1, 15));

        JButton jb2 = new JButton("download product introduction");
        jb2.setFont(new java.awt.Font("Times New Roma", 1, 12));

        JLabel jl3 = new JLabel("Shopping System");
        jl3.setFont(new Font("Times New Roma", Font.PLAIN, 15)); // Set font
        jl3.setHorizontalAlignment(SwingConstants.CENTER);

        panel3.add(jb2, JPanel.RIGHT_ALIGNMENT);

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

                boolean flag = false;
                boolean bundling = true;
                if (dtm.getValueAt(row, 3).equals("furniture bundling")) {
                    bundleProduct furniture = builder.prepareFurniture();
                    System.out.println("furniture bundling");
                    furniture.showItems();
                    System.out.println("Total Cost: " + furniture.getCost());
                    cost = furniture.getCost();

                    leafFurniture Furniture = new leafFurniture(furniture.getCost(), "Furniture Bundling");
                    operating.addProduct(Furniture);

                    visitable visitable = new electricProduct(furniture.getCost());
                    visitor visitor = new bundleDiscountVisitor();
                    visitable.accept(visitor);

                    visitable Visitable = new electricProduct(furniture.getCost());
                    visitor Visitor = new bundleDiscountVisitor();
                    double bundleCost = Visitable.accept(Visitor);

                    int dialogResult = JOptionPane.showConfirmDialog (null,
                            "The furniture bundling cost " + a*bundleCost + "\nDo you want add in your cart?",
                            "Warning", JOptionPane.YES_NO_CANCEL_OPTION);
                    if(dialogResult == JOptionPane.NO_OPTION || dialogResult == JOptionPane.CANCEL_OPTION){
                        bundling = false;
                    }

                    flag = true;
                }

                if (dtm.getValueAt(row, 3).equals("mobile bundling")) {
                    bundleProduct mobile = builder.prepareElectricalProduct();
                    System.out.println("\n\nmobile bundling");
                    mobile.showItems();
                    System.out.println("Total Cost: " + mobile.getCost());
                    cost = mobile.getCost();

                    leafEletricProduct EletricProduct = new leafEletricProduct(mobile.getCost(),
                            "Electric Product Bundling");
                    operating.addProduct(EletricProduct);

                    visitable Visitable = new electricProduct(mobile.getCost());
                    visitor Visitor = new bundleDiscountVisitor();
                    double bundleCost = Visitable.accept(Visitor);

                    int dialogResult = JOptionPane.showConfirmDialog (null,
                            "The mobile bundling cost " + a*bundleCost + "\nDo you want add in your cart?",
                            "Warning", JOptionPane.YES_NO_CANCEL_OPTION);
                    if(dialogResult == JOptionPane.NO_OPTION || dialogResult == JOptionPane.CANCEL_OPTION){
                        bundling = false;
                    }

                    flag = true;
                }

                if (bundling){
                    if (flag) {
                        operating.printProduct();
                    }

                    cost += (double) dtm.getValueAt(row, 4);

                    Vector<Object> v = new Vector<Object>();
                    v.add(dtm.getValueAt(row, 0));
                    v.add(dtm.getValueAt(row, 1));
                    v.add(dtm.getValueAt(row, 2));
                    v.add(dtm.getValueAt(row, 3));
                    String product = (String) dtm.getValueAt(row, 3);

                    //////////////// get recommendations/////////////////
                    // TODO Auto-generated method stub
                    Process proc;
                    String line = null;
                    try {
                        String[] args1 = new String[] { "python", "src/shopping/mallBackend/Product_Recommend.py", product};
                        proc = Runtime.getRuntime().exec(args1);
//                        proc = Runtime.getRuntime().exec("python src/shopping/mallBackend/Product_Recommend.py juicer");
                        // execute py file
                        // use output stream get result
                        BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                        while ((line = in.readLine()) != null) {
                            System.out.println(line);
                            JOptionPane.showMessageDialog(null, "Recommended product : " + line, "recommendation", JOptionPane.PLAIN_MESSAGE );
                        }
                        in.close();
                        proc.waitFor();
                    } catch (IOException | InterruptedException x) {
                        x.printStackTrace();
                    }
                    //////////////////////////////////////////////////////

                    v.add(cost);
                    v.add(a);
                    double b = (double) dtm.getValueAt(row, 4);
                    double vSum = a * cost;
                    v.add(vSum);
                    dataTransform pro = new dataTransform();

                    shopping.mall.shoppingCart cart = shoppingCart.getShoppingCart();
                    int index = cart.addProduct(pro.productTransform(v));

                    if (index != -1) {// add items in shopping cart
                        DefaultTableModel dd = (DefaultTableModel) shoppingCart.shoppingCartTable.getModel();
                        dd.setValueAt(cart.getProlist().get(index).getNum(), index, 3);
                        double total = cart.getProlist().get(index).getNum() * cart.getProlist().get(index).getPrice();
                        dd.setValueAt(total, index, 4);
                    } else {// add a row of new items
                        shoppingCart.getDate().add(v);
                        shoppingCart.getShoppingCartTable().updateUI();
                        shoppingCart.getJl2().setText("A total of " + shoppingCart.getShoppingCartTable().getRowCount() +
                                " items");
                        shoppingCart.getJl0().setText("Total " + cart.getTotal() + " €");
                    }
                }

                shoppingCartFrame.setShoppingCartCenterPanel(1);
            }
        });

        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass());
                YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());

                long naive = test(naiveDownloader);
                long smart = test(smartDownloader);
                System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");
            }
        });
    }

    private static long test(YouTubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("Introduction to the Chair");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("Introduction to the Towel");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("Introduction to the Chair");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
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
