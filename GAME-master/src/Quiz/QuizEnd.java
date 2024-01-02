package Quiz;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import UpDownGame.UpDownGame;
import gameMenu.GameMenu;

public class QuizEnd extends JFrame{
	public QuizEnd(int misCount) {
		setSize(640, 500);
		setTitle("인물 퀴즈");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		JButton menuButton = new JButton("메인메뉴로");
		JButton reButton = new JButton("다시하기");
		JLabel jl1 = new JLabel(misCount + " 번 틀리셨습니다");
		Font font1 = new Font("돋움", Font.BOLD, 40);
		jl1.setFont(font1);
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel(new GridLayout(2, 1));
		JPanel jp3 = new JPanel(new GridLayout(2, 1));
		jp1.add(jl1);
		jp3.add(reButton);
		jp3.add(menuButton);
		contentPane.add(jp1, BorderLayout.NORTH);
		contentPane.add(jp2, BorderLayout.CENTER);
		contentPane.add(jp3, BorderLayout.SOUTH);
		reButton.addActionListener(e ->{
			 setVisible(false);
			 new quizeMain();
		 });
		menuButton.addActionListener(e ->{
			 setVisible(false);
			 new GameMenu();
		 });
	}
}
