package shopping.mallBackend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class windowSetting {
    public static void setFrameCenter(JFrame frame) {
        int windowWidth = frame.getWidth(); // Get the width of the form
        int windowHeight = frame.getHeight();// Get the height of the form
        Toolkit kit = Toolkit.getDefaultToolkit(); // Define Toolkit
        Dimension screenSize = kit.getScreenSize(); // Get the size of the screen
        int screenWidth = screenSize.width; // Get the width of the screen
        int screenHeight = screenSize.height; // Get the height of the screen
        frame.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2 ) ;// Set the coordinates where the form appears
    }

    public static void setTable (JTable table){
        // Set the header
        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // Set the font style of the header name
        table.getTableHeader().setResizingAllowed(false);               // Setting does not allow manual change of column width
        table.getTableHeader().setReorderingAllowed(false);             // Setting does not allow dragging to reorder the columns
        table.getTableHeader().setBackground(Color.CYAN);

        table.setShowVerticalLines(false); 	//Do not display vertical grid lines

        //Set data center
        DefaultTableCellRenderer r   = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);

        table.setRowHeight(35);		//Set row height
        table.setSelectionBackground(Color.LIGHT_GRAY);     // Font background after selection
        //table.setShowGrid(false);
        table.setPreferredScrollableViewportSize(new Dimension(400, 490));


    }

    public static void setFrameNear(JFrame frame) {
        // TODO Auto-generated method stub
        int windowWidth = frame.getWidth(); // Get the width of the form
        int windowHeight = frame.getHeight();// Get the height of the form
        Toolkit kit = Toolkit.getDefaultToolkit(); // Define Toolkit
        Dimension screenSize = kit.getScreenSize(); // Get the size of the screen
        int screenWidth = screenSize.width; // Get the width of the screen
        int screenHeight = screenSize.height; // Get the height of the screen
        frame.setLocation(screenWidth / 2 + 192, screenHeight / 2 - windowHeight / 2 );// Set the coordinates where the form appears

    }



}

