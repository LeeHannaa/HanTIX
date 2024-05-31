import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Slide2 extends JPanel {
    private JTextArea selectedSeatsArea;
    private int index= 0;

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

                // stage.isAllSeatsOccupied()
                if(seatList.get(index).isOccupied()) {
                    seatButton.setForeground(Color.GRAY);
                    seatButton.setEnabled(false); 
                    // System.out.println("빈자리 아님");
                }
                // else System.out.println("빈자리");

                seatButton.setPreferredSize(new Dimension(50, 50)); // 각 좌석 크기 설정
                seatButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        appendSelectedSeat(seatLabel);
                        seatButton.setForeground(Color.RED);
                    }
                });
                seatPanel.add(seatButton); // 어느 자리인지 저장하는 부분 -> 이거 변경해서 저장받으면 될듯
                index ++;
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
        JButton nextButton = new JButton("Next");

        backButton.addActionListener(e -> parentFrame.showHome());

        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void appendSelectedSeat(String seat) {
        selectedSeatsArea.append(seat + "\n");
    }
}