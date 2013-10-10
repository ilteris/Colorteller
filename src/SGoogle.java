///* main.java 
// * Created on Apr 12, 2006 
// */
//
//
//import java.util.ArrayList;
//
//import com.google.soap.search.GoogleSearchFault;
//
//public class SGoogle {
//	ArrayList	tempArrayList;
//	public SGoogle(String search) {
//
//		SearchGoogle session = new SearchGoogle(
//				"C+zZ7UZQFHLNOyUNUCT2uphJ3a6WxQZF");
//
//		try {
//
//			session.init(search);
//			tempArrayList = session.returnHere();
//		} catch (GoogleSearchFault e) {
//
//			e.printStackTrace();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		// this string is going to be the actual color names that
//		// are gathered from the RGB values.
//
//	}
//
//	public ArrayList returnSentences() {
//		return tempArrayList;
//		
//	}
//
//}