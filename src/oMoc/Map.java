package oMoc;

public class Map {
	private short[][] map; 
	private final short white = 1;
	private final short black = 1;
	private boolean checkBNW = true; // 흑백 확인
	
	public Map(MapSize ms) {
		map = new short[ms.getSize()][];
		for(int i =0; i<map.length; i++) {
			map[i] = new short[ms.getSize()];
		}
	}
	public short getBlack() {
		return black;
	}
	public short getWhite() {
		return white;
	}
	public short getXY(int x, int y) {
		return map[y][x];
	}
	public boolean getCheck() {
		return checkBNW;
	}
	public void changeCheck() {
		if (checkBNW) {
			checkBNW = false;
		}else {
			checkBNW = true;
		}
	}
	public boolean isCheckBNW() {
		return checkBNW;
	}
	public void setMap(int x, int y) {
		if(checkBNW) {
			map[x][y] = black;
		}else {
			map[x][y] = white; //check BNW를 확인해 true일 때 map 에 black이 false 일 때 white 저장
		}
	}
	// 승리확인
	public boolean whinCheck(int x, int y) {
		if(winCheckL(x,y) || winCheckLD(x,y) || winCheckLU(x,y) || winCheckR(x,y)
			|| winCheckRD(x,y) || winCheckRU(x,y) || winCheckUp(x,y) || winCheckDown(x,y)
			|| winCheckOneDown(x,y) || winCheckOneL(x,y) || winCheckOneLD(x,y) || winCheckOneLU(x,y)
			|| winCheckOneR(x,y) || winCheckOneRD(x,y) || winCheckOneRU(x,y) || winCheckOneUp(x,y)
			|| winCheckCenterLU(x,y) || winCheckCenterRL(x,y) || winCheckCenterRU(x,y) || winCheckCenterUD(x,y)) {
			return true;
		}else {
			return false;
		}
	}
	//위쪽
	public boolean winCheckUp(int x,int y) {
		try {
			for(int i =y; i<y+5; i++) {
				if(map[x][y] != map[i][x])
					return false;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
			return true;
	}
	//아래쪽
	public boolean winCheckDown(int x,int y) {
		try {
			for(int i =y; i>y-5; i--) {
				if(map[x][y] != map[i][x])
					return false;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
			return true;
	}
	//오른쪽 위
	public boolean winCheckRU(int x,int y) {
		try {
			for(int i =y, z = x; i>y-5; i--, z++) {
				if(map[x][y] != map[i][z])
					return false;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
			return true;
	}
	//왼쪽 위
	public boolean winCheckLU(int x,int y) {
		try {
			for(int i =y , z = x; i>y-5; i-- , z--) {
				if(map[x][y] != map[i][z])
					return false;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
			return true;
	}
	//오른쪽
	public boolean winCheckR(int x,int y) {
		try {
			for(int z = x; z<x+5; z++) {
				if(map[x][y] != map[z][y])
					return false;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
			return true;
	}
	//오른쪽 아래
	public boolean winCheckRD(int x,int y) {
		try {
			for(int i = y, z=x; i<y+5; i++,z++) {
				if(map[x][y] != map[z][y])
					return false;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
			return true;
	}
	//왼쪽
	public boolean winCheckL(int x,int y) {
		try {
			for(int i = y, z = x; z>x-5; z--) {
				if(map[x][y] != map[z][i] || i > 19 || z > 19 || i<0 || z<0)
					return false;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
			return true;
	}
	//왼쪽 아래
	public boolean winCheckLD(int x,int y) {
		try {
			for(int i = y , z = x; i<y+5; i++, z--) {
				if(map[x][y] != map[z][i])
					return false;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
			return true;
	}
	//한칸 위
	public boolean winCheckOneUp(int x, int y) {
		try{
			for(int i = y -1; i<y+4; i++) {
				if(map[x][y] != map[x][i])
					return false;
			}
	}catch(ArrayIndexOutOfBoundsException e){
	}
		return true;
	}

	//한칸 아래
	public boolean winCheckOneDown(int x, int y) {
		try{
			for(int i = y +1; i>y-4; i--) {
				if(map[x][y] != map[x][i])
					return false;
			}
	}catch(ArrayIndexOutOfBoundsException e){
	}
		return true;
	}
	//한칸오른쪽 위 대각선
	public boolean winCheckOneRU(int x, int y) {
		try{
			for(int i = y +1; i>y-4; i--) {
				if(map[x][y] != map[x][i])
					return false;
			}
	}catch(ArrayIndexOutOfBoundsException e){
	}
		return true;
	}
	//한칸 왼쪽 위 대각산
	public boolean winCheckOneLU(int x, int y) {
		try{
			for(int i = y +1 , z = x +1; i>y-4; i-- , z--) {
				if(map[x][y] != map[z][i])
					return false;
			}
	}catch(ArrayIndexOutOfBoundsException e){
	}
		return true;
	}
	//한칸 오른쪽
	public boolean winCheckOneR(int x, int y) {
		try{
			for(int z = x -1; z<x+4; z++) {
				if(map[x][y] != map[z][y])
					return false;
			}
	}catch(ArrayIndexOutOfBoundsException e){
	}
		return true;
	}
	//한칸 왼쪽
	public boolean winCheckOneL(int x, int y) {
		try{
			for(int z = x +1; z>x-4; z--) {
				if(map[x][y] != map[z][y])
					return false;
			}
	}catch(ArrayIndexOutOfBoundsException e){
	}
		return true;
	}
	//한칸 오른쪽 아래 대각선
	public boolean winCheckOneRD(int x, int y) {
		try{
			for(int i = y -1, z = x -1; i<y+4; i++, z++) {
				if(map[x][y] != map[z][i] || i>19|| z>19 || i<0 || z<0)
					return false;
			}
	}catch(ArrayIndexOutOfBoundsException e){
	}
		return true;
	}
	//한칸 왼쪽 아래 대각선
	public boolean winCheckOneLD(int x, int y) {
		try{
			for(int i = y -1 , z = x; i<y+4; i++, z--) {
				if(map[x][y] != map[z][i])
					return false;
			}
	}catch(ArrayIndexOutOfBoundsException e){
	}
		return true;
	}
	//가운데 위 아래
	public boolean winCheckCenterUD(int x, int y) {
		try{
			for(int i = y -2; i<y+3; i++) {
				if(map[x][y] != map[x][i])
					return false;
			}
	}catch(ArrayIndexOutOfBoundsException e){
	}
		return true;
	}
	//가운데 왼쪽 오른쪽
	public boolean winCheckCenterRL(int x, int y) {
		try{
			for(int z = x -2; z<x+3; z++) {
				if(map[x][y] != map[z][y])
					return false;
			}
	}catch(ArrayIndexOutOfBoundsException e){
	}
		return true;
	}
	//가운데 오른쪽 대각선
	public boolean winCheckCenterRU(int x, int y) {
		try{
			for(int i = y +2,z = x -2; i>y-3; z++) {
				if(map[x][y] != map[z][i])
					return false;
			}
	}catch(ArrayIndexOutOfBoundsException e){
	}
		return true;
	}
	//가운데 왼쪽 대각선
	public boolean winCheckCenterLU(int x, int y) {
		try{
			for(int i = y +2,z = x +2; i>y-4; i--,z--) {
				if(map[x][y] != map[z][i])
					return false;
			}
	}catch(ArrayIndexOutOfBoundsException e){
	}
		return true;
	}
}