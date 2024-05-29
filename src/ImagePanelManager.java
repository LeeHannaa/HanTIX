import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;

public class ImagePanelManager {
    private static final int NUM_COLUMNS = 3;
    private static final int NUM_ROWS = 3; // Adjust as needed
    private static final String[] IMAGE_PATHS = {
            "./image/mic.png",
            "./image/mic.png",
            "./image/mic.png",
            "./image/mic.png",
            "./image/mic.png",
            "./image/mic.png",
            "./image/mic.png",
            "path/to/image8.jpg",
            "path/to/image9.jpg"
    };

    private JFrame frame;

    public ImagePanelManager(JFrame frame) {
        this.frame = frame;
    }

    public void addImagePanels() {
        // Create a container panel with a GridLayout
        JPanel container = new JPanel(new GridLayout(NUM_ROWS, NUM_COLUMNS, 10, 10));

        // Add image panels to the container panel
        for (String imagePath : IMAGE_PATHS) {
            JPanel panel = createImagePanel(imagePath);
            container.add(panel);
        }

        // Add the container panel to the frame
        frame.add(container, BorderLayout.CENTER);

        // Refresh the frame to display the new content
        frame.revalidate();
        frame.repaint();
    }

    private JPanel createImagePanel(String imagePath) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Load the image
        ImageIcon imageIcon = loadImageIcon(imagePath);
        if (imageIcon != null) {
            // Resize the image to fit the panel
            Image image = imageIcon.getImage();
            Image resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Adjust size as needed
            imageIcon = new ImageIcon(resizedImage);
        } else {
            // If image fails to load, show a placeholder or error message
            imageIcon = new ImageIcon(new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB));
            System.err.println("Failed to load image: " + imagePath);
        }

        JLabel imageLabel = new JLabel(imageIcon);

        // Add the image label to the panel
        panel.add(imageLabel, BorderLayout.CENTER);

        // Add a mouse listener to handle click events
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Image clicked: " + imagePath);
                JOptionPane.showMessageDialog(panel, "Image clicked: " + imagePath);
            }
        });

        return panel;
    }

    private ImageIcon loadImageIcon(String path) {
        // Try to load image from the given path
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            // If path is not found in resources, try to load from file system
            return new ImageIcon(path);
        }
    }
}
