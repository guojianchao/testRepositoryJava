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

//测试类
public class Exec {
	public static void main(String[] args) {
		// 创建窗体类变量
		DemoWindow dw = new DemoWindow("读取Word文件");

		// 将窗体的宽度和高度分别设置为屏幕宽度和屏幕高度的1/3，左上角位置也设置为屏幕宽度和屏幕高度的1/3处
		Toolkit theKit = dw.getToolkit();
		Dimension wndSize = theKit.getScreenSize();
		dw.setBounds(wndSize.width / 3, wndSize.height / 3, wndSize.width / 3,
				wndSize.height / 3);

		// 点击关闭按钮可以退出程序
		dw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 设置窗体为可见
		dw.setVisible(true);
	}
}

// 界面窗体
class DemoWindow extends JFrame implements AdjustmentListener// 注意此处
{
	// 红的颜色数值
	int color1 = 0;

	// 绿的颜色数值
	int color2 = 0;

	// 蓝的颜色数值
	int color3 = 0;

	// 调整红色的滚动条
	JScrollBar s1 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 1, 0, 256);

	// 调整绿色的滚动条
	JScrollBar s2 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 1, 0, 256);

	// 调整蓝色的滚动条
	JScrollBar s3 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 1, 0, 256);

	// 布局面板
	JPanel jp = new JPanel();

	// 显示颜色的面板
	JPanel colorPanel = new JPanel();

	// 构造函数
	public DemoWindow(String title) {
		// 窗体布局
		jp.setLayout(new GridLayout(3, 1));
		jp.add(s1);
		jp.add(s2);
		jp.add(s3);
		add(jp, BorderLayout.NORTH);
		add(colorPanel, BorderLayout.CENTER);

		// 设置默认的背景色
		colorPanel.setBackground(new Color(color1, color2, color3));

		// 添加事件监听器
		s1.addAdjustmentListener(this);
		s2.addAdjustmentListener(this);
		s3.addAdjustmentListener(this);
	}

	// 响应调整滚动条
	public void adjustmentValueChanged(AdjustmentEvent e) {
		// 处理调整红色
		if (e.getAdjustable() == s1)
			color1 = s1.getValue();

		// 处理调整绿色
		if (e.getAdjustable() == s2)
			color2 = s2.getValue();

		// 处理调整蓝色
		if (e.getAdjustable() == s3)
			color3 = s3.getValue();

		// 设置新的背景色
		colorPanel.setBackground(new Color(color1, color2, color3));
	}
}