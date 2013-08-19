package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * 获取本周是当前月的第几个星期，然后获取一周的时间日历
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
//			cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // 获取本周一的日期
//
//			System.out.println(df.format(cal.getTime()));
//			// 这种输出的是上个星期周日的日期，因为老外那边把周日当成第一天
//			cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//			// 增加一个星期，才是我们中国人理解的本周日的日期
//			cal.add(Calendar.WEEK_OF_YEAR, 1);
//			System.out.println(sdf.format(cal.getTime()));
			
//			SimpleDateFormat sdf=new SimpleDateFormat("y年M月d日 E H时m分s秒",Locale.CHINA);
			Calendar calendar=Calendar.getInstance(Locale.CHINA);

			//其余的行不变只加入这一行即可，设定每周的起始日。
			calendar.setFirstDayOfWeek(Calendar.MONDAY); //以周1为首日

			calendar.setTimeInMillis(System.currentTimeMillis());//当前时间
			System.out.println("当前时间:"+sdf.format(calendar.getTime()));		
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			System.out.println("周一时间:"+sdf.format(calendar.getTime()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Date d = new Date();
		d.getDate();
	}
}
