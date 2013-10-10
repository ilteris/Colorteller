
/* Line.java 
 * Created on Apr 14, 2006 
 */

import processing.core.PApplet;

public class Line {

	PApplet			p;
	public float	y;
	public float	x;
	public Letter	myLetters[];
	String			string;
	String colorname;
	float theta;
	
	String						colors[]			= {"black", "silver",
			"gray", "white", "maroon", "red", "purple", "fuchsia", "green",
			"lime", "olive", "yellow", "navy", "blue", "teal", "aqua"};
	
	
	

	public Line(float theta_, String colorname_, PApplet p_, String string_, float i, float j) {
		p = p_;
		x = i;
		y = j;
		colorname = colorname_;
		string = string_;
		
		theta = theta_;
		
		
		myLetters = new Letter[string.length()];
		String s = string.toUpperCase();
		float textWidth = p.width-p.textWidth(s)/2+0;
		for (int k = 0; k < s.length(); k++) {
			char c = s.charAt(k);

			textWidth += p.textWidth(c);
			// this is a way to get the actual places
			// that they should be right! the y axis is constant.
			// System.out.println(textWidth);
			
			
			Letter letter = new Letter(colors[(int)p.random(8, 10)], p, c, new Vector3D(p.random(p.width), p
					.random(p.height)), new Vector3D(textWidth, 0));
			myLetters[k] = letter;

		}

	}
	
	public boolean dead() {
		int totalDead = 0;
		for (int k = 0; k < myLetters.length; k++) {
			if (myLetters[k].dead()) {
			  totalDead++;
			}
		}
		if (totalDead >= myLetters.length) return true;
		else return false;
	}

	public void run() {
		

		for (int k = 0; k < string.length(); k++) {
			p.pushMatrix();
			p.translate(p.width/2,y,0);
			p.rotateY(PApplet.radians(theta));
			myLetters[k].run();
			p.popMatrix();
		}
	}
	
	

}