/* lineSystem.java 
 * Created on May 9, 2006 
 * by ilteris
 */


import processing.core.PApplet;

public class lineSystem {
	Line			lines[];
	String			result[];
	String			colorname;
	PApplet			p;
	public float	sizeOfText	= 20;
	public boolean avail;
	
	
	
	float theta;
	
	
	public lineSystem(PApplet p_, String result_[]) {
		result = result_;
		colorname = "green";
		lines = new Line[result.length];
		p = p_;
		theta = p.random(-80,80);
		for (int i = 0; i < result.length; i++) {
			lines[i] = new Line(theta, colorname, p, result[i], 0, i * sizeOfText+50);
			
		}
		
	}
	public void runLines() {
		
		for (int i = 0; i < result.length; i++) {
			lines[i].run();
		}
	}
	
	public boolean returnAvail() {
		return avail;
	}
	
	public boolean dead() {
		int totalDead = 0;
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].dead()) {
				totalDead++;
			}
		}
		
		if (totalDead >= lines.length) return true;
		else return false;
	}

}	