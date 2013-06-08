package demo;

import java.io.*;
import java.util.Date;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

import com.swetake.util.Qrcode;


public class QRCodeEncoderTest
{

 /** Creates a new instance of QRCodeEncoderTest */
 public QRCodeEncoderTest()
 {
 }
 
 public static void create_image(String sms_info)throws Exception{
  try{
           Qrcode testQrcode =new Qrcode();
            testQrcode.setQrcodeErrorCorrect('M');
            testQrcode.setQrcodeEncodeMode('B');
            testQrcode.setQrcodeVersion(7);
            //Ҫ���ɶ�ά�����Ϣ
            String testString = "������";
            byte[] d = testString.getBytes("utf-8");
            System.out.println(d.length);
            //BufferedImage bi = new BufferedImage(98, 98, BufferedImage.TYPE_INT_RGB);
            BufferedImage bi = new BufferedImage(98, 98, BufferedImage.TYPE_BYTE_BINARY);
            Graphics2D g = bi.createGraphics();
            g.setFont(new Font(Font.MONOSPACED,21,22));
            g.setBackground(Color.PINK);
            g.clearRect(0, 0, 98, 98);
            //��ά����ɫ
            g.setColor(Color.RED);
            
            // ��������ֽ���Ϊ120
            if (d.length>0 && d.length <120){
                boolean[][] s = testQrcode.calQrcode(d);
                for (int i=0;i<s.length;i++){
                    for (int j=0;j<s.length;j++){
                        if (s[j][i]) {
                            g.fillRect(j*2+3,i*2+3,2,2);
                        }
                    }
                }
            }
            g.dispose();
            bi.flush();
            File f = new File("D:\\������\\QRCodeTest\\"+sms_info+".jpg");
            if(!f.exists()){
            	f.createNewFile();
            }
            //����ͼƬ
            ImageIO.write(bi, "jpg", f);
            
        } // end try
        catch (Exception e) {
            e.printStackTrace();
        } // end catch
 }

 public static void main(String[] args) throws Exception {
        System.out.println(new Date());
        for(int i =1; i < 2; i ++){
         QRCodeEncoderTest.create_image(i+"");
        }
        System.out.println(new Date());
    } // end main
}