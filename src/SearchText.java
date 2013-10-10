/* SearchText.java 
 * Created on Apr 12, 2006 
 */

import java.util.*;

public class SearchText {
	ArrayList<String> currents = new ArrayList<String>();
	private String	stuff;
	public SearchText(String stuff_) {
		stuff = stuff_;

	}

	public ArrayList<String> spitSentences(String word_) {
		String word = word_;
		String noHTMLString = stuff.replaceAll("\\<.*?\\>", "");
		noHTMLString = noHTMLString.replaceAll("&raquo;", "");
		noHTMLString = noHTMLString.replaceAll("&nbsp;", "");
		noHTMLString = noHTMLString.replaceAll("&.*?;", "");

	

		String sentenceDelim = ".?!";
		StringTokenizer sentenceTokenizer = new StringTokenizer(noHTMLString,
				sentenceDelim);
		// System.out.println(sentences);
		while (sentenceTokenizer.hasMoreTokens()) {
			String current = sentenceTokenizer.nextToken();
			if(current.indexOf(word) != -1) {
				
			// System.out.println(current+".");
			 String temp = current + ".";
			 currents.add(temp);
			}
			// TODO copy this arraylist to somwhere else before it gets reset?
			
			 // System.out.println(current);

		}
		
		// System.out.println(a.size());
		return currents;
	}

}