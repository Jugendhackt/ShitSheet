package shitSheet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SheetShitter {

	public static void main(String[] args) {
		Path file = Paths.get("/home/noah/Documents/Jugend Hackt/ShitSheet/Musterdateien/links.json");
		Path shitSheet = Paths.get("/home/noah/Documents/Jugend Hackt/ShitSheet/shitSheet.html");
		List<String> fileArray = new ArrayList<>();
		try {
			fileArray = Files.readAllLines(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String s = "<div align=\"right\" style=\"background: #0F0F0F; \">";
		for (int i = 1; i < fileArray.size() - 1; i++) {
			System.out.println(i);
			String entry = "";
			try {
				entry = HtmlParser.parse(new URL(fileArray.get(i).split("\"")[1]));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(entry.split("<\\|>").length >= 2) {
				s = s + " <div align=\"left\" style=\"color: #EEEEEE; text-shadow: 2px 1px #555555; font-size: 30px\";> " + entry.split("<\\|>")[0] + " </div> " + " <div align=\"left\" style=\"background: #0F0F0F; color: #BBBBBB; width: 90%;\"> " + entry.split("<\\|>")[1] + " </div> </div> ";
			}
			//System.out.println(i + entry.split("\\|")[1]);
			
		}
			
		
		s = s + " </div> ";
		//s = s.replaceAll("\"", "penis");
		//System.out.println(s);
		Charset charset = Charset.forName("UTF-8");
		try (BufferedWriter writer = Files.newBufferedWriter(shitSheet, charset)) {
		    writer.write(s, 0, s.length());
			System.out.println(s.length());
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}

}
