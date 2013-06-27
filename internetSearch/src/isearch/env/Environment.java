package isearch.env;

import isearch.search.SearchThread;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Environment
{
  private static Environment env;
  private InContainer inContainer;
  private OutContainer outContainer;
  private List<SearchThread> threadContainer = new ArrayList();

  static {
    try { Class.forName(Toolkit.getParameter("db_driver"));
    } catch (ClassNotFoundException e) {
      Toolkit.printInfo("", e);
    }
  }

  public InContainer getInContainer()
  {
    return this.inContainer;
  }

  public OutContainer getOutContainer() {
    return this.outContainer;
  }

  public static Environment getInstance() {
    if (env == null) {
      env = new Environment();
      InContainer inContainer = new InContainer();
      OutContainer outContainer = new OutContainer();
      env.inContainer = inContainer;
      env.outContainer = outContainer;
    }
    return env;
  }

  public void startSearch()
    throws SQLException
  {
    if ((this.inContainer.getDbconn() == null) || 
      (this.inContainer.getDbconn().isClosed()))
      this.inContainer.setDbconn(Toolkit.getConnection());
    if ((this.outContainer.getDbconn() == null) || 
      (this.outContainer.getDbconn().isClosed())) {
      this.outContainer.setDbconn(Toolkit.getConnection());
    }
    int maxThread = Integer.parseInt(Toolkit.getParameter("searchthread"));
    int i;
    synchronized (this.threadContainer) {
      i = 0;
      do {
        this.threadContainer.add(new SearchThread(Toolkit.getConnection()));

        i++;

        if (i >= maxThread) break; 
      }
      while (this.threadContainer.size() <= maxThread);
    }

    for (SearchThread st : this.threadContainer)
      st.start();
  }

  public void stopSearch()
    throws SQLException
  {
    synchronized (this.threadContainer) {
      while (this.threadContainer.size() > 0) {
        SearchThread t = (SearchThread)this.threadContainer.remove(0);
        t.stopRun();
      }
    }
    try
    {
      this.outContainer.setRollBackURL();
      this.inContainer.updateURL();
    } catch (SQLException e) {
      Toolkit.printInfo("", e);
    }

    if ((this.inContainer.getDbconn() != null) && 
      (!this.inContainer.getDbconn().isClosed()))
      this.inContainer.getDbconn().close();
    if ((this.outContainer.getDbconn() != null) && 
      (!this.outContainer.getDbconn().isClosed()))
      this.outContainer.getDbconn().close();
  }

  public int[] getStatistics()
    throws SQLException
  {
    int[] arr = new int[4];
    arr[0] = this.threadContainer.size();
    Connection conn = Toolkit.getConnection();
    ResultSet rs = Toolkit.getDataProvider().getStatistics(conn);
    rs.next();
    arr[1] = rs.getInt("cn");
    rs.next();
    arr[2] = rs.getInt("cn");
    rs.next();
    arr[3] = rs.getInt("cn");
    conn.close();
    return arr;
  }

  public List<Map<String, String>> getSearchResult(String keyword, int pageNo, int pageSize)
    throws SQLException
  {
    Connection conn = Toolkit.getConnection();
    List mlist = Toolkit.getDataProvider().search(
      conn, keyword, pageNo, pageSize);
    conn.close();
    return mlist;
  }
}