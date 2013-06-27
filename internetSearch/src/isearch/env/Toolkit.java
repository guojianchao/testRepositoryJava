package isearch.env;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Toolkit{
  private static Properties params = new Properties();
  private static SimpleDateFormat dformat = new SimpleDateFormat(
    "yyyy-MM-dd HH:mm:ss");

  static
  {
    InputStream inputStream = Toolkit.class.getClassLoader()
      .getResourceAsStream("searchcfg.properties");
    try {
      params.load(inputStream);
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }

  public static String getParameter(String para)
  {
    return params.get(para) == null ? "" : (String)params.get(para);
  }

  public static String getTime()
  {
    return dformat.format(new Date());
  }

  public static void printInfo(String info, Exception e)
  {
    System.out.println(info);
    if (e != null) {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
  }

  public static Connection getConnection()
  {
    try
    {
      return DriverManager.getConnection(getParameter("db_url"), 
        getParameter("db_user"), 
        getParameter("db_password"));
    } catch (SQLException e) {
      printInfo("", e);
    }
    return null;
  }

  public static IDataProvider getDataProvider()
  {
    String dbtype = getParameter("db_type");
    if (dbtype.equals("mysql")) {
      return (IDataProvider) new MySqlDataProvider();
    }

    return new MySqlDataProvider();
  }
}