package demo;

import java.io.*;
import java.util.*;

public class MyProperties extends ArrayList {
	private static final long UID = 1L;

	private String code = "GBK"; // ���ñ��뷽ʽ

	private String fileName; // �ļ�������·���ͺ�׺

	public static void main(String[] args) throws Exception {// java��������ڴ�
		String path = "D:/proper.properties";
		MyProperties proper = new MyProperties(path, "GBK");
		proper.setTitle("������Properties���ü�-ֵ�Ե�ֵ");
		proper.setProperties("studentName", "����");
		proper.setNotes("studentName", "ѧ������"); // �����û�����ע
		proper.setProperties("room", "����һ��");
		proper.setNotes("room", "�����꼶"); // �������뱸ע
		proper.setProperties("score", "98.5");
		proper.setNotes("score", "��ѧ����"); // �����û���ַ��ע
		proper.saveFile();// ������д�������ļ�
		System.out.println(readFile(path, "GBK")); // ��ȡ�����ļ�����
		proper.getValue();// ��ȡ��Ŀ�е������ļ��ļ�ֵ
	}

	public String getFileName() { // ����ļ�����
		return fileName;
	}

	private void setFileName(String fileName) { // �����ļ�����
		this.fileName = fileName;
	}

	// �������Ĺ��췽��
	public MyProperties(String fileName, String code) {
		try {
			this.setFileName(fileName); // �����ļ�
			// ���÷������ñ��뷽ʽ
			this.setCharacterEncoding(code);
			if (!isExist(fileName)) // �ж��ļ��Ƿ����
				this.writeFile("");
			// ���÷�����Ԫ�ط��뼯����
			this.addAll(Arrays.asList(readFile(fileName, code).split("\n")));
		} catch (Exception ex) { // �����쳣
			ex.printStackTrace();
		}
	}

	private void setCharacterEncoding(String code)
			throws UnsupportedEncodingException { // ���ñ��뷽ʽ
		new String("".getBytes("iso8859_1"), code);// ����ת��
		this.code = code;
	}

	public static boolean isExist(String fileName) { // �ж��ļ��Ƿ����
		return new File(fileName).isFile(); // �Ƿ���һ���ļ�
	}

	public static String readFile(String fileName, String code)
			throws IOException { // ��ȡ��Ϣ
		StringBuffer sb = new StringBuffer(); // �����ַ�������
		BufferedReader in = new BufferedReader( // �������������
				new FileReader(fileName));
		String s;
		while ((s = in.readLine()) != null) { // ѭ����ȡ�ļ��е���Ϣ
			sb.append(s); // �ַ���ƴ��
			sb.append("\n"); // ����
		}
		in.close(); // �ͷ���Դ
		return sb.toString(); // ���ض�ȡ���ַ���
	}

	public void writeFile(String proper) throws IOException { // �ַ���д���ļ�
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				fileName))); // �����ı��������ӡ����
		out.print(proper); // ���ַ���д��ָ���ļ�
		out.close(); // �ͷ���Դ
	}

	public void saveFile() throws IOException { // ���ݱ��浽�ļ���
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				fileName))); // �����ı��������ӡ����
		String tmp;
		for (int i = 0; i < size(); i++) { // ѭ����ʾ������Ϣ���������̨
			tmp = get(i) + "";
			out.println(tmp);
		}
		out.close();
	}

	public void setProperties(String key, String val) { // ����Properties��ֵ
		int pro = lookForKey(key);
		if (pro >= 0)
			this.set(pro, key + "=" + val);
		else
			this.add(key + "=" + val);
	}

	public int lookForKey(String key) { // ���Ҽ����
		try {
			String temp;
			for (int i = 0; i < size(); i++) { // ѭ����ʾ������Ϣ
				temp = get(i) + "";
				temp = new String(temp.getBytes("iso8859_1"), code);// ����ת��
				if (temp.indexOf(key) == 0) { // û���ҵ���ֵ
					return i;
				}
			}
		} catch (Exception e) { // �����쳣
		}
		return -1;
	}

	public void setNotes(String key, String memo) { // ���ӱ�ע
		if ("".equals(key)) {
			this.add("#" + memo);
			return;
		}
		String temp;
		int result = lookForKey(key);
		if (result == -1) { // ���û���ҵ�
			this.add("#" + memo);
			this.add(key + "=");
		} else {
			int position = result - 1;
			if (position < 0) {
				this.add(position, "#" + memo);
			} else {
				temp = this.get(position) + " ";
				if ("#".equals(temp.substring(0, 1))) // �жϽ�ȡֵ�Ƿ���#��ͬ
					this.set(position, "#" + memo);
				else {
					this.add(position + 1, "#" + memo);
				}
			}
		}
	}

	public void setTitle(String title) { // ����ע������
		String tmp = this.get(0) + "";
		if (tmp == null || tmp.length() == 0)
			tmp = "";
		else
			tmp = tmp.substring(0, 1); // ��ȡ��һ��Ԫ��
		if ("#".equals(tmp)) // �жϵ�һ��Ԫ���Ƿ���#
			this.set(0, "#" + title); // ����ע������
		else {
			this.add(0, "");
			this.add(0, "#" + title);
		}
	}

	public String getProperties(String key) { // ��ȡ����Ӧ��ֵ
		return getProperties(key, "");
	}

	public String getProperties(String key, String defaultStr) {
		String temp, result;
		try {
			for (int i = 0; i < size(); i++) { // ѭ����ʾ������Ϣ
				temp = get(i) + ""; // ���Ԫ��
				temp = new String(temp.getBytes("iso8859_1"), code);// ����ת��
				if (temp.indexOf(key) == 0) { // �ҵ�ָ���ļ�
					result = temp.substring(key.length() + 1);// ��ȡ��ü���Ӧ��ֵ
					return result;
				}
			}
		} catch (Exception e) { // �����쳣
		}
		return defaultStr;
	}

	public void getValue() {// �����Ŀ�е�properties�ĸ��ݼ�ȡ����Ӧ��ֵ
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					"proper.properties")); // ��������������
			Properties p = new Properties(); // �������Զ���
			p.load(in); // ��������������
			String s = (String) p.get("studentName"); // ��ü�ֵ
			if(s!=null){
				// ����ת��
				String name = new String(s.getBytes("iso8859_1"), "GBK");
				System.out.println("���studentName��ֵ��" + name);

				String a = (String) p.get("room");
				String room = new String(a.getBytes("iso8859_1"), "GBK");
				System.out.println("���room��ֵ��" + room);
			}
			
		} catch (IOException e) { // �����쳣
			e.printStackTrace();
		}
	}

}
