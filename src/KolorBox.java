/* Kolor.java 
 * Created on Apr 15, 2006 
 */



import processing.core.PApplet;
import processing.core.PConstants;

public class KolorBox {
	PApplet		p;
	String		color;
	Vector3D	loc;
	public boolean	pressed;
	public KolorBox(PApplet p_, String color_, Vector3D loc_) {
		p = p_;
		color = color_;
		loc = loc_;
		pressed = false;
		convertNamestoColors(color);
		buildBox();
		
	}

	
	public void convertNamestoColors(String color) {
		
		if(color == "black") 		p.fill(227,239,250);
		if(color == "silver") 		p.fill(203,239,250)	;
		if(color == "white") 		p.fill(160,239,250);
		if(color == "maroon")	   p.fill(120,239,250);
		if(color == "red")		p.fill(80,239,250);
		if(color == "purple")		p.fill(50,239,250);
		if(color == "fuchsia") 	p.fill(120,239,250);
		if(color == "green") 		p.fill(100,239,250);
		if(color == "lime") 		p.fill(40,239,250);
		if(color == "olive") 		p.fill(128,128,0);
		if(color == "yellow") 	p.fill(255,255,0);
		if(color == "navy") 		p.fill(0,0,128);
		if(color == "blue") 		p.fill(0,0,255);
		if(color == "teal") 		p.fill(0,128,128);
		if(color == "aqua") 		p.fill(0,255,255);
	}
		
		
		
	public void buildBox() {
		p.rectMode(PConstants.CENTER);
		// p.rect(loc.x, loc.y, 20, 20);
	}

	public String returnColor() {
		String c = color;
		return c;
	}

	public boolean  checkPressed() {
		float d = PApplet.dist(p.mouseX,p.mouseY,loc.x,loc.y);
		if(d > 10) return false;
		else 
		return true;
	}


	
	

}