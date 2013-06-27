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
//				System.out.print("车牌号码:"
//						+ doc.getElementsByTagName("NO").item(i)
//								.getFirstChild().getNodeValue());
//
//				System.out.println("车主地址:"
//						+ doc.getElementsByTagName("ADDR").item(i)
//								.getFirstChild().getNodeValue());
//
//				System.out.println("运行时间："
//						+ (System.currentTimeMillis() - lasting) + "毫秒");
//			}
//			
//			System.out.println(doc.getXmlEncoding());
//			
//			
			
			
			//获得一个XML文件的解析器
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//解析XML文件生成DOM文档的接口类，以便访问DOM。
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse( new File("D:\\demo\\test.xml") ); 
			
			//获得Root元素
			Element element = document.getDocumentElement();
			//获得Root元素的子节点列表
			NodeList nodelist = element.getChildNodes();
			
			//用递归方法实现DOM文档的遍历
//			GetElement(nodelist);
			// 获得将DOM文档转化为XML文件的转换器，在jdk1.4中，有类TransformerFactory
			// 来实现，类Transformer实现转化API。
		    TransformerFactory tfactory = TransformerFactory.newInstance();
			Transformer transformer = tfactory.newTransformer();
			// 将DOM对象转化为DOMSource类对象，该对象表现为转化成别的表达形式的信息容器。
			DOMSource source = new DOMSource(document);
			// 获得一个StreamResult类对象，该对象是DOM文档转化成的其他形式的文档的容器，可以是XML文件，文本文件，HTML文件。这里为一个XML文件。
			StreamResult result = new StreamResult(new File("D:\\index.htm"));
			// 调用API，将DOM文档转化成XML文件。
			
			/**
			 * xml转换dom，dom转换string
			 * */
			transformer.transform(source,result);
			 java.io.StringWriter sw = new java.io.StringWriter();
			 StreamResult sr = new StreamResult(sw);
			 transformer.transform(source, sr);
			 String xml = sw.toString();
			 System.out.println(xml);
	
			  /**
			   * 
			   * string转换dom
			   * */
			 StringReader sr1 = new StringReader(xml);   
			   
			 InputSource is = new InputSource(sr1);   
			   
			 Document doc = builder.parse(is); 
			 
			 System.out.println(doc.getElementsByTagName("id").item(0).getFirstChild().getNodeValue());
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//其中GetElement方法实现如下：
//    public static void GetElement(NodeList nodelist){
//    Node     cnode;
//    int   i,len;
//    String  str;
//    
//    if(nodelist.getLength() == 0){
//        // 该节点没有子节点
//        return;
//    }
//    for (Node cnodex : nodelist) {
//		
//	}
//    }

}
