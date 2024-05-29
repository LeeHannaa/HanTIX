import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame {
	
	JPanel main_panel; // 버튼을 붙여질 메인 패널 선언

	JButton bt_img;
	
	ImageIcon img = new ImageIcon("../images/pubao.png");
	ImageIcon img2 = new ImageIcon("./src/pubao.jpg");
	
	public Test() {
		setTitle("JButton 이미지넣기 예제"); // 프레임 타이틀바 텍스트 지정
		setSize(500,200); // 프레임 크기 조정(픽셀)
		// 프레임바 우측상단에 X버튼에 대한 강제종료 기능 지정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		main_panel = new JPanel(); // 패널 객체화 / 기본배치관리자 FlowLayout
		main_panel.setBackground(Color.WHITE); // 패널 배경색 하얀색으로 설정
		
		bt_img = new JButton(img);
		bt_img.setRolloverIcon(img2); // 버튼에 마우스가 올라갈떄 이미지 변환
		bt_img.setBorderPainted(false); // 버튼 테두리 설정해제
		bt_img.setPreferredSize(new Dimension(300, 50)); // 버튼 크기 지정
		
		main_panel.add(bt_img); // 패널에 버튼을 붙여준다
		
		add(main_panel); // 메인 프레임에 메인패널을 붙여주는 작업
		
		setVisible(true); // 프레임 보이게 하기
	}
	
	public static void main(String[] args) {
		new Test();
		String workingDir = System.getProperty("user.dir");
		System.out.println("Current working directory : " + workingDir);
	}
}
