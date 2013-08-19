package action;

import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import thread.SimpleThread;
import thread.TestThread;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	private String email;
	private TestThread mt=null;

	public String getEmail() {
		return email;
	}

	public TestAction() {
		if(mt==null)
		mt = new TestThread();
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void ajax() throws Exception {
		 email=(String)ServletActionContext.getRequest().getAttribute("email");
		 /****************���̵߳���********************/
//		 SimpleThread t=new SimpleThread();
//		 t.start();//�ĳ�t.run()��Ϊ���̵߳���
		 /**********************************************/
		 
		 /*====================���̵߳���=============================*/
//			if(ServletActionContext.getRequest().getParameter("name").equals("ab"))
			new Thread(mt, "a").start();
//			if(ServletActionContext.getRequest().getParameter("name").equals("ba"))
			new Thread(mt, "b").start();
			if(ServletActionContext.getRequest().getParameter("name").equals("c"))
			new Thread(mt, "c").start();
		 /*================================================================*/
		ServletActionContext.getResponse().setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		System.out.println("������"
				+ ServletActionContext.getRequest().getParameter("name"));
		System.out.println("Email��"
				+ ServletActionContext.getRequest().getParameter("email"));
		System.out.println("�绰��"
				+ ServletActionContext.getRequest().getParameter("phone"));
		out.print("<h5 style='text-align: center;'>�ɹ���������</h5>");
		out.flush();
		out.close();
	}
}
