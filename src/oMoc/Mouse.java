package oMoc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gameMenu.GameMenu;

public class Mouse extends MouseAdapter {
    private Map map;
    private MapSize ms;
    private DrawBoard d;
    private GUI main;

    public Mouse(Map map, MapSize ms, DrawBoard d, GUI main) {
        this.map = map;
        this.ms = ms;
        this.d = d;
        this.main = main;
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        super.mousePressed(arg0);
        // 누른 x,y 좌표를 Cell(30)으로 나눠 나온 값에 1,2를 빼 0~19사이로 맞추기
        int x = (int) Math.round(arg0.getX() / (double) ms.getCell()) - 1;
        int y = (int) Math.round(arg0.getY() / (double) ms.getCell()) - 2;
        if (x < 0 || x > 19 || y < 0 || y > 19) {
            return;
        }
        if (map.getXY(x, y) == map.getBlack() || map.getXY(x, y) == map.getWhite()) {// 이미 놓여있음 리턴
            return;
        }
        System.out.println(x + " " + y);// 누른 좌표값 확인
        map.setMap(x, y);// 입력된 좌표를 배열에 표시
        map.changeCheck();// 차례 바꾸기
        d.repaint();// 맵 다시그리기

		
		  if(map.getCheck()) { 
				
				 new GameMenu();
			  main.setVisible(false);
		  }
		 
        
    }
}