package GameGuid;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UpDownGame.UpDownGame;
import gameMenu.GameMenu;

public class gameGuid extends JFrame{
	public gameGuid() {
		
		setSize(650, 500);
		setTitle("게임 설명");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		String upDownTitle = "업다운 게임";
		String upDownsGuid = "1에서 100사이의 랜덤한 수를 맞추는 게임 입니다.";
		
		String humanQuizTitle = "인물퀴즈";
		String humanQuizGuid = "연예인 사진을 보고 누구인지 이름을 맞추는 게임 입니다.";
		
		String oMocTitle = "오목";
		String oMocGuid = "같은 색의 돌 5개를 나열하면 이기는 게임 입니다.";
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		Font font1 = new Font("궁서", Font.BOLD, 60);
		Font font2 = new Font("궁서", Font.BOLD, 20);
		
		JLabel upDown1 = new JLabel(upDownTitle);//-----------제목
		JLabel upDown2 = new JLabel(upDownsGuid);
		
		JLabel humanQuiz1 = new JLabel(humanQuizTitle);
		JLabel humanQuiz2 = new JLabel(humanQuizGuid);

		JLabel oMoc1 = new JLabel(oMocTitle);
		JLabel oMoc2 = new JLabel(oMocGuid);
		
		JLabel jl1 = new JLabel("게임 설명");
		JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));//--북쪽 패널
		JPanel jp2 = new JPanel(new GridLayout(6,1));
		JPanel menu = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton menuButton = new JButton("메인 메뉴로");
		
		jl1.setForeground(Color.BLACK);
		
		upDown1.setForeground(Color.RED);
		upDown2.setForeground(Color.RED);
		humanQuiz1.setForeground(Color.ORANGE);
		humanQuiz2.setForeground(Color.ORANGE);
		oMoc1.setForeground(Color.YELLOW);
		oMoc2.setForeground(Color.YELLOW);
		
		menu.setBackground(Color.GRAY);
		jp1.setBackground(Color.GRAY);
		jp2.setBackground(new Color(59, 59, 59));
		contentPane.setBackground(new Color(59, 59, 59));
		
		jl1.setFont(font1);//--------------제목
		
		upDown1.setFont(font2);
		upDown2.setFont(font2);
		humanQuiz1.setFont(font2);
		humanQuiz2.setFont(font2);
		oMoc1.setFont(font2);
		oMoc2.setFont(font2);

		menu.add(jl1);
		menu.add(menuButton);
		jp1.add(menu);//-----------제목넣기
		
		jp2.add(upDown1);
		jp2.add(upDown2);
		jp2.add(humanQuiz1);
		jp2.add(humanQuiz2);
		jp2.add(oMoc1);
		jp2.add(oMoc2);
		
		contentPane.add(jp1, BorderLayout.NORTH);
		contentPane.add(jp2, BorderLayout.CENTER);
		
		
		menuButton.addActionListener(e ->{
			 setVisible(false);
			 new GameMenu();
		 });
		setVisible(true);
	}
}
