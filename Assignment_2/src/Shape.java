/*
    Andrew Kim
    Assignment 2
    October 18th, 2016
 */

import java.awt.*;


public class Shape {
	protected int width, height, xCoordinate, yCoordinate;
	protected Color c;

	
	public static final int 
		MAX_X = 1000, MAX_Y = 1000,  // max for xCoordinate, yCoordinate
		MAX_WIDTH = 100, MAX_HEIGHT = 100, // max for width and height
		MIN_WIDTH = 2,   MIN_HEIGHT = 2; // min for width and height
	
	
	public Shape() {
		this(MIN_WIDTH,MIN_HEIGHT);
	}
	
	public Shape(int width, int height) {
		this(width,height,0,0);
	}
	
	public Shape(int width, int height, int xCoordinate, int yCoordinate) {
		setWidth(width);
		setHeight(height);
		setX(xCoordinate);
		setY(yCoordinate);
		this.c = Color.BLACK;
	}
	public void setWidth(int width) {
		this.width = Math.min(Math.max(MIN_WIDTH ,width), MAX_WIDTH);
	}
	public void setHeight(int height) {
		this.height = Math.min(Math.max(MIN_HEIGHT,height), MAX_HEIGHT);
	}
	
	public void setX(int x) {
		xCoordinate = Math.min( Math.max(x,0), MAX_X);
	}
	public void setY(int y) {
		yCoordinate = Math.min( Math.max(y,0), MAX_Y);
	}
	
	public int getX() {
		return xCoordinate;
	}
	public int getY() {
		return yCoordinate;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setColor(int red, int green , int blue) {
		Color temp = new Color(red % 256, green % 256, blue % 256);
		c = temp;
	}
	
	public int getArea() {
		return width * height;
	}
	
	public int getPerimeter() {
		return 2*width + 2*height;
	}
	
	public void drawShape(Graphics g) {
		g.drawRect(xCoordinate-width/2,yCoordinate-height/2,width,height);
	}
	
	public void moveBy(int dx, int dy) {
		setX(xCoordinate +dx);
		setY(yCoordinate + dy);
	}
	
	public String getType() 
	{
		return "Shape";
	}
	
	public String toString() {
		String c = "Coord:  (" + xCoordinate  + "," +yCoordinate+ ")";
		String d = "Dimen: (" + width  + "," + height + ")";
		String a = "Area = " + getArea();
		String p = "Perim = " + getPerimeter();
		return c + ", " + d + ", " + a +  ", " + p + ", Type = " + getType();
	}

}





class Rectangle extends Shape {
	
	public Rectangle() {
		super();
		
	}
	
	public Rectangle(int width, int height) {
		super(width, height);
	}
	
	
	public Rectangle(int width, int height, int xCoordinate, int yCoordinate) {
		super(width, height, xCoordinate, yCoordinate);
	}
	
	public String getType() 
	{
		return super.getType() + "\\Rectangle";
	}
}





class Triangle extends Shape{
	public Triangle() {
		super();
		
	}
	
	public Triangle(int width, int height) {
		super(width, height);
	}
	
	
	public Triangle(int width, int height, int xCoordinate, int yCoordinate) {
		super(width, height, xCoordinate, yCoordinate);
	}
	
	public int getArea() {
		return super.getArea()/2;
	}
	// to return length of one of the congruent legs.
	public int getLeg() {
		int halfWidth = width/2;
		return (int) Math.round( Math.sqrt(1.0*height*height + halfWidth*halfWidth));
	}
	public int getPerimeter() {
		int leg = getLeg();
		return width + 2*leg;  // it's an isosceles triangle
	}
	
	// draw an isosceles triangle with base = width and altitude = height
	// xCoordinate and yCoordinate should correspond to the midpoint of the altitude
	public void drawShape(Graphics g)
        {
            double a = width / 2.0;
            a = a + 0.5;
            int p = (int)a;
            int []xcoord = new int[] {xCoordinate - p, xCoordinate, xCoordinate + p};
            int []ycoord = new int[] {yCoordinate + height / 2, yCoordinate - height / 2, yCoordinate + height / 2};
            g.drawPolygon(xcoord, ycoord, 3);
	}
	
	public String getType() 
	{
		return super.getType() + "\\Triangle";
	}


}





class Oval extends Shape {
	public Oval() {
		super();
		
	}
	
	public Oval(int width, int height) {
		this(width,height,0,0);
	}
	
	
	public Oval(int width, int height, int xCoordinate, int yCoordinate) {
		super(width, height, xCoordinate, yCoordinate);
	}
	
	
	public int getArea() {
		return (int) Math.round(Math.PI*width*height / 4);
	}
	public int getPerimeter() {
		// approximate perimeter of an ellipse
		return (int) Math.round(Math.PI * Math.sqrt((width*width+height*height)/2.0));
	
	}
	public void drawShape(Graphics g) {
		g.drawOval(xCoordinate-width/2, yCoordinate-height/2, width, height);
	}
	
	public String getType() 
	{
		return super.getType() + "\\Oval";
	}
	

}


class Square  extends Rectangle{
	
