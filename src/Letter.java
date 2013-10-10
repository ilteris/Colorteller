

import processing.core.PApplet;

/* Letter.java 
 * Created on Apr 14, 2006 
 */

public class Letter {
	char		myChar;
	Vector3D	loc;
	Vector3D	desLoc;
	Vector3D	vel, acc;
	float		timer;
	PApplet		p;
	private boolean	moveback;
	String color;
	
	

	public Letter(String colorname_, PApplet p_, char c, Vector3D loc_, Vector3D desLoc_) {
		desLoc = desLoc_;
		myChar = c;
		loc = loc_;
		p = p_;

		color = colorname_;
		acc = new Vector3D(0, (float) 0.5, 0);
		vel = new Vector3D(p.random(-4, 4), p.random(-2, 0), 0);
		timer = 30.0f;
		moveback = false;
	}

	public void run() {
		timer--;
		goPath(desLoc); // finding each other with the midst of the app
		update();
		render();
		

	}

	public void goPath(Vector3D v1) {
		Vector3D v = Vector3D.sub(v1, loc);
		float dist = Vector3D.distance(v1,loc);
		if(dist>1) {
		v.normalize();
		v.mult(2);
		v.add(acc);
		loc.add(v);
                
		} else {
			moveback = true;
			
		}
		
	}

	public void update() {
		if (moveback && timer <-300) { // checks if the letters are in place
			vel.add(acc);
			loc.add(vel);
		}

	}

	void render() {
		
		if(color == "black") 		p.fill(0,0,0,255-timer);
		if(color == "silver") 	p.fill(192,192,192,255-timer);
		if(color == "white") 		p.fill(255,255,255,255-timer);
		if(color == "maroon")	   	p.fill(128,0,0,255-timer);
		if(color == "red")		p.fill(255,0,0,255-timer);
		if(color == "purple")		p.fill(128,0,128,255-timer);
		if(color == "fuchsia") 	p.fill(255,0,255,255-timer);
		if(color == "green") 		p.fill(0,128,0,255-timer);
		if(color == "lime") 		p.fill(0,255,0,255-timer);
		if(color == "olive") 		p.fill(128,128,0,255-timer);
		if(color == "yellow") 	p.fill(255,255,0,255-timer);
		if(color == "navy") 		p.fill(0,0,128,255-timer);
		if(color == "blue") 		p.fill(0,0,255,255-timer);
		if(color == "teal") 		p.fill(0,128,128,255-timer);
		if(color == "aqua") 		p.fill(0,255,255,255-timer);//
		// p.fill(255-timer,200,100,255-timer);
		 p.textSize(10);
		 
		p.text(myChar, loc.x-p.width/2, loc.y);

		// TODO display char here!
		// how about text is here"
		// loc.x, loc.y;
	}
	boolean dead() {
		if (loc.y > p.height+50) {
			return true;
		} else {
			return false;
		}
	}

}