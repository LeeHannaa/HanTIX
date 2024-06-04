import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Slide1 extends JFrame {
    private static final int NUM_COLUMNS = 3;
    private static final int NUM_ROWS = 1;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private Slide2 slide2;

    public Slide1(Concert[] concerts) {
        setTitle("HanTIX");
        setSize(900, 600);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel homePanel = new JPanel(new BorderLayout(20, 20));
        JPanel container = new JPanel(new GridLayout(NUM_ROWS, NUM_COLUMNS, 10, 100));

        JPanel panel1 = createImagePanel(concerts[0]);
        container.add(panel1);
        JPanel panel2 = createImagePanel(concerts[1]);
        container.add(panel2);
        JPanel panel3 = createImagePanel(concerts[2]);
        container.add(panel3);
        JPanel gap1 = new JPanel();
        JPanel gap2 = new JPanel();
        JPanel gap3 = new JPanel();
        homePanel.add(gap1, BorderLayout.EAST);
        homePanel.add(gap2, BorderLayout.WEST);
        homePanel.add(gap3, BorderLayout.SOUTH);
        JLabel title = new JLabel("   HanTIX");
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        homePanel.add(title, BorderLayout.NORTH);
        homePanel.add(container, BorderLayout.CENTER);
        mainPanel.add(homePanel, "Home");

        add(mainPanel);
        setLocationRelativeTo(null);
    }

    private JPanel createImagePanel(Concert concert) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 100, 10));
        panel.setBackground(Color.LIGHT_GRAY);
        ImageIcon imageIcon = new ImageIcon(concert.getImage());
        JLabel imageLabel = new JLabel(imageIcon);
        JLabel name = new JLabel(concert.getName());
        JLabel date = new JLabel(concert.getDate() + '\n' + concert.getTime());
        name.setFont(new Font("Monospaced", Font.PLAIN, 40));
        panel.add(name);
        panel.add(imageLabel);
        panel.add(date);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Stage stage = new Stage();
                stage.init(concert.getFilename());
                showSlide2(concert, stage);
            }
        });

        return panel;
    }

    private void showSlide2(Concert concert, Stage stage) {
        slide2 = new Slide2(concert, this, stage);
        mainPanel.add(slide2, "Detail");
        cardLayout.show(mainPanel, "Detail");
    }

    public void showHome() {
        cardLayout.show(mainPanel, "Home");
    }

    public void showSlide3(ArrayList<String> selectedSeats, Stage stage) {
        Slide3 slide3 = new Slide3(selectedSeats, this, stage);
        mainPanel.add(slide3, "Reservation");
        cardLayout.show(mainPanel, "Reservation");
    }
    public void showSlide4(ArrayList<String> selectedSeats, ArrayList<UserInfo> user, Stage stage) {
        Slide4 slide4 = new Slide4(selectedSeats, this, user, stage);
        mainPanel.add(slide4, "Reservation");
        cardLayout.show(mainPanel, "Reservation");
    }

    

    public void showSlide2() {
        cardLayout.show(mainPanel, "Detail");
    }
}
