/* colorThread.java 
 * Created on Apr 15, 2006 
 */


import java.util.ArrayList;




public class colorThread extends Thread {
	private boolean		running;
	private int			wait;
	private ArrayList	headlines;
	private boolean		available;
	public String		colorname;
	String				predefined[]	= {"is the color of", "represents",
			"signifies", "suggests", "combines", "is considered", "conveys",
			"means", "evokes", "gives the feeling", "provides"};

	public boolean		colorSent;
	
	private final String HTTP_REFERER = "http://www.example.com/";
	
	
	public colorThread() {

		running = false;
		available = false;
		headlines = new ArrayList();
		colorname = new String();
		colorSent = false;
		wait = 1000;
	}

	public void start() {
		running = true;
	//	System.out.println("Starting thread");
		super.start();
	}

	public void run() {
		check();

		while (running) {
			try {
				sleep((long) (wait));
			} catch (Exception e) {
			}
		}
	}

	public void quit() {

		running = false;
		super.interrupt();
	}

	public boolean available() {
		return available;
	}

	public  ArrayList getHeadlines() {
		available = false;
		return headlines;
	}

	public void colorSend(String color) {
		colorname = color;
		colorSent = true;

	}
	private void check() {
		
//			SGoogle search = new SGoogle(colorname + " " + "color" + " "
//					+ predefined[(int) (Math.random() * predefined.length)]);
//			headlines = search.returnSentences();
//			available = true;
//		
	}
}