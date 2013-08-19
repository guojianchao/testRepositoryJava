package fanshe;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.reflect.*;

class A extends Object implements ActionListener {
	private int a = 3;
	public Integer b = new Integer(4);

	public A() {
	}

	public A(int id, String name) {
	}

	public int abc(int id, String name) {
		return 0;
	}

	public void actionPerformed(ActionEvent e) {
	}
}

public class FS {
	public static void main(String args[]) {
		A r = new A();
		Class temp = r.getClass();
		try {
			System.out.println("反射类中所有公有的属性");
			Field[] fb = temp.getFields();
			for (int j = 0; j < fb.length; j++) {
				Class cl = fb[j].getType();
				System.out.println("fb:" + cl);
			}

			System.out.println("反射类中所有的属性");
			Field[] fa = temp.getDeclaredFields();
			for (int j = 0; j < fa.length; j++) {
				Class cl = fa[j].getType();
				System.out.println("fa:" + cl);
			}
			System.out.println("反射类中私有属性的值");
			Field f = temp.getDeclaredField("a");
			f.setAccessible(true);
			Integer i = (Integer) f.get(r);
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
