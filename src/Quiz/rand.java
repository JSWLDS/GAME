package Quiz;

import java.util.Random;

public class rand {
	private int count [] = new int [6];
	public rand() {
		Random rand = new Random();
			for(int i=0; i<6; i++) {
				count[i] = rand.nextInt(6);
			}
			for(int i=0; i<6; i++) {
				for(int j=0; j<i+1; j++) {
					if(i==j) {
						continue;
					}
					else if(count[i]==count[j]) {
					count[i] = rand.nextInt(6);
					i--;
					}
				}
			}
	}
	public int [] getRandNumber() {
		return count;
	}
}
