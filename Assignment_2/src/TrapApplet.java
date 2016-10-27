
import java.awt.*;
import java.applet.Applet;



public class TrapApplet extends Applet{
	public  void printIt(Shape s) {
		if (!paintCalled) 
			System.out.println(s);
	}
	public  void printIt(String st) {
		if (!paintCalled) System.out.println(st);
	}
	boolean paintCalled = false;
	
	public void init() {
		this.setBackground(new Color(170,255,250));
	}
	public void paint(Graphics g) {
	
		Shape t = new Trapezoid(500,50,-10,60,100);

		t.drawShape(g);
		printIt(t);

		printIt(t.getX() + ", " + t.getY() + ", " + t.getWidth() 
		+ ", " + t.getHeight() + ", " + ((Trapezoid) t).getTopWidth() 
		+ ", " +  t.getArea() + ", " + t.getPerimeter() 
		+ ", "  + ((Trapezoid) t).getLeg() + ", " +	t.getType()  );

		
		t.moveBy(60, 60);	
		((Trapezoid) t).setTopWidth(50);
		t.drawShape(g);
		printIt(t);		
		
		t.moveBy(60, 60);
		((Trapezoid) t).setTopWidth(70);
		t.drawShape(g);
		printIt(t);
		
		t.moveBy(60, 60);
		t.setWidth(40);
		t.drawShape(g);
		printIt(t);
		
		t.moveBy(60, 60);
		((Trapezoid) t).setTopWidth(600);
		t.drawShape(g);
		printIt(t);
		
		t.moveBy(60, 60);
		t.setWidth(77);
		t.drawShape(g);
		printIt(t);
		
		t.moveBy(60,60);
		((Trapezoid) t).setTopWidth(-4);
		t.drawShape(g);
		printIt(t);
		
		t.moveBy(60, 60);
		t.setWidth(100);
		t.drawShape(g);
		printIt(t);
		
		t.moveBy(60, 60);
		((Trapezoid) t).setTopWidth(300);
		t.drawShape(g);
		printIt(t);
		
		t = new Trapezoid(-3,40,10,400,100);
		t.drawShape(g);
		printIt(t);
		
		t.moveBy(60, 60);
		t.setWidth(200);
		t.drawShape(g);
		printIt(t);
		
		t.moveBy(60, 60);
		((Trapezoid) t).setTopWidth(t.getWidth());
		t.drawShape(g);
		printIt(t);
		
		t.moveBy(60, -60);
		t.setWidth(50);
		t.drawShape(g);
		printIt(t);
		
		t = new Trapezoid(1,-1,20,500,100);
		t.drawShape(g);
		printIt(t);
		
		t = new Trapezoid(6,1,6,530,100);
		t.drawShape(g);
		printIt(t);
		 
		t = new Oval(10,10, 100, 40);
		t.drawShape(g);
		printIt(t);
		
		t = new Triangle(20, 30, 115, 40);
		t.drawShape(g);
		printIt(t);
		
		t = new Square(10, 130, 40);
		t.drawShape(g);
		printIt(t);
		
		t = new Rectangle(30, 10, 160, 40);
		t.drawShape(g);
		printIt(t);
		
		t = new Triangle(30, 10, 190, 40);
		t.drawShape(g);
		printIt(t);
		
		t = new Triangle(100, 40, 260, 40);
		t.drawShape(g);
		printIt(t);
		
		paintCalled = true;
		
	}

}

