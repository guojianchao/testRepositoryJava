package com.tarena.web.action.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.tarena.entity.Book;
import com.tarena.entity.User;
import com.tarena.util.RadomUtil;
import com.tarena.web.action.BaseAction;

public class MainAction extends BaseAction {
	
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String execute(){
		int id=0;
		int num=0;
		if(request.getParameter("id")!=""&&request.getParameter("id")!=null){
			id=Integer.parseInt((String)request.getParameter("id"));
		}
		List<Book> list=new ArrayList<Book>();
		Map<String,Object> session = ActionContext.getContext().getSession();
		List<Book> listViewed=null;
		if(session.get("listViewed")!=""&&session.get("listViewed")!=null){
			listViewed=(List<Book>)session.get("listViewed");
			for (int i = 0; i < 2; i++) {
				if (listViewed.size()>0) {
					for (int j=0;j<listViewed.size();j++) {
						num = RadomUtil.getRadomValue();
						if (listViewed.size() > num && num != id) {
							list.add(listViewed.get(num));
							id = num;
							if(list.size()==1){
								continue;
							}
							break;
						}
					}
				}else{
					break;
				}
			}
			
		}
		System.out.println("list的长度："+list.size());
		session.put("pageShow", list);
		
		
		return "main";
		
	}

}
