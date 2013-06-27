package isearch.search;

import isearch.env.Environment;
import isearch.env.IDataProvider;
import isearch.env.InContainer;
import isearch.env.OutContainer;
import isearch.env.Toolkit;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.htmlparser.lexer.Page;

public class SearchThread extends Thread
{
  private boolean isContinue = true;
  private Connection conn;

  public SearchThread(Connection conn)
  {
    this.conn = conn;
  }

  public void stopRun() {
    this.isContinue = false;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
public void run() {
    StringBuffer content = new StringBuffer();
    String surl="";
    try {
      PreparedStatement ps = Toolkit.getDataProvider()
        .getInsertSearchIndexPS(this.conn);
      Page page = new Page();
      while (this.isContinue) {
        try {

           surl= Environment.getInstance().getOutContainer()
            .getURL();

          if (surl == null) {
            Thread.sleep(Integer.parseInt(
              Toolkit.getParameter("searchsleep")));
          }
          else {
            Toolkit.printInfo(surl, null);
            HttpURLConnection huc = (HttpURLConnection)new URL(surl)
              .openConnection();

            String encoding = huc.getContentEncoding();
            if ((encoding == null) || (encoding.equals("ISO-8859-1")))
              encoding = "GB2312";
            String ctype = huc.getContentType().toLowerCase();

            if (ctype.indexOf("text/html") == -1) {
              continue;
            }
            BufferedReader br = new BufferedReader(
              new InputStreamReader(huc.getInputStream(), 
              encoding));
            huc.connect();
            content.delete(0, content.length());
            String line;
            while ((line = br.readLine()) != null)
            {
//              String line;
              content.append(line);
            }
            Map hrefMap = new HashMap();
            Map srcMap = new HashMap();
            String scontent = content.toString();
            page.setBaseUrl(surl);

            Matcher hrefMatcher = 
              Pattern.compile("(href|HREF)=[^ <>]*").matcher(scontent);
            while (hrefMatcher.find())
              hrefMap.put(hrefMatcher.group(), "");
            String alink;
            for (Object mapurl : hrefMap.keySet()) {
              if (mapurl.toString().toLowerCase().indexOf("javascript:") > -1)
                continue;
              alink = page.getAbsoluteURL(mapurl
            		  .toString().substring("href='".length(), mapurl.toString().length() - 1));
              scontent = scontent.replaceAll(mapurl.toString(), 
                mapurl.toString().substring(0, 6) + 
                alink + mapurl.toString().charAt(mapurl.toString().length() - 1));

              if (isValidURL(alink)) {
                Environment.getInstance().getInContainer().setURL(
                  alink);
              }
            }

            Matcher srcMatcher = Pattern.compile("(src|SRC)=[^ <>]*")
              .matcher(scontent);
            while (srcMatcher.find()) {
              srcMap.put(srcMatcher.group(), "");
            }
            for (Object mapurl : srcMap.keySet()) {
               alink = page.getAbsoluteURL(mapurl.toString().substring("src='".length(), mapurl.toString().length() - 1));
              scontent = scontent.replaceAll(mapurl.toString(), 
                mapurl.toString().substring(0, 5) + 
                alink + mapurl.toString().charAt(mapurl.toString().length() - 1));
            }

            huc.disconnect();

            Matcher titleMatcher = Pattern.compile(
              "<(title|TITLE)>.*</(title|TITLE)>").matcher(
              content.toString());
            ps.setString(1, surl);
            ps.setString(2, scontent);
            System.out.println("======================"+scontent);
            ps.setString(3, Toolkit.getTime());
            ps.setString(4, titleMatcher.find() ? 
              titleMatcher.group().replaceAll("<(|/)title>", "") : "");
            ps.setString(5, 
              scontent.replaceAll("<script[^<>]>.*</script>", "")
              .replaceAll("<[^<>]*>", ""));
            ps.execute();
            System.gc();
          }
        } catch (Exception e) {
          Toolkit.printInfo("search error", e);
        }
      }
      this.conn.close();
    } catch (Exception e) {
      Toolkit.printInfo("search error", e);
    }
  }

  private boolean isValidURL(String url)
  {
    if ((url == null) || (url.indexOf("www.w3.org") > -1) || 
      (url.indexOf(Toolkit.getParameter("searchdomain")) == -1)) {
      return false;
    }
    String[] suffix = Toolkit.getParameter("unsuffix").split(";");
    for (String s : suffix) {
      if (url.toLowerCase().endsWith(s))
        return false;
    }
    return true;
  }
}