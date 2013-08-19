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
			// 输出方法的返回类型
			System.out.print(m[i].getReturnType().getName());
			// 输出方法名
			method[i]=m[i].getReturnType().getName();
			System.out.print(" " + m[i].getName() + "(");
			// 获取方法的参数
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
			// 输出方法的返回类型
			System.out.print(m[i].getReturnType().getName());
			// 输出方法名
			System.out.print(" " + m[i].getName() + "(");
			// 获取方法的参数
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
