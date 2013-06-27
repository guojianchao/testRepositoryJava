package isearch.env;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public abstract interface IDataProvider{
  /**
   * 向数据库中插入查询出的网页的首页信息
   * **/
  public abstract PreparedStatement getInsertSearchIndexPS(Connection paramConnection)
    throws SQLException;
  /**
   * 向数据库中插入查询出的链接地址
   * */
  public abstract PreparedStatement getInsertSearchURLPS(Connection paramConnection)
    throws SQLException;
  /**
   * 
   * */
  public abstract ResultSet getunSearchURL(Connection paramConnection, int paramInt)
    throws SQLException;

  public abstract PreparedStatement getUpdateURLPS(Connection paramConnection)
    throws SQLException;

  public abstract PreparedStatement getRollBackUpdateURLPS(Connection paramConnection)
    throws SQLException;

  public abstract ResultSet getStatistics(Connection paramConnection)
    throws SQLException;

  public abstract List<Map<String, String>> search(Connection paramConnection, String paramString, int paramInt1, int paramInt2)
    throws SQLException;

  public abstract Map<String, String> getInfo(String paramString)
    throws SQLException;
}