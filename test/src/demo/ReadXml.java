package demo;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ReadXml {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long lasting = System.currentTimeMillis();
		try {
//			File f = new File("D:\\demo\\test.xml");
//			DocumentBuilderFactory factory = DocumentBuilderFactory
//					.newInstance();
//			DocumentBuilder builder = factory.newDocumentBuilder();
//			Document doc = builder.parse(f);
//			NodeList nl = doc.getElementsByTagName("VALUE");
//
//			for (int i = 0; i < nl.getLength(); i++) {
//
//				System.out.print("���ƺ���:"
//						+ doc.getElementsByTagName("NO").item(i)
//								.getFirstChild().getNodeValue());
//
//				System.out.println("������ַ:"
//						+ doc.getElementsByTagName("ADDR").item(i)
//								.getFirstChild().getNodeValue());
//
//				System.out.println("����ʱ�䣺"
//						+ (System.currentTimeMillis() - lasting) + "����");
//			}
//			
//			System.out.println(doc.getXmlEncoding());
//			
//			
			
			
			//���һ��XML�ļ��Ľ�����
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//����XML�ļ�����DOM�ĵ��Ľӿ��࣬�Ա����DOM��
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse( new File("D:\\demo\\test.xml") ); 
			
			//���RootԪ��
			Element element = document.getDocumentElement();
			//���RootԪ�ص��ӽڵ��б�
			NodeList nodelist = element.getChildNodes();
			
			//�õݹ鷽��ʵ��DOM�ĵ��ı���
//			GetElement(nodelist);
			// ��ý�DOM�ĵ�ת��ΪXML�ļ���ת��������jdk1.4�У�����TransformerFactory
			// ��ʵ�֣���Transformerʵ��ת��API��
		    TransformerFactory tfactory = TransformerFactory.newInstance();
			Transformer transformer = tfactory.newTransformer();
			// ��DOM����ת��ΪDOMSource����󣬸ö������Ϊת���ɱ�ı����ʽ����Ϣ������
			DOMSource source = new DOMSource(document);
			// ���һ��StreamResult����󣬸ö�����DOM�ĵ�ת���ɵ�������ʽ���ĵ���������������XML�ļ����ı��ļ���HTML�ļ�������Ϊһ��XML�ļ���
			StreamResult result = new StreamResult(new File("D:\\index.htm"));
			// ����API����DOM�ĵ�ת����XML�ļ���
			
			/**
			 * xmlת��dom��domת��string
			 * */
			transformer.transform(source,result);
			 java.io.StringWriter sw = new java.io.StringWriter();
			 StreamResult sr = new StreamResult(sw);
			 transformer.transform(source, sr);
			 String xml = sw.toString();
			 System.out.println(xml);
	
			  /**
			   * 
			   * stringת��dom
			   * */
			 StringReader sr1 = new StringReader(xml);   
			   
			 InputSource is = new InputSource(sr1);   
			   
			 Document doc = builder.parse(is); 
			 
			 System.out.println(doc.getElementsByTagName("id").item(0).getFirstChild().getNodeValue());
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//����GetElement����ʵ�����£�
//    public static void GetElement(NodeList nodelist){
//    Node     cnode;
//    int   i,len;
//    String  str;
//    
//    if(nodelist.getLength() == 0){
//        // �ýڵ�û���ӽڵ�
//        return;
//    }
//    for (Node cnodex : nodelist) {
//		
//	}
//    }

}
