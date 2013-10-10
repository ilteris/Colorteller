//
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.LinkedList;
//
//import com.google.soap.search.*;
//
//public class SearchGoogle {
//	private GoogleSearch	googlesearch;
//	ArrayList				tempArrayList;
//	ArrayList				returnList;
//
//	public SearchGoogle(String key) {
//		googlesearch = new GoogleSearch();
//		googlesearch.setKey(key);
//		tempArrayList = new ArrayList();
//		returnList = new ArrayList();
//	}
//
//	public void init(String word) throws GoogleSearchFault, Throwable {
//
//		crawlLinks(searchString(word), word);
//
//	}
//
//	public LinkedList searchString(String word) throws GoogleSearchFault,
//			Throwable {
//
//		googlesearch.setQueryString(word);
//
//		googlesearch.setStartResult((int) (Math.random() * 10));
//		GoogleSearchResult googlesearchresult = googlesearch.doSearch();
//		GoogleSearchResultElement results[] = googlesearchresult
//				.getResultElements();
//		LinkedList urls = new LinkedList();
//		int i = 0;
//
//		while (i < 1) {
//			String url = results[i].getURL();
//			urls.add(url);
//			// System.out.println("url: " + url);
//			i++;
//
//		}
//		return urls;
//
//	}
//
//	/*
//	 * TODO if we are going to open a new thread for every new link it is going
//	 * to be done here!
//	 * 
//	 * 
//	 */
//
//	public void crawlLinks(LinkedList a, String word) {
//		Crawler crawler = new Crawler(a, word);
//		int count = 0;
//		int limit = 100;
//
//		while (!crawler.queueEmpty()) {
//			try {
//
//				tempArrayList = crawler.read();
//				int counter = tempArrayList.size();
//				if (tempArrayList.size() > 0) {
//					for (int i = 0; i < counter; i++) {
//						returnList.add(tempArrayList.get(i));
//					}
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//			count++;
//			if (count > limit)
//				break;
//		}
//		if (count < limit) {
//
//		} else {
//
//		}
//
//	}
//
//	public ArrayList returnHere() {
//		return returnList;
//	}
//
//}