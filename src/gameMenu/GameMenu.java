package gameMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameGuid.gameGuid;
import Quiz.quizeMain;
import UpDownGame.UpDownGame;
import oMoc.GameMain;

public class GameMenu extends JFrame{
	
	private JLabel lb1;

	public GameMenu() {
		super("Main Menu");
		setLayout(new BorderLayout(0, 50));
		setSize(640, 500);    // 프레임 크기 설정
		setLocationRelativeTo(null);  // 프레임을 화면 가운데에 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫았을 때 메모리에서 제거되도록 설정
		setResizable(false);
		lb1 = new JLabel("종합 게임");
		
		Font font1 = new Font("궁서", Font.BOLD, 60);
		Font font2 = new Font("MD이솝체", Font.BOLD, 40);
		
		lb1.setFont(font1);
		Container contentPane = getContentPane();
		//--------전체적 화면구성
		JPanel jp4 = new JPanel(new BorderLayout(20, 20));// 스위치 화면 안
		JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel jp2 = new JPanel(new GridLayout(5,1));
        JPanel jp3 = new JPanel();
        JPanel mainJp = new JPanel(new BorderLayout());
       //------------------세부 화면 조정 
        JPanel jp11 = new JPanel();
        JPanel jp12 = new JPanel();
        JPanel jp13 = new JPanel();
        JPanel jp14 = new JPanel();
        JPanel jp15 = new JPanel();
        
        jp11.setBackground(Color.BLACK);
        jp12.setBackground(Color.BLACK);
        jp13.setBackground(Color.BLACK);
        jp14.setBackground(Color.BLACK);
        jp15.setBackground(Color.GRAY);
        //------------------------------
        
        JButton btnGuid = new JButton("게임설명");//  버튼, 패널 생성
        JButton btnUpDown = new JButton("UP & DOWN");
        JButton btnHumanQuiz = new JButton("인물 퀴즈");
        JButton btnOMoc = new JButton("오목");
        
        ImageIcon icon1 = new ImageIcon("src/gameMenu/nintendo/swL.png");
        ImageIcon icon2 = new ImageIcon("src/gameMenu/nintendo/swR.png");
        
        JLabel image1 = new JLabel(icon1);
        JLabel image2 = new JLabel(icon2);
        //----------------------------------------------색깔조정
        contentPane.setBackground(Color.GRAY);
        jp1.setBackground(Color.GRAY);
        jp2.setBackground(Color.BLACK);
        jp3.setBackground(Color.GRAY);
      //------안에 화면 패널
        jp4.add(jp2, BorderLayout.CENTER);
        jp4.add(jp11, BorderLayout.EAST);
        jp4.add(jp12, BorderLayout.WEST);
        jp4.add(jp13, BorderLayout.NORTH);
        jp4.add(jp14, BorderLayout.SOUTH);
        //---------------------------------------------스위치 안에 화면 넣기
        add(mainJp, BorderLayout.CENTER);
        mainJp.add(jp1, BorderLayout.NORTH);
        
        jp4.setBackground(Color.BLACK);
        
        mainJp.add(jp4, BorderLayout.CENTER);
        
        add(image1, BorderLayout.WEST);
        
        add(image2, BorderLayout.EAST);
        
        add(jp3, BorderLayout.SOUTH);//밑
        
        jp1.add(lb1);
        add(jp1, BorderLayout.NORTH);
        
        btnGuid.setFont(font2);
        btnUpDown.setFont(font2);
        btnHumanQuiz.setFont(font2);
        btnOMoc.setFont(font2);
        
        jp2.add(btnUpDown);//---------------------------버튼
        jp2.add(btnHumanQuiz);
        jp2.add(btnOMoc);
        jp2.add(btnGuid);
        jp2.add(jp15);
        setVisible(true);  //   프레임이 보이도록 설정 
        
        btnUpDown.addActionListener(e ->{
			 setVisible(false);
			 new UpDownGame();
		 });
        btnHumanQuiz.addActionListener(e ->{
			 setVisible(false);
			 new quizeMain();
		 });
        btnOMoc.addActionListener(e ->{
			 setVisible(false);
			 new GameMain();
		 });
        btnGuid.addActionListener(e ->{
			 setVisible(false);
			 new gameGuid();
		 });
	}       
}