	public Square () {
		super();
		setWidth(getHeight()); // to ensure width == height
	}
	
	public Square (int side) {
		super(side,side);
	}
	
	
	public Square (int side, int xCoordinate, int yCoordinate) {
		super(side,side, xCoordinate, yCoordinate);
	}
	public void setSide(int side) {
          setWidth(side);
   	}
    	public int getSide() {
          return width;
    	}
	public void setWidth(int width) {
		super.setWidth(width);
		super.setHeight(width); 
	}
	public void setHeight(int height) {
		setWidth(height) ;
	}
	
	public String getType() 
	{
		return super.getType() + "\\Square";
	}
	
}

class Trapezoid  extends Shape {
	public static int MIN_BOTTOM_WIDTH = 4, MIN_TOP_WIDTH = 2;  // Notice MIN_WIDTH is shadowing Shape.MIN_WIDTH
	private int topWidth;
	
	// Create a Trapezoid with the minimal trapezoid dimensions.
	// Call the two parameter constructor in the superclass to do initialization of width and height
	// Then initialize topWidth by calling setter.
	public Trapezoid ()
        {
            super();
            this.setTopWidth(MIN_TOP_WIDTH);
	}
	
	// Call the five parameter constructor of Trapezoid. One line of code only.
	public Trapezoid(int width, int height, int topWidth)
        {
            this(width, height, topWidth, 0, 0);
	}
	
	// Call the four-parameter superclass constructor with the max of width and MIN_BOTTOM_WIDTH as first argument. 
	// Then initialize topWidth by calling setter.
	public Trapezoid (int width, int height, int topWidth, int xCoordinate, int yCoordinate)
        {
            super(Math.max(width, MIN_BOTTOM_WIDTH), height, xCoordinate, yCoordinate);
            //this.setTopWidth(MIN_TOP_WIDTH);
            this.setTopWidth(topWidth);
	}
	
	// 	Set this.topWidth to topWidth if topWidth is within allowed range.
	//  Allowed range means >= MIN_TOP_WIDTH and <= width-2. (Our trapezoids must have topWidth smaller than the width.)
	public void setTopWidth(int topWidth) 
        {
            if(topWidth >= MIN_TOP_WIDTH && topWidth <= width - 2)
            {
                this.topWidth = topWidth;
            }
            else if(topWidth < 0)
            {
                this.topWidth = MIN_TOP_WIDTH;
            }
            else
            {
                this.topWidth = Math.max(width - 2, MIN_TOP_WIDTH);
            }
    	}
	
	// return the top width
    	public int getTopWidth() 
        {
            return topWidth;
    	}
    
    	// set the width, by calling superclass setter
    	// Then set topWidth again to make sure it's within range.
	public void setWidth(int width)
        {
            super.setWidth(width);
            this.setTopWidth(topWidth);
	}

	// Return a string with information about the object. 
	// Look at the sample output to see what information is displayed and in what format.
	// Make sure to call getType() as in toString for the other classes.
	public String toString()
        {
            String c = "Coord:  (" + xCoordinate  + "," +yCoordinate+ ")";
            String d = "Dimen: (" + width  + "," + height + "," + topWidth + ")";
            String a = "Area = " + getArea();
            String p = "Perim = " + getPerimeter();
            String b = "Leg = " + getLeg();
            return c + ", " + d + ", " + a +  ", " + p + ", " + b + ", Type = " + getType();
	}
	
	// Draw the trapezoid so it looks like an isosceles Triangle with truncated top. 
	// That means the top will be centered so that its midpoint is directly above the midpoint of the bottom.
	public void drawShape(Graphics g)
        {
            double a = (width - topWidth) / 2.0;
            a = a + 0.5;
            int p = (int)a;
            int[] xcoord = new int[] {xCoordinate - width / 2, xCoordinate - topWidth / 2, xCoordinate + topWidth / 2, xCoordinate + width / 2};
            int[] ycoord = new int[] {yCoordinate + height / 2, yCoordinate - height / 2, yCoordinate - height / 2, yCoordinate + height / 2};
            g.drawPolygon(xcoord, ycoord, 4);
	}
	
	// The area of a trapezoid is the height multiplied by the sum of top and bottom widths, all divided by 2.
	public int getArea()
        {
            double area = ((width + topWidth) / 2.0) * height;
            //Round
            area = area + 0.5;
            return (int)area;
	}
	
	// Use the Pythagorean formula.
	// Do calculations using floating point arithmetic, then round to nearest int.
	// Make sure your values match sample output.
	public int getLeg()
        {
            double a = (width - topWidth) / 2.0;
            double leg = Math.sqrt((a * a) + (height * height));
            //Round
            leg = leg + 0.5;
            return (int)leg;
	}
	
	// Add topWidth, width and twice the length of each leg.
	// Make sure your values match sample output.
	public int getPerimeter()
        {
            int perimeter = topWidth + width + (2 * getLeg());
            return perimeter;
	}
	
	// Return a string with the type. 
	// It will be "Shape\Trapezoid" but you should construct the string by calling the superclass getType().
	public String getType() 
	{
		return super.getType() + "\\Trapezoid";
	}
	

}