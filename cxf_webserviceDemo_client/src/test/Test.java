package test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.cxf.service.MessageService;


public class Test {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");

		MessageService service = (MessageService) context.getBean("messageServiceClient");

		System.out.println(service.getMessage("ºÍÐ³dota"));
	}

}
