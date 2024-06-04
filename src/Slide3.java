import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Slide3 extends JPanel {
    private JTextField nameField;
    private JTextField studentIdField;
    private JTextField phoneNumberField;
    private ArrayList<String> selectedSeats;
    private ArrayList<UserInfo> user;

    public Slide3(ArrayList<String> selectedSeats, Slide1 parentFrame, Stage stage) {
        this.selectedSeats = selectedSeats;
        this.user = new ArrayList<>();
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Enter Reservation Info");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel nameLabel = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        inputPanel.add(nameLabel, gbc);

        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(150, 50));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(nameField, gbc);

        JLabel studentIdLabel = new JLabel("Student ID:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(studentIdLabel, gbc);

        studentIdField = new JTextField();
        studentIdField.setPreferredSize(new Dimension(150, 50));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(studentIdField, gbc);

        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(phoneNumberLabel, gbc);

        phoneNumberField = new JTextField();
        phoneNumberField.setPreferredSize(new Dimension(150, 50));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(phoneNumberField, gbc);

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveInfo());
        saveButton.addActionListener(e -> parentFrame.showSlide4(selectedSeats, user, stage));

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> parentFrame.showSlide2());

        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void saveInfo() {
        String name = nameField.getText();
        String studentId = studentIdField.getText();
        String phoneNumber = phoneNumberField.getText();

        UserInfo userInfo = new UserInfo(name, studentId, phoneNumber, selectedSeats);

        user.add(userInfo);

        JOptionPane.showMessageDialog(this, userInfo.getInfo(), "Reservation Info", JOptionPane.INFORMATION_MESSAGE);
    }
}