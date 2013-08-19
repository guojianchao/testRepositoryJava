package fanshe;

import java.lang.reflect.*;

public class SampleMethod {

	public static void main(String[] args) {
		A p = new A();
		printMethods(p);
	}

	public static String[] printMethods(Object o) {
		Class c = o.getClass();
		String method[]=new String[10];
		String className = c.getName();
		Method[] m = c.getMethods();
		for (int i = 0; i < m.length; i++) {
			// ��������ķ�������
			System.out.print(m[i].getReturnType().getName());
			// ���������
			method[i]=m[i].getReturnType().getName();
			System.out.print(" " + m[i].getName() + "(");
			// ��ȡ�����Ĳ���
			Class[] parameterTypes = m[i].getParameterTypes();
			for (int j = 0; j < parameterTypes.length; j++) {
				System.out.print(parameterTypes[j].getName());
				if (parameterTypes.length > j + 1) {
					System.out.print(",");
				}
			}

			System.out.println(")");
		}
		return method;

	}
	public static String[] parameterTypes(Object o) {
		Class[] parameterType=null;
		Class c = o.getClass();
		String parameter[]=new String[20];
		String className = c.getName();
		Method[] m = c.getMethods();
		for (int i = 0; i < m.length; i++) {
			// ��������ķ�������
			System.out.print(m[i].getReturnType().getName());
			// ���������
			System.out.print(" " + m[i].getName() + "(");
			// ��ȡ�����Ĳ���
			Class[] parameterTypes = m[i].getParameterTypes();
			parameterType=parameterTypes;
			for (int j = 0; j < parameterTypes.length; j++) {
				System.out.print(parameterTypes[j].getName());parameter[j]=parameterTypes[j].getName();
				if (parameterTypes.length > j + 1) {
					System.out.print(",");
					}
		}

			System.out.println(")");
		}
		return parameter;

	}

}
