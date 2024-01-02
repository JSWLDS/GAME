package Quiz;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame{
	
	private ImageIcon [] icon;
	private JLabel []  human;
	private String [] name;
	private int [] count = new int[6];
	private int countNum = 0;
	private int misCount = 0;
	rand rand = new rand();
	public GUI() {
		setSize(640, 500);
		setTitle("인물 퀴즈");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		Container contentPane = getContentPane();
		
		contentPane.setLayout(new GridLayout(1, 2));
		ImageIcon icon3 = new ImageIcon("src/Quiz/Picture/unknown3.png");
		JLabel p3 = new JLabel(icon3);
		
		icon = new ImageIcon[6]; 
		human  = new JLabel[6];
		name = new String[] {"손흥민", "싸이", "김종국", "손석구", "카리나", "설인아"};
		count = rand.getRandNumber();
		
		icon[0] = new ImageIcon("src/Quiz/Picture/p1.png");
		icon[1] = new ImageIcon("src/Quiz/Picture/p2.png");
		icon[2] = new ImageIcon("src/Quiz/Picture/p3.png");
		icon[3] = new ImageIcon("src/Quiz/Picture/p4.png");
		icon[4] = new ImageIcon("src/Quiz/Picture/p5.png");
		icon[5] = new ImageIcon("src/Quiz/Picture/p6.png");
		
		human[0] = new JLabel(icon[0]);
		human[1] = new JLabel(icon[1]);
		human[2] = new JLabel(icon[2]);
		human[3] = new JLabel(icon[3]);
		human[4] = new JLabel(icon[4]);
		human[5] = new JLabel(icon[5]);
		
		JPanel jpL = new JPanel(new GridLayout(2,1));
		
		Font font1 = new Font("돋움", Font.BOLD, 65);
		JTextField field = new JTextField(10);
		field.setHorizontalAlignment(JTextField.CENTER);//----------------------------------------------------가운데 정렬
		
		field.setForeground(new Color(55, 130, 198));//-------------------글씨색
		
		field.setFont(font1);
		jpL.add(field);
		
		jpL.add(human[count[countNum]]);
		
		
		jpL.setBackground(Color.BLACK);
		
		
		contentPane.add(jpL);
		contentPane.add(p3);
		field.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					if(name[count[countNum]].equals(field.getText())) {
						
						field.setText("");
						countNum++;
							
						if(countNum>=6) {//------------------------다 맞추면 엔딩 화면
							setVisible(false);
							new QuizEnd(misCount);
							return;
						}
						jpL.remove(1);
						jpL.add(human[count[countNum]], 1);
						setVisible(false);
						setVisible(true);
					}
					else {
						field.setText("");
						misCount++;
					}
				}
			}
		});
	
	}
		
}
	
