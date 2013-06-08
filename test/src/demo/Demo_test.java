package demo;
import java.io.IOException;
import java.io.OutputStreamWriter;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class Demo_test {
	public static void main(String[] args) {
		
		 //����Document����
		  Document document= DocumentHelper.createDocument();
		  
		  //�������ڵ�
		  Element root=DocumentHelper.createElement("Book-info");
		  document.setRootElement(root);
		  
		  //����ͼ��ڵ�1
		  Element book1=root.addElement("book");
		  book1.addAttribute("����", "Java Web*****");
		  
		  //����ͼ��ڵ���ӽڵ�
		  Element book1_price=book1.addElement("�۸�");
		  book1_price.setText("79.*");
		  //����ͼ��ڵ���ӽڵ�
		  Element book_author=book1.addElement("����");
		  book_author.setText("����");
		  
		  
		  //����ͼ��ڵ�2
		  Element book2=root.addElement("book");
		  book2.addAttribute("����", "Java*****");
		  
		  //�����ӽڵ�
		  Element book2_price=book2.addElement("�۸�");
		  book2_price.setText("59.8");
		  //����ͼ��ڵ���ӽڵ�
		  Element book2_author=book2.addElement("����");
		  book2_author.setText("����");
		  
		  
		  try {
		   //����OutputFormat
		   OutputFormat format=OutputFormat.createPrettyPrint();
		   //����XMLWriter
		   XMLWriter xmlWriter=
		     new XMLWriter(new OutputStreamWriter(System.out),format);
		   //���XML�ĵ�
		   xmlWriter.write(document);
		   xmlWriter.flush();
		   xmlWriter.close();
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }

	}
}
