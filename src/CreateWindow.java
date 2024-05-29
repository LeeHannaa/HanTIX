import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CreateWindow extends JFrame {

    public CreateWindow() {
        // Set the title of the window
        setTitle("HanTIX");

        // Set the size of the window
        setSize(800, 600);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the window on the screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Use the event dispatch thread to create and show the GUI
        SwingUtilities.invokeLater(() -> {
            CreateWindow window = new CreateWindow();
            window.setVisible(true);

            // Add image panels to the existing window
            ImagePanelManager manager = new ImagePanelManager(window);
            manager.addImagePanels();
        });
    }
}
