package isearch.env;

import isearch.analyzer.SimpleAnalzer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class MySqlDataProvider
  implements IDataProvider
{
  public PreparedStatement getInsertSearchIndexPS(Connection conn)
    throws SQLException
  {
    return conn
      .prepareStatement("insert into search_index(url,result,times,title,result_text) values(?,?,?,?,?)");
  }

  public PreparedStatement getInsertSearchURLPS(Connection conn) throws SQLException
  {
    return conn.prepareStatement("insert into search_url values(?,?,?)");
  }

  public ResultSet getunSearchURL(Connection conn, int count) throws SQLException
  {
    return conn.createStatement().executeQuery(
      "select url from search_url where state<>1 limit " + count);
  }

  public PreparedStatement getUpdateURLPS(Connection conn) throws SQLException
  {
    return conn
      .prepareStatement("update search_url set state=1,times=? where url=?");
  }

  public ResultSet getStatistics(Connection conn) throws SQLException {
    return conn
      .createStatement()
      .executeQuery(
      "select count(*) cn from search_url where state=1  union all select count(*) cn from search_url where state<>1  union all select count(*) cn from search_index");
  }

  public PreparedStatement getRollBackUpdateURLPS(Connection conn)
    throws SQLException
  {
    return conn
      .prepareStatement("update search_url set state=0 where url=?");
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
public List<Map<String, String>> search(Connection conn, String keyword, int pageNo, int pageSize) throws SQLException
  {
	SimpleAnalzer analzer = new SimpleAnalzer();
    String[] skeyword = analzer.search(keyword).replaceAll(" +", " ").split(" ");
    StringBuffer sb = new StringBuffer("");
    sb
      .append("select pkey,url,result_text,title from search_index where 1=2 ");

    sb.append("or (1=1 ");
    for (String s : skeyword) {
    	System.out.println(s+"111111111111111");
      sb.append(" and result_text like '%" + s + "%' ");
    }
    sb.append(") ");

    sb.append("or (1=1 ");
    for (String s : skeyword) {
    	System.out.println(s+"2222222222222222");
      sb.append(" and title like '%" + s + "%' ");
    }
    sb.append(")");
    ResultSet rs = conn.createStatement().executeQuery(
      "select count(*) cn from (" + sb.toString() + ")temp");
    rs.next();
    int count = rs.getInt("cn");
    System.out.println(count);
    rs.close();
    sb.append(" limit " + (pageNo - 1) * pageSize + "," + pageSize);
    rs = conn.createStatement().executeQuery(sb.toString());
    Object list = new ArrayList();
    HashMap countmap = new HashMap();
    countmap.put("count", String.valueOf(count));
    ((List)list).add(countmap);
    while (rs.next()) {
      HashMap map = new HashMap();
      map.put("url", rs.getString("url"));
      map.put("result", rs.getString("result_text"));
      map.put("pkey", rs.getString("pkey"));
      map.put("title", rs.getString("title"));
      ((List)list).add(map);
    }
    return (List<Map<String, String>>)list;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
public Map<String, String> getInfo(String pkey) throws SQLException {
    Connection conn = Toolkit.getConnection();
    Map map = new HashMap();
    try {
      ResultSet rs = conn.createStatement().executeQuery(
        "select * from search_index where pkey=" + pkey);

      if (rs.next()) {
        map.put("content", rs.getString("result"));
        map.put("title", rs.getString("title"));
        map.put("url", rs.getString("url"));
        map.put("times", rs.getString("times"));
      }
    } catch (Exception e) {
      Toolkit.printInfo("", e);
    } finally {
      conn.close();
    }
    return map;
  }
}