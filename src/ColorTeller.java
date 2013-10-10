/* displayText.java 
 * update:monday night:
 * 
 * right now the thread is double iterating, problem with the arraylist and brackets
 * probably.
 *  I should make it quit after the 
 * first iteration. crawling multiple URLs sometimes halts the screen, I should 
 * avoid this by adding a timer to the crawling, if there is no response just 
 * let it go to the next one.
 * 
 * I should add the display in its own thread and trigger it according to separate
 * color threads. 
 */

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;


public class ColorTeller extends PApplet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// colorThread kt;
	ArrayList					threadlist;
	ArrayList					sentences;

	Line						lines[];
	PFont						f;
	String						myarray[];
	String						result[];
	public float				sizeOfText			= 200;
	int							flag;

	public StringBuffer			s;
	ArrayList					lineArrayList;
	ArrayList					secondArrayList;
	public boolean				search;
	
	ArrayList					temp;
	KolorBox					boxes[];
	String						colors[]			= {"black", "silver",
			"gray", "white", "maroon", "red", "purple", "fuchsia", "green",
			"lime", "olive", "yellow", "navy", "blue", "teal", "aqua"};

	

	 public static void main(String args[]) {
		    PApplet.main(new String[] { "--present", "ColorTeller" });
		  }
	 
	 
	 
	public void setup() {
		frameRate(1000);
		size(1440, 480, P3D);
		/* call this early in setup */
		boxes = new KolorBox[colors.length];
		f = loadFont("AndaleMono.vlw");
		textFont(f, sizeOfText);
		sentences = new ArrayList();
		threadlist = new ArrayList();
		lineArrayList = new ArrayList();
		temp = new ArrayList();
		String s = " dedede";
		temp.add(s);
		
		search = false;
		background(255);
		flag = 0;
	}

	public void draw() {
		
		if (lineArrayList.size() < 5) {
			//System.out.print(threadlist);
		//for (int m = threadlist.size() - 1; m >= 0; m--) {
			
		//	colorThread kt = (colorThread) threadlist.get(m);
			
			//if (kt.available()) {
				
				sentences = temp;
				//sentences = kt.getHeadlines();
				//System.out.print("sentences: " + sentences);
				
				if (sentences != null && sentences.size() > 0) {
				//	System.out.println("sentences.size -> " + sentences.size());
				//	System.out.println("sentences -> " + sentences);
					String cumle = (String) sentences.get((int) random(sentences.size()));
					myarray = cumle.split(" ");
					int index = 0;
					int groupnum = 30;
					int counter = 0;
					if (myarray.length % groupnum == 0) {
						result = new String[(myarray.length / groupnum)];
					} else {
						result = new String[(myarray.length / groupnum) + 1];
					}
					while (index < myarray.length) {
						String temp = "ilterisilterisilterisilterisilterisilt\nerisililterisilterisilteerisil\nterisilterisilter\nisilterisilterisilterisilteri\nsilterisilterisil\nterisilterisilterisiltersilterisilterisilterisisilterisil\nterisilterisilter\nisilterisilterisilterisil\nterisilterisilterisi\nlterisilterisilterisilterisiltersilterisilterisilte\nrisisilterisilterisilterisilterisilterisilterisilterisilterisilterisilterisilterisilterisilterisilterisilterisil\n\nterisilterisilterisilterisilterisilterisilterisilterisilterisilterisilterisilterisilterisilterisilterisilterisilterisilterisilterisilterisilteri\nsilterisilterisilterisilterisilterisilterisilterisilterisilteris";
						for (int i = 0; i < groupnum; i++) {
							if (index < myarray.length)
								temp += myarray[index] + " ";
							index++;
						}
						result[counter] = temp;
						counter++;
					}
					lineSystem linenow = new lineSystem( this, result);
					lineArrayList.add(linenow);
				}
				// System.out.println("Result.length -> " + result.length);
				// lines = new Line[result.length];
				// for (int i = 0; i < result.length; i++) {
				// lines[i] = new Line(kt.colorname, this, result[i], 0, i
				// * sizeOfText);

			//	kt.quit();
				flag = 0;
	//			threadlist.remove(m);
		//	}
		}
//	}

		background(180);
		buildBoxes();
		
		
		if (lineArrayList.size() > 0) {
			for (int v = lineArrayList.size()-1; v >= 0 ; v--) {
				lineSystem l = (lineSystem) lineArrayList.get(v);
				l.runLines();
				if (l.dead()) {
				  lineArrayList.remove(v);	

				}
			}
		}
		// counter

		// System.out.println(second());
		if (second() % 20 == 0 && flag == 0) {
			flag++;
			colorThread kt = new colorThread();
			kt.colorSend(boxes[(int) random(boxes.length)].returnColor());
			kt.start();
			threadlist.add(kt);
		}

	}

	public void mousePressed() {
		String s = null;
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i].checkPressed()) {
				s = boxes[i].returnColor();

			}
		}
		 colorThread kt = new colorThread();
		 kt.colorSend(s);
		 kt.start();
		 threadlist.add(kt);

	}

	void buildBoxes() {
		for (int i = 0; i < boxes.length; i++) {
			boxes[i] = new KolorBox(this, colors[i], new Vector3D(0,
					100 + (i * 20)));
		}
	}

}