import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Slide3 extends JPanel {
    private JTextField nameField;
    private JTextField studentIdField;
    private JTextField phoneNumberField;
    private ArrayList<String> selectedSeats;

    public Slide3(ArrayList<String> selectedSeats, Slide1 parentFrame) {
        this.selectedSeats = selectedSeats;
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Input Reservation Info");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(150, 50));

        JLabel studentIdLabel = new JLabel("Student ID:");
        studentIdField = new JTextField();
        studentIdField.setPreferredSize(new Dimension(150, 50));

        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField();
        phoneNumberField.setPreferredSize(new Dimension(150, 50));

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(studentIdLabel);
        inputPanel.add(studentIdField);
        inputPanel.add(phoneNumberLabel);
        inputPanel.add(phoneNumberField);

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveInfo());

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> parentFrame.showSlide2());

        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void saveInfo() {
        String name = nameField.getText();
        String studentId = studentIdField.getText();
        String phoneNumber = phoneNumberField.getText();

        UserInfo userInfo = new UserInfo(name, studentId, phoneNumber, selectedSeats);

        JOptionPane.showMessageDialog(this, userInfo.getInfo(), "Reservation Info", JOptionPane.INFORMATION_MESSAGE);
    }
}







// import javax.swing.*;
// import java.awt.*;
// import java.util.List;

// public class Slide3 extends JPanel {
//     private List<String> selectedSeats;

//     public Slide3(Slide1 parentFrame, List<String> selectedSeats) {
//         this.selectedSeats = selectedSeats;
//         setLayout(new BorderLayout());

//         // 상단에 제목 추가
//         JLabel titleLabel = new JLabel("Enter Reservation Information", SwingConstants.CENTER);
//         titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
//         add(titleLabel, BorderLayout.NORTH);

//         // 개인 정보 입력을 위한 폼 생성
//         JPanel formPanel = new JPanel();
//         formPanel.setLayout(new GridLayout(3, 2, 10, 10));
//         formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

//         formPanel.add(new JLabel("Name:"));
//         JTextField nameField = new JTextField();
//         formPanel.add(nameField);

//         formPanel.add(new JLabel("Student ID:"));
//         JTextField studentIdField = new JTextField();
//         formPanel.add(studentIdField);

//         formPanel.add(new JLabel("Phone Number:"));
//         JTextField phoneNumberField = new JTextField();
//         formPanel.add(phoneNumberField);

//         add(formPanel, BorderLayout.CENTER);

//         // 하단 버튼 패널 설정
//         JPanel buttonPanel = new JPanel();
//         buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

//         JButton backButton = new JButton("Cancel");
//         JButton submitButton = new JButton("Submit");

//         backButton.addActionListener(e -> parentFrame.showSlide2());
//         submitButton.addActionListener(e -> {
//             // 제출 버튼 클릭 시 처리 로직 추가
//             String name = nameField.getText();
//             String studentId = studentIdField.getText();
//             String phoneNumber = phoneNumberField.getText();

//             StringBuilder seatsInfo = new StringBuilder();
//             for (String seat : selectedSeats) {
//                 seatsInfo.append(seat).append("\n");
//             }

//             String message = "Information Submitted:\n" +
//                     "Name: " + name + "\n" +
//                     "Student ID: " + studentId + "\n" +
//                     "Phone Number: " + phoneNumber + "\n" +
//                     "Selected Seats:\n" + seatsInfo.toString();

//             JOptionPane.showMessageDialog(parentFrame, message);

//             parentFrame.showHome();
//         });

//         buttonPanel.add(backButton);
//         buttonPanel.add(submitButton);

//         add(buttonPanel, BorderLayout.SOUTH);
//     }

//     public static void main(String[] args) {
//         JFrame frame = new JFrame("Slide3 Test");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setSize(400, 300);
//         frame.add(new Slide3(null, List.of("A1", "A2", "B1"))); // 부모 프레임과 좌석 리스트를 예제로 전달
//         frame.setVisible(true);
//     }
// }