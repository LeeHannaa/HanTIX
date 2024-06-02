import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Slide4 extends JPanel {
    private ArrayList<String> selectedSeats;
    private ArrayList<UserInfo> user;
    private int price;

    public Slide4(ArrayList<String> selectedSeats, Slide1 parentFrame, ArrayList<UserInfo> user, Stage stage) {
        this.selectedSeats = selectedSeats;
        this.user = user;
        setLayout(new BorderLayout());
        JPanel coveredJPanel = new JPanel();
        coveredJPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel titleLabel = new JLabel("결제창");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new GridLayout(2, 2, 3, 5));
        JLabel accountLabel = new JLabel("계좌번호: 3333-34-12314-54232");
        accountLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        accountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        int cnt = 0;
        for(String s: selectedSeats){
            cnt++;
        }
        setPrice(cnt);
        JLabel priceLabel = new JLabel(toString());
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        middlePanel.add(accountLabel);
        middlePanel.add(priceLabel);

        JLabel WanrLabel = new JLabel("결제를 완료한 후에는 예약 취소가 불가하오니 주의해 주시기 바랍니다.");
        WanrLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        WanrLabel.setHorizontalAlignment(SwingConstants.CENTER);
        WanrLabel.setForeground(Color.RED);

        coveredJPanel.add(titleLabel);
        coveredJPanel.add(middlePanel);
        coveredJPanel.add(WanrLabel);

        add(coveredJPanel, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> writeFile(stage));
        saveButton.addActionListener(e -> parentFrame.showHome());

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> parentFrame.showSlide2());

        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.SOUTH);
    } 

    public void setPrice(int cnt){
        price = cnt * 5000;
    }
    public String toString(){
        return "결제금액: "+price+"원";
    }

    // private void writeFile(Stage stage) {
    //     System.out.println(stage.getFilename());
    //     String studentid = new String();
    //     String name= new String();
    //     String phone= new String();
    //     String seat = new String();
    //     ArrayList<String> save = new ArrayList<>();
    //     for(UserInfo s : user){
    //         studentid=s.getStudentId();
    //         name=s.getName();
    //         phone=s.getPhoneNumber();
    //         System.out.println(studentid);
    //         System.out.println(name);
    //         System.out.println(phone);
    //     }
        
    //     try{
    //         BufferedReader reader = new BufferedReader(new FileReader(stage.getFilename()));
    //         String line;
            
    //         while ((line = reader.readLine()) != null) {
    //             System.out.println(line);
    //             for(String select: selectedSeats){
    //                 seat = select+","+studentid+","+name+","+phone;
    //                 if(line.substring(0, 2).equals(select)){
    //                     line = seat;
    //                     System.out.println("line is modifyed");
    //                     System.out.println(line);
    //                 }
    //             }
    //             save.add(line);
    //         }
    //         reader.close();
    //     }
    //     catch(IOException e)
    //     {
    //         System.out.println("Can't find open file");
    //     }
    //     for(String select: save){
    //         System.out.println(select);
    //     }
    // }
    private void writeFile(Stage stage) {
        String studentid = "";
        String name = "";
        String phone = "";
        String seat = "";
    
        // 사용자 정보 가져오기
        for (UserInfo s : user) {
            studentid = s.getStudentId();
            name = s.getName();
            phone = s.getPhoneNumber();
        }
    
        File inputFile = new File(stage.getFilename());
        File tempFile = new File("tempFile.csv");
    
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
    
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                boolean seatFound = false;
    
                for (String select : selectedSeats) {
                    seat = select + "," + studentid + "," + name + "," + phone;
                    if (line.startsWith(select)) {
                        line = seat;
                        System.out.println("line is modified");
                        System.out.println(line);
                        seatFound = true;
                        break;
                    }
                }
    
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Can't open file");
        }
    
        // 기존 파일 삭제 및 임시 파일 이름 변경
        if (!inputFile.delete()) {
            System.out.println("Could not delete original file");
        }
    
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename temp file");
        }
    }
    
}