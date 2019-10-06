package shitSheet;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HtmlParser {
	
	static String getDivContent(String html, String searchTerm) {
		int startIndex = html.indexOf(searchTerm);
		int endIndex = startIndex;
		String code = "";
		int divLayer = 0;
//		System.out.println(endIndex);
		while (divLayer != -1) {
			endIndex = html.indexOf("div", endIndex + 1);
			divLayer += html.charAt(endIndex - 1) == "<".charAt(0) ? 1 : -1;
			//System.out.println(divLayer);
		}
//		System.out.println(endIndex);
		html = "<" + html.substring(startIndex, endIndex - 2);
		return html;
	}
	
	String parse(URL url) {
		
		String html = "";
		
		try {
            // get URL content
//			System.out.println("https://stackoverflow.com/questions/5956627/python-universal-import\n");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		    String a = br1.readLine();
//            String a="https://stackoverflow.com/questions/5956627/python-universal-import";
            
            url = new URL(a);
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                    html = html + "\n" +  inputLine;
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		String searchTerm = "class=\"question-hyperlink\"";
		int a = html.indexOf(">", html.indexOf(searchTerm));
		String title =  html.substring(a + 1, html.indexOf("<", a));
		html = getDivContent(getDivContent(html, "class=\"answer accepted-answer\""), "div class=\"post-text\" itemprop=\"text\">");
		return title + "<|>" + html;
	}
	
	public static void main(String[] args) {
		
		URL url;
		String html = "";
		
		try {
            // get URL content
//			System.out.println("https://stackoverflow.com/questions/5956627/python-universal-import\n");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		    String a = br1.readLine();
//            String a="https://stackoverflow.com/questions/5956627/python-universal-import";
            
            url = new URL(a);
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                    html = html + "\n" +  inputLine;
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		String searchTerm = "class=\"question-hyperlink\"";
		int a = html.indexOf(">", html.indexOf(searchTerm));
		String title =  html.substring(a + 1, html.indexOf("<", a));
//		System.out.println("titel: " + title);
		
		System.out.println(getDivContent(getDivContent(html, "class=\"answer accepted-answer\""), "div class=\"post-text\" itemprop=\"text\">"));
	}

}
