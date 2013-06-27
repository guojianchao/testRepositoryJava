package isearch.env;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class InContainer
{
  private List<String> container = new LinkedList();
  private Connection dbconn;

  public Connection getDbconn()
  {
    return this.dbconn;
  }

  public void setDbconn(Connection dbconn) {
    this.dbconn = dbconn;
  }

  public void setURL(String url)
  {
    synchronized (this.container) {
      this.container.add(url);
      if (this.container.size() > Integer.parseInt(
        Toolkit.getParameter("maxInURL")))
        try {
          updateURL();
        } catch (SQLException e) {
          Toolkit.printInfo("error : can not update url", e);
        }
    }
  }

  public void updateURL()
    throws SQLException
  {
    synchronized (this.container) {
      PreparedStatement ps = Toolkit.getDataProvider()
        .getInsertSearchURLPS(this.dbconn);
      while (this.container.size() > 0) {
        String url = (String)this.container.remove(0);
        try {
          ps.setString(1, url);
          ps.setInt(2, 0);
          ps.setString(3, Toolkit.getTime());
          ps.execute();
        }
        catch (Exception localException)
        {
        }
      }
    }
  }

  public void finalize()
  {
    try
    {
      this.dbconn.close();
    } catch (SQLException e) {
      Toolkit.printInfo("", e);
    }
  }
}