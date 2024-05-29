import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//slide 1's gui representation.
public class Slide1 extends JFrame {
    private static final int NUM_COLUMNS = 3;
    private static final int NUM_ROWS = 1; // Adjust as needed
    Stage s; //stage data
    public Slide1(Concert[] c) {
        // Set the title of the window
        setTitle("HanTIX");
        
        // Set the size of the window
        setSize(900, 600);
        
        setBackground(Color.WHITE);
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a container panel with a GridLayout
        JPanel borders = new JPanel(new BorderLayout(20,20));
        JPanel container = new JPanel(new GridLayout(NUM_ROWS, NUM_COLUMNS, 10, 100));
        
        // Add image panels to the container panel


        JPanel panel1 = createImagePanel(c[0]);
        container.add(panel1);
        JPanel panel2 = createImagePanel(c[1]);
        container.add(panel2);
        JPanel panel3 = createImagePanel(c[2]);
        container.add(panel3);
        JPanel gap1 = new JPanel();
        JPanel gap2 = new JPanel();
        JPanel gap3 = new JPanel();
        borders.add(gap1, BorderLayout.EAST);
        borders.add(gap2, BorderLayout.WEST);
        borders.add(gap3, BorderLayout.SOUTH);
        JLabel title = new JLabel("   HanTIX");
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        borders.add(title, BorderLayout.NORTH);
        // Add the container panel to the frame
        borders.add(container, BorderLayout.CENTER);
        add(borders);
        
        
        // Center the window on the screen
        setLocationRelativeTo(null);
    }

    private JPanel createImagePanel(Concert c) {
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1,100,10));
        panel.setBackground(Color.LIGHT_GRAY);
        // Load the image
        ImageIcon imageIcon = new ImageIcon(c.getImage());
        JLabel imageLabel = new JLabel(imageIcon);
        JLabel name = new JLabel(c.getName());
        JLabel date = new JLabel(c.getDate() + '\n' + c.getTime());
        // Add the image label to the panel
        name.setFont(new Font("Monospaced", Font.PLAIN, 40));
        panel.add(name);
        panel.add(imageLabel);
        panel.add(date);
        
        // Add a mouse listener to handle click events
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                s = new Stage(); //creates new stage
                s.init(c.getFilename()); //initalizes it with the csv file url
            }
        });
        
        return panel;
    }
}
