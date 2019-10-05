package shitSheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HtmlParser {
	
	public static void main(String[] args) {
		
		URL url;
		String html = "dnjs";
		
		try {
            // get URL content

            String a="https://stackoverflow.com/questions/5956627/python-universal-import";
            url = new URL(a);
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                    System.out.println(inputLine);
                    //html = html.concat(inputLine);
                    html = html + "\n" +  inputLine;
            }
            br.close();

            System.out.println("Done");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		String searchTerm = "class=\"question-hyperlink\"";
		int a = html.indexOf(">", html.indexOf(searchTerm));
		String title =  html.substring(a + 1, html.indexOf("<", a));
		int startIndex = html.indexOf("<div id=\"answers\">");
		String code = "";
		while (code.length() < 20) {
			startIndex = html.indexOf("<code>", startIndex);
			code = html.substring(startIndex + 6, html.indexOf("</code>", startIndex + 1));
			startIndex++;
		}
		System.out.println("titel: " + title);
		System.out.println(code);
	}

}
