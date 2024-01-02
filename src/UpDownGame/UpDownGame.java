package UpDownGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpDownGame extends JFrame{//1개임
	private UpDownEnd end ;
	private ImageIcon icon;
	
	private JLabel mainImage;
	private JTextField field;
	private Random random;
	private int randomNumber;
	private int countNum = 0;
	
	public UpDownGame() {
		setTitle("UpDown 게임");
		Container contentPane = getContentPane();
		setLocationRelativeTo(null);
		setSize(640, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		icon = new ImageIcon(UpDownGame.class.getResource("/UpDownGame/bonobono/unknown.png"));
		mainImage = new JLabel(icon);//-------------------------- 이미지
		
		random = new Random();
		
		setLocationRelativeTo(null);
		JPanel jpL = new JPanel(new GridLayout(2, 1));
		JPanel jpR = new JPanel();
		JPanel jpL1 = new JPanel(null);//왼쪽 위       
		JPanel jpL2 = new JPanel(new FlowLayout(FlowLayout.CENTER));//왼쪽 아래
		
		JLabel jl = new JLabel("");
		JLabel jl2 = new JLabel("1~100 사이의 수를 입력하세요");
		Font font1 = new Font("돋움", Font.BOLD, 40); //40--------------업다운글씨 조정
		Font font2 = new Font("돋움", Font.BOLD, 20);//20----------------숫자를 입력하세요
		contentPane.setLayout(new GridLayout(1, 2));
		
		
		jpL2.setBackground(new Color(124, 197, 242));
		jpL1.setBackground(new Color(124, 197, 242));
		
		
		jpL2.add(jl2);//--------------------------------업다운 출력
		
		jl.setFont(font1);//----글씨 조정 적용
		jl2.setFont(font2);
		
		randomNumber = random.nextInt(100) + 1; // 1~100
		System.err.println(randomNumber);//-----------------------------------랜덤 수 출력
		field = new JTextField(10);//글자수 입력 칸 수
		field.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {//Enter 눌렀을때
				if (e.getKeyCode() == 10) {// 10 == Enter
					countNum++;
					jl.setBounds(185, 165, 200, 100);// ----------------------------글씨 위치
					try {
						int num = Integer.parseInt(field.getText());
						
						if ( num < randomNumber) {
							jl.setText("UP");
						}
						else if( num > randomNumber) {
							jl.setText("DOWN");
						}
						else if( num == randomNumber){
							field.setEnabled(false);
							setVisible(false);
							 new UpDownEnd(countNum);
							System.out.println("r: " + randomNumber);
						}
						
						jpL1.add(jl);
						repaint();
						field.setText("");
					} catch(NumberFormatException e2) {
						jl.setText("NO!!");
						jpL1.add(jl); 
						repaint();
						field.setText("");
						return;
					}
					
				}
			}
		});
		
		jpR.setBackground(new Color(124, 197, 242));//오른쪽 배경
		field.setText("");
		jpL2.add(field); // -------------입력받기
		
		jpR.add(mainImage); // 오른쪽 사진
		jpL.add(jpL1);//왼쪽 위
		jpL.add(jpL2);//왼쪽 아래
		contentPane.add(jpL);
		contentPane.add(jpR);
		setVisible(true);
	}
}
