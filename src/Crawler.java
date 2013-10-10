/* Crawler.java 
 * Created on Apr 12, 2006 
 */


import java.io.IOException;
import java.util.*;

public class Crawler {
	
	ArrayList tempArrayList;
	public HashMap		urlsVisited;
	public LinkedList	urlsToVisit;
	public String		word;
	public Crawler(LinkedList urls, String word_) {
		urlsToVisit = urls;
		urlsVisited = new HashMap();
		String words[] = word_.split(" "); // change red to color
		word = words[0]; //+ " " + words[1]; // here.
		
		 tempFunc();
		tempArrayList = new ArrayList();
	}

	public void tempFunc() {
		// System.out.println(urlsToVisit);
	}

	public boolean queueEmpty() {
		return urlsToVisit.isEmpty();
	}

	public ArrayList read() throws IOException {
		String urlpath = (String) urlsToVisit.removeFirst();
		
		UrlReader urlr = new UrlReader(urlpath);
		String stuff = urlr.getContent();

		SearchText content = new SearchText(stuff);
		tempArrayList = content.spitSentences(word);
		/*
		 *  TODO we should change this behavior and run a thread for each URL
		 */
		
		addUrlVisited(urlpath);
		return tempArrayList;
	}

	private void addUrlVisited(String urlpath) {
		urlsVisited.put(urlpath, urlpath);

	}

}