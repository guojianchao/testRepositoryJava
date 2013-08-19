package com.tarena.util;

import java.util.Date;
import java.text.SimpleDateFormat;
public class FormatDateUtil {
	public static String getFormatDate(Date date){
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String s=sFormat.format(date);
		return s;
	}
	
	public static void main(String[] args) {
		String sr=FormatDateUtil.getFormatDate(new Date());
		System.out.println(sr);
	}
}
