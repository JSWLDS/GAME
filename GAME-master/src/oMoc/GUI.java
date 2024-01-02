package oMoc;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class GUI extends JFrame {

    private Container c;
    MapSize size=new MapSize();
    
    public GUI(String title) {
        setTitle(title);
        c=getContentPane();
        
        setSize(650,700);
        setResizable(false);
        setLocationRelativeTo(null);
        JButton jb1 = new JButton("메인 메뉴로"); 
        add(jb1);
        
        c.setLayout(null);
        Map map=new Map(size);
        DrawBoard d= new DrawBoard(size,map);
        setContentPane(d);
        addMouseListener(new Mouse(map,size,d,this));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        }
    public void showPopUp(String message) {
        JOptionPane.showMessageDialog(this, message, " " ,JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}