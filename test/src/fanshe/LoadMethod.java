package fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class LoadMethod {
	
	public static void main(String[] args) {
		LoadMethod lm=new LoadMethod();
		SampleMethod.printMethods(new FS());
		String[] a=new String[]{"11111"};  
		lm.Load(A.class.getName(),SampleMethod.printMethods(new FS())[0], SampleMethod.parameterTypes(new FS()), a);
	}
	
	public Object Load(String cName, String MethodName, String[] type,
			String[] param) {
		Object retobj = null;
		try {
			// ����ָ����Java��
			Class cls = Class.forName(cName);

			// ��ȡָ�������ʵ��
			Constructor ct = cls.getConstructor(null);
			Object obj = ct.newInstance(null);

			// ����������������������
			Class partypes[] = this.getMethodClass(type);

			// ��ָ�����л�ȡָ���ķ���
			Method meth = cls.getMethod(MethodName, partypes);

			// ���������Ĳ���ֵ
			Object arglist[] = this.getMethodObject(type, param);

			// ����ָ���ķ�������ȡ����ֵΪObject����
			retobj = meth.invoke(obj, arglist);

		} catch (Throwable e) {
			System.err.println(e);
		}
		return retobj;
	}

	// ��ȡ��������Class[]�ķ���
	public Class[] getMethodClass(String[] type) {
		Class[] cs = new Class[type.length];
		for (int i = 0; i < cs.length; i++) {
			if (!type[i].trim().equals("") || type[i] != null) {
				if (type[i].equals("int") || type[i].equals("Integer")) {
					cs[i] = Integer.TYPE;
				} else if (type[i].equals("float") || type[i].equals("Float")) {
					cs[i] = Float.TYPE;
				} else if (type[i].equals("double") || type[i].equals("Double")) {
					cs[i] = Double.TYPE;
				} else if (type[i].equals("boolean")
						|| type[i].equals("Boolean")) {
					cs[i] = Boolean.TYPE;
				} else {
					cs[i] = String.class;
				}
			}
		}
		return cs;
	}

	// ��ȡ����Object[]�ķ���
	public Object[] getMethodObject(String[] type, String[] param) {
		Object[] obj = new Object[param.length];
		for (int i = 0; i < obj.length; i++) {
			if (!param[i].trim().equals("") || param[i] != null) {
				if (type[i].equals("int") || type[i].equals("Integer")) {
					obj[i] = new Integer(param[i]);
				} else if (type[i].equals("float") || type[i].equals("Float")) {
					obj[i] = new Float(param[i]);
				} else if (type[i].equals("double") || type[i].equals("Double")) {
					obj[i] = new Double(param[i]);
				} else if (type[i].equals("boolean")
						|| type[i].equals("Boolean")) {
					obj[i] = new Boolean(param[i]);
				} else {
					obj[i] = param[i];
				}
			}
		}
		return obj;
	}
}
