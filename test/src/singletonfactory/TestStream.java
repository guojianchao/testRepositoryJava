package singletonfactory;

public class TestStream {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// ����ֻ����һ��ʵ��
	private TestStream() {
	} // ˽���޲ι��췽��

	// ����������д���
	// ��2�ַ�ʽ
	/* private static final TestStream ts=new TestStream(); */
	private static TestStream ts1 = null;

	// ���������Զ�������ϵͳ�ṩ���ʵ������
	public static TestStream getTest() {
		if (ts1 == null) {
			ts1 = new TestStream();
		}
		return ts1;
	}

	public void getInfo() {
		System.out.println("output message " + name);
	}
}
