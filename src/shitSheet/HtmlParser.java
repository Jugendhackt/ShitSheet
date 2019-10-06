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
                    //System.out.println(inputLine);
                    //html = html.concat(inputLine);
                    html = html + "\n" +  inputLine;
            }
            br.close();

            //System.out.println("Done");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		String searchTerm = "class=\"question-hyperlink\"";
		int a = html.indexOf(">", html.indexOf(searchTerm));
		String title =  html.substring(a + 1, html.indexOf("<", a));
//		int startIndex = html.indexOf("<div id=\"answers\">");
		int startIndex = html.indexOf("class=\"answer accepted-answer\"");
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
		startIndex = html.indexOf("div class=\"post-text\" itemprop=\"text\">");
		endIndex = startIndex;
		code = "";
		divLayer = 0;
//		System.out.println(endIndex);
		while (divLayer != -1) {
			endIndex = html.indexOf("div", endIndex + 1);
			divLayer += html.charAt(endIndex - 1) == "<".charAt(0) ? 1 : -1;
			//System.out.println(divLayer);
		}
		html = "<" + html.substring(startIndex, endIndex - 2);
//		System.out.println(endIndex);
//		while (code.length() < 20) {
//			startIndex = html.indexOf("<code>", startIndex);
//			code = html.substring(startIndex + 6, html.indexOf("</code>", startIndex + 1));
//			startIndex++;
//		}
//		System.out.println("titel: " + title);
		
		System.out.println(html);
	}

}
