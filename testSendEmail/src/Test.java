import com.email.webserviceclient.HelloServiceService;


public class Test {
public static void main(String[] args) {
	HelloServiceService he=new HelloServiceService();
	System.out.println(he.getHelloServicePort().getInfo("hello"));
}
}
