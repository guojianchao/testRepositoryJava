package demo;

import java.util.Random;

public class RandomTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] str = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		StringBuffer buffer = new StringBuffer("");
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			buffer.append(str[r.nextInt(str.length)]);
		}

		System.out.println(buffer.toString());

	}

}
