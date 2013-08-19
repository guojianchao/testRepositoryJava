package fanshe;

import java.io.*;
import java.lang.reflect.*;

public class SampleInterface {
	public static void main(String[] args) throws Exception {
		A raf = new A();
		printInterfaceNames(raf);
	}

	public static void printInterfaceNames(Object o) {
		Class c = o.getClass();
		// ��ȡ������Ľӿ�
		Class[] theInterfaces = c.getInterfaces();
		for (int i = 0; i < theInterfaces.length; i++)
			System.out.println(theInterfaces[i].getName());
		// ��ȡ������ĸ��ࣨ���ࣩ
		Class theSuperclass = c.getSuperclass();
		System.out.println(theSuperclass.getName());
	}
}
