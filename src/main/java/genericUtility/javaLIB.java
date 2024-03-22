package genericUtility;

import java.util.Random;

public class javaLIB {

	public int randomNum(int num) {
		Random ran = new Random();
		int randomnum = ran.nextInt(num);
		return randomnum;
	}

}
