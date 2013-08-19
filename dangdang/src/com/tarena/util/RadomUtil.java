package com.tarena.util;

import java.util.Date;

public class RadomUtil {
	public static int getRadomValue(){
		int num=(int)(Math.random()*10);
		return num;
	}
	public static void main(String[] args) {
		RadomUtil.getRadomValue();
		System.out.println(RadomUtil.getRadomValue()+(new Date()).toString());
	}
}
