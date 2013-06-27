package isearch.env;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public abstract interface IDataProvider{
  /**
   * �����ݿ��в����ѯ������ҳ����ҳ��Ϣ
   * **/
  public abstract PreparedStatement getInsertSearchIndexPS(Connection paramConnection)
    throws SQLException;
  /**
   * �����ݿ��в����ѯ�������ӵ�ַ
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