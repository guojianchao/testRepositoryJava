package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

//������
public class Exec {
	public static void main(String[] args) {
		// �������������
		DemoWindow dw = new DemoWindow("��ȡWord�ļ�");

		// ������Ŀ�Ⱥ͸߶ȷֱ�����Ϊ��Ļ��Ⱥ���Ļ�߶ȵ�1/3�����Ͻ�λ��Ҳ����Ϊ��Ļ��Ⱥ���Ļ�߶ȵ�1/3��
		Toolkit theKit = dw.getToolkit();
		Dimension wndSize = theKit.getScreenSize();
		dw.setBounds(wndSize.width / 3, wndSize.height / 3, wndSize.width / 3,
				wndSize.height / 3);

		// ����رհ�ť�����˳�����
		dw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ���ô���Ϊ�ɼ�
		dw.setVisible(true);
	}
}

// ���洰��
class DemoWindow extends JFrame implements AdjustmentListener// ע��˴�
{
	// �����ɫ��ֵ
	int color1 = 0;

	// �̵���ɫ��ֵ
	int color2 = 0;

	// ������ɫ��ֵ
	int color3 = 0;

	// ������ɫ�Ĺ�����
	JScrollBar s1 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 1, 0, 256);

	// ������ɫ�Ĺ�����
	JScrollBar s2 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 1, 0, 256);

	// ������ɫ�Ĺ�����
	JScrollBar s3 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 1, 0, 256);

	// �������
	JPanel jp = new JPanel();

	// ��ʾ��ɫ�����
	JPanel colorPanel = new JPanel();

	// ���캯��
	public DemoWindow(String title) {
		// ���岼��
		jp.setLayout(new GridLayout(3, 1));
		jp.add(s1);
		jp.add(s2);
		jp.add(s3);
		add(jp, BorderLayout.NORTH);
		add(colorPanel, BorderLayout.CENTER);

		// ����Ĭ�ϵı���ɫ
		colorPanel.setBackground(new Color(color1, color2, color3));

		// ����¼�������
		s1.addAdjustmentListener(this);
		s2.addAdjustmentListener(this);
		s3.addAdjustmentListener(this);
	}

	// ��Ӧ����������
	public void adjustmentValueChanged(AdjustmentEvent e) {
		// ���������ɫ
		if (e.getAdjustable() == s1)
			color1 = s1.getValue();

		// ���������ɫ
		if (e.getAdjustable() == s2)
			color2 = s2.getValue();

		// ���������ɫ
		if (e.getAdjustable() == s3)
			color3 = s3.getValue();

		// �����µı���ɫ
		colorPanel.setBackground(new Color(color1, color2, color3));
	}
}