package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * ��ȡ�����ǵ�ǰ�µĵڼ������ڣ�Ȼ���ȡһ�ܵ�ʱ������
 * */
public class Date {

	public void getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		List<String> list = new ArrayList<String>();
		try {
//			Calendar cal = Calendar.getInstance(Locale.CHINA);
//			cal.set(Calendar.WEEK_OF_MONTH, 1);
//			int day = cal.get(Calendar.DAY_OF_YEAR);
//			System.out.println(day);
//			for (int i = 0; i < 7; i++) {
//				String dd = cal.get(Calendar.YEAR) + "-"
//						+ (cal.get(Calendar.MONTH) + 1) + "-"
//						+ cal.get(Calendar.DAY_OF_MONTH);
//				list.add(sdf.format(sdf.parse(dd)));
//				System.out.println(sdf.format(sdf.parse(dd)));
//				day++;
//				cal.set(Calendar.DAY_OF_YEAR, day);
//			}

//			Calendar cal = Calendar.getInstance();
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//
//			cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // ��ȡ����һ������
//
//			System.out.println(df.format(cal.getTime()));
//			// ������������ϸ��������յ����ڣ���Ϊ�����Ǳ߰����յ��ɵ�һ��
//			cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//			// ����һ�����ڣ����������й������ı����յ�����
//			cal.add(Calendar.WEEK_OF_YEAR, 1);
//			System.out.println(sdf.format(cal.getTime()));
			
//			SimpleDateFormat sdf=new SimpleDateFormat("y��M��d�� E Hʱm��s��",Locale.CHINA);
			Calendar calendar=Calendar.getInstance(Locale.CHINA);

			//������в���ֻ������һ�м��ɣ��趨ÿ�ܵ���ʼ�ա�
			calendar.setFirstDayOfWeek(Calendar.MONDAY); //����1Ϊ����

			calendar.setTimeInMillis(System.currentTimeMillis());//��ǰʱ��
			System.out.println("��ǰʱ��:"+sdf.format(calendar.getTime()));		
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			System.out.println("��һʱ��:"+sdf.format(calendar.getTime()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Date d = new Date();
		d.getDate();
	}
}
