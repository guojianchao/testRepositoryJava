package isearch.env;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OutContainer
{
  private List<String> container = new LinkedList();
  private Connection dbconn;

  public OutContainer()
  {
    this.container.add(Toolkit.getParameter("searchstart"));
  }

  public int getSize() {
    return this.container.size();
  }

  public String getURL()
  {
    String url = null;
    synchronized (this.container) {
      if (this.container.size() > 0)
        url = (String)this.container.remove(0);
      if (this.container.size() < Integer.parseInt(
        Toolkit.getParameter("minOutURL"))) {
        try {
          setURL();
        } catch (SQLException e) {
          Toolkit.printInfo("", e);
        }
      }
    }
    return url;
  }

  public void setURL()
    throws SQLException
  {
    List tlist = new ArrayList();
    ResultSet rs = Toolkit.getDataProvider().getunSearchURL(this.dbconn, 
      Integer.parseInt(Toolkit.getParameter("minOutURLIncremental")));
    while (rs.next()) {
      String url = rs.getString("url");
      tlist.add(url);
    }
    PreparedStatement ps = Toolkit.getDataProvider().getUpdateURLPS(this.dbconn);
    for (Object url : tlist) {
      
      ps.setString(1, Toolkit.getTime());
      ps.setString(2, url.toString());
      ps.execute();
    }
    synchronized (this.container) {
      for (Object url : tlist)
        this.container.add(url.toString());
    }
  }

  public void setRollBackURL()
    throws SQLException
  {
    PreparedStatement ps = Toolkit.getDataProvider()
      .getRollBackUpdateURLPS(this.dbconn);
    synchronized (this.container) {
      while (this.container.size() > 0) {
        ps.setString(1, (String)this.container.remove(0));
        ps.execute();
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

  public Connection getDbconn() {
    return this.dbconn;
  }

  public void setDbconn(Connection dbconn) {
    this.dbconn = dbconn;
  }
}