import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Slide2 extends JPanel {
    private JTextArea selectedSeatsArea;
    private int index = 0;
    private JButton nextButton;
    private ArrayList<String> selectedSeats = new ArrayList<>();

    public Slide2(Concert concert, Slide1 parentFrame, Stage stage) {
        setLayout(new BorderLayout());

        // Seat list 불러오기
        ArrayList<Seat> seatList = stage.getterSeatList();

        // 콘서트 세부 정보 표시
        JLabel nameLabel = new JLabel(concert.getName());
        JLabel dateLabel = new JLabel(concert.getDate() + " " + concert.getTime());

        nameLabel.setFont(new Font("Monospaced", Font.PLAIN, 40));
        dateLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(2, 1));
        textPanel.add(nameLabel);
        textPanel.add(dateLabel);

        add(textPanel, BorderLayout.NORTH);

        // 좌석표 패널 추가
        JPanel seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(6, 5, 5, 5)); // 6행 5열의 그리드 레이아웃, 좌석 간 간격 5px

        // 좌석 선택 시 이벤트 처리
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                String seatLabel = "R" + (row + 1) + "C" + (col + 1);
                JButton seatButton = new JButton(seatLabel);

                if (seatList.get(index).isOccupied()) {
                    seatButton.setForeground(Color.GRAY);
                    seatButton.setEnabled(false);
                }

                seatButton.setPreferredSize(new Dimension(50, 50)); // 각 좌석 크기 설정
                seatButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (selectedSeats.contains(seatLabel)) {
                            removeSelectedSeat(seatLabel);
                            seatButton.setForeground(Color.BLACK);
                        } else {
                            appendSelectedSeat(seatLabel);
                            seatButton.setForeground(Color.RED);
                        }
                        nextButton.setEnabled(!selectedSeats.isEmpty());
                    }
                });
                seatPanel.add(seatButton);
                index++;
            }
        }

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(seatPanel, BorderLayout.CENTER);

        // 선택한 좌석 패널 추가
        JPanel selectedSeatsPanel = new JPanel();
        selectedSeatsPanel.setLayout(new BorderLayout());
        JLabel selectedSeatsLabel = new JLabel("Selected Seat List");
        selectedSeatsPanel.add(selectedSeatsLabel, BorderLayout.NORTH);

        selectedSeatsArea = new JTextArea(15, 20);
        selectedSeatsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(selectedSeatsArea);
        selectedSeatsPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(selectedSeatsPanel, BorderLayout.EAST);

        add(mainPanel, BorderLayout.CENTER);

        // 하단 버튼 패널 설정
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton backButton = new JButton("Cancel");
        nextButton = new JButton("Next");
        nextButton.setEnabled(false);

        backButton.addActionListener(e -> parentFrame.showHome());
        nextButton.addActionListener(e -> parentFrame.showSlide3(selectedSeats));

        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void appendSelectedSeat(String seat) {
        selectedSeats.add(seat);
        selectedSeatsArea.append(seat + "\n");
    }

    private void removeSelectedSeat(String seat) {
        selectedSeats.remove(seat);
        selectedSeatsArea.setText("");
        for (String s : selectedSeats) {
            selectedSeatsArea.append(s + "\n");
        }
    }
}