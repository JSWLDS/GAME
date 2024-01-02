package UpDownGame;

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

import gameMenu.GameMenu;

public class UpDownEnd extends JFrame{
	private ImageIcon icon;
	
	private JLabel mainImage;
	UpDownEnd(int countNum){
			

			setTitle("UpDown 게임");
			Container contentPane = getContentPane();
			contentPane.setLayout(new GridLayout(1, 2));
			setSize(640, 500);
			setLocationRelativeTo(null);
			setVisible(true);
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			icon = new ImageIcon(UpDownEnd.class.getResource("/UpDownGame/bonobono/unknown.png"));
			mainImage = new JLabel(icon);//-------------------------- 이미지
			
			JPanel jpL1 = new JPanel(new BorderLayout());
			JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			
			JPanel jpR1 = new JPanel();
			JPanel jpL21 = new JPanel(new GridLayout(2, 1));
			JLabel jl = new JLabel(countNum + "번 만에 성공!");
			JButton menuButton = new JButton("메인메뉴로");
			JButton reButton = new JButton("다시하기");
			Font font = new Font("돋움", Font.BOLD, 40);//-------------------크기 40 글씨조정
			
			jl.setFont(font);
			menuButton.setFont(font);
			reButton.setFont(font);
			
			jl.setHorizontalAlignment(JLabel.RIGHT);
			jpL1.add(jl, BorderLayout.CENTER);
			
			jpL21.add(reButton);
			jpL21.add(menuButton);
			
			jpL1.add(jpL21, BorderLayout.SOUTH);
			jpL1.setBackground(new Color(124, 197, 242));
			jpR1.setBackground(new Color(124, 197, 242));
			jpR1.add(mainImage);
			contentPane.add(jpL1);
			contentPane.add(jpR1);
			
			reButton.addActionListener(e ->{
				 setVisible(false);
				 new UpDownGame();
			 });
			menuButton.addActionListener(e ->{
				 setVisible(false);
				 new GameMenu();
			 });
			 }
	}
	
