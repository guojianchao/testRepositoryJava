package luenue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class VisitBaiDu {
	public static Logger log = Logger.getLogger("system_log");

	public static void main(String[] args) {
		http://www.baidu.com/s?wd=o&rsv_spt=1&issp=1&rsv_bp=0&ie=utf-8&tn=baiduhome_pg&rsv_sug3=1&rsv_sug=0&rsv_sug1=1&rsv_sug4=38&inputT=1923
		try {
			log.error("worning error!!!");
			 for(int i=0;i<1000;i++){
			 log.info("num:-->>"+i);
			 System.out.println("num:-->"+i);
			 HttpURLConnection huc = (HttpURLConnection)new
			 URL("http://www.baidu.com/s?wd=o&rsv_spt=1&issp=1&rsv_bp=0&ie=utf-8&tn=baiduhome_pg&rsv_sug3=1&rsv_sug=0&rsv_sug1=1&rsv_sug4=38&inputT=1923").openConnection();
			 BufferedReader br = new BufferedReader(
			 new InputStreamReader(huc.getInputStream(),"utf-8"));
			 huc.connect();
			  StringBuffer content = new StringBuffer();
			  String line;
			  while ((line = br.readLine()) != null)
			  {
			 // String line;
			  content.append(line);
			  }
			  Map hrefMap = new HashMap();
			  Map srcMap = new HashMap();
			  String scontent = content.toString();log.info(scontent);
			  System.out.println(scontent);
			 }
			
			// while (true) {
			// try {
			// Thread.sleep(1000*60);
			// } catch (Exception e) {
			// // TODO: handle exception
			// }
			// log.info("success info");
			// }

			// ��ά����
			
			
//			int[][] numeight={{100,200,300,400,555},{500,600,700,800},{900,1000,1100,1200,1300}};
//			System.out.println(numeight[0][4]);
//			System.out.println(numeight[1][2]);
//			System.out.println(numeight[2][1]);
//			
//			
//			
//			
//			
//			
//			
//			
//			float[][] numthree; // ����һ��float���͵�2ά����
//			numthree = new float[5][5]; // Ϊ������5��5�еĿռ��С
//			numthree[0][1] = 1.1f; // ͨ���±�����ȥ���� 1��1��=1.1
//			numthree[1][0] = 1.2f; // 2��1��=1.2
//			numthree[2][0] = 1.3f; // 3��1��=1.3
//			numthree[3][0] = 1.4f; // 4��1��=1.4
//			numthree[4][0] = 1.5f; // 5��1��=1.5
//			System.out.println(numthree[0][1]); // ��ӡ��������
//			System.out.println(numthree[1][0]);
//			System.out.println(numthree[2][0]);
//			System.out.println(numthree[3][0]);
//			System.out.println(numthree[4][0]);
//
//			short[][] numfour = new short[5][8]; // ����һ��short���͵�����ͬʱΪ������5��8�еĿռ��С
//			numfour[0][7] = 10;
//			numfour[1][6] = 20;
//			numfour[2][5] = 30;
//			numfour[3][4] = 40;
//			numfour[4][3] = 50;
//			System.out.println(numfour[0][7]);
//			System.out.println(numfour[1][6]);
//			System.out.println(numfour[2][5]);
//			System.out.println(numfour[3][4]);
//			System.out.println(numfour[4][3]);
//
//			int array[][] = new int[3][4];
//			for (int i = 0; i < 3; i++) {
//				for (int j = 0; j < 4; j++) {
//					array[i][j] = Integer.parseInt(i * 10 + j + "");
//					System.out.print(array[i][j] + " ");
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
