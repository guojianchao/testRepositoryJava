package test;

    import java.io.BufferedReader;  
    import java.io.FileInputStream;  
    import java.io.IOException;  
    import java.io.InputStream;  
    import java.io.InputStreamReader;  
import java.text.DateFormat;
import java.text.SimpleDateFormat;
    import java.util.ArrayList;  
import java.util.Calendar;
import java.util.Date;
    import java.util.Scanner;  
     
import javax.xml.crypto.Data;  
     
     
    public class Main {  
     
        public static void main(String[] args) throws Exception {  
//            ArrayList<String> words = new ArrayList<String>();  
//            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:/demo/china.dic")));  
//            String s;  
//            int num = 0;  
//            while((s=reader.readLine()) != null)  
//            {  
//                words.add(s);  
//                num ++;  
//            }  
//            DoubleArrayTrie dat = new DoubleArrayTrie();  
//              
//            for(String word: words)  
//            {  
////            	System.out.println(new String(word.getBytes("GBK"),"utf-8"));
//                dat.Insert(word);  
//            }  
//              
//            System.out.println(dat.Base.length);  
//            System.out.println(dat.Tail.length);  
//              
//            Scanner sc = new Scanner(System.in);  
//            while(sc.hasNext())  
//            {  
//                String word = sc.next();  
//                System.out.println(word);
//                System.out.println(dat.Exists(word));  
//                System.out.println(dat.FindAllWords(word));  
//            }  
        	
        	
        	Calendar calendar = Calendar.getInstance();
    		calendar.setTime(new Date());
    		calendar.add(Calendar.DAY_OF_MONTH, 0);
    		 calendar.getTime();
            System.out.println(calendar.getTime());  
            
            Calendar calendar1 = Calendar.getInstance();
    		calendar1.add(Calendar.DATE, -1);    //得到前一天凌晨一点
    		Date date = calendar1.getTime();
    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd 01:00:00");
    		
    		Date date1=new Date();//当天时间
    		DateFormat df1=new SimpleDateFormat("yyyy-MM-dd 01:00:00");
    		System.out.println(df.format(date)+"\n"+df1.format(date1));
        }  
     
    }  