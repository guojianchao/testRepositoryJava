package com.tarena.web.action.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.tarena.dao.DAOFactory;
import com.tarena.dao.ProductDAO;
import com.tarena.entity.Book;
import com.tarena.web.action.BaseAction;


public class BookViewAction extends BaseAction{
	private Book book;
	private int id;
	
	public String execute() throws Exception{
		Map<String,Object> session = ActionContext.getContext().getSession();
		List<Book> lis=new ArrayList<Book>();
		
		//通过dao获取书本信息
		ProductDAO pDao = DAOFactory.getProductDAO();
		book = (Book) pDao.findById(id);
		book.setId(id);
		if(session.get("listViewed")!=null&&session.get("listViewed")!=""){
			lis=(List<Book>) session.get("listViewed");
			System.out.println(lis.size()+"==========");
		}else{
			lis.add(book);
		}
		List<Book> list=new ArrayList<Book>();
		list=lis;
		int row=0;
		for(int i=0;i<list.size();i++){
			if(list.get(i).getId()==id){
				row+=1;
				break;
			}
		}
		if(row==0){list.add(book);}
		
		session.put("listViewed",list);
		session.put("viewed",book);
		return "bookview";
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
