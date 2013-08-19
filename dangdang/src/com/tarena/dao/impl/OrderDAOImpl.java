package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.mysql.jdbc.Statement;
import com.tarena.dao.OrderDAO;
import com.tarena.entity.Order;
import com.tarena.util.DBConnection;
import com.tarena.util.FormatDateUtil;
import com.tarena.web.action.cart.CartService;

public class OrderDAOImpl implements OrderDAO{
	private static final String INSERT = "insert into d_order(user_id,status,order_time,order_desc,total_price,receive_name,full_address,postal_code,mobile,phone) values(?,?,?,?,?,?,?,?,?,?)";
	
	
	private static final String INSERTITEM = "insert into d_item(order_id,product_id,product_name,dang_price,product_num,amount) values(?,?,?,?,?,?)";
	public void save(Order order, CartService cart) throws Exception {
		PreparedStatement prep = null;
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			prep = conn.prepareStatement(INSERT,
					Statement.RETURN_GENERATED_KEYS);
			prep.setInt(1, order.getUser_id());
			prep.setInt(2, order.getStatus());
			prep.setString(3, FormatDateUtil.getFormatDate(new Date()));
			prep.setString(4, order.getOrder_desc());
			prep.setDouble(5, order.getTotal_price());
			prep.setString(6, order.getReceive_name());
			prep.setString(7,order.getFull_address() );
			prep.setString(8, order.getPostal_code());
			prep.setString(9, order.getMobile());
			prep.setString(10, order.getPhone());
			prep.executeUpdate();
			ResultSet rst = prep.getGeneratedKeys();
			rst.next();
			int id = rst.getInt(1);
			order.setId(id);
			this.saveItem(order, cart);
		} finally {
			DBConnection.close(prep, conn);
		}
	}
	public void saveItem(Order order, CartService cart){
		PreparedStatement prep = null;
		Connection conn = null;
		try {
			for (int i = 0; i < cart.getItems(false).size(); i++) {
				try {

					conn = DBConnection.getConnection();
					prep = conn.prepareStatement(INSERTITEM,
							Statement.RETURN_GENERATED_KEYS);
					prep.setInt(1, order.getId());
					prep.setInt(2, cart.getItems(false).get(i).getPro().getId());
					prep.setString(3,cart.getItems(false).get(i).getPro().getProduct_name());
					prep.setDouble(4, cart.getItems(false).get(i).getPro().getDang_price());
					
					prep.setDouble(5, cart.getItems(false).get(i).getNum());
					System.out.println("商品个数："+cart.getItems(false).get(i).getNum()+cart.getItems(false).get(i).getPro().getProduct_name());
					prep.setDouble(6, cart.getItems(false).get(i).getNum());


					prep.executeUpdate();
					ResultSet rst = prep.getGeneratedKeys();
					rst.next();
					int id = rst.getInt(1);
					order.setId(id);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						DBConnection.close(prep, conn);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
