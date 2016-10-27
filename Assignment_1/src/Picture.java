/*
    Andrew Kim
    Intro Obj Orient Prog & Design
    Week 1 - September 26
    Assignment 1 - Due October 2
 */

//System Libraries
import java.applet.*;
import java.awt.*;

public class Picture extends Applet
{
    
    public void init()
    {
        //Sky Blue Background   
        //this.setBackground(new Color(0, 128, 255));
    }
    public void paint(Graphics g)
    {
        g.fillRect(0, 0, 800, 600);
        //Borders of the Window
        g.drawRect(0, 0, 800, 600);
        //Land - Color Green
        g.setColor(new Color(0, 255, 0));
        g.fillRect(0, 350, 800, 250);
        //House - Body
        g.drawRect(100, 400, 200, 150);
        g.setColor(new Color(255 ,204, 153));
        g.fillRect(100, 400, 200, 150);
        //House - Door
        g.setColor(new Color(102, 51, 0));
        g.fillRect(150, 500, 50, 50);
        g.setColor(new Color(0, 0, 0));
        g.fillOval(180, 525, 10, 10);
        //House - Caption
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("House", 150, 475);
        //Tree - Trunk
        g.setColor(new Color(51, 25, 0));
        g.fillRect(350, 300, 50, 250);
        //Tree - Leaves
        g.setColor(new Color(0, 102, 0));
        g.fillOval(350, 300, 100, 100);
        g.fillOval(300, 300, 100, 100);
        g.fillOval(275, 250, 100, 100);
        g.fillOval(325, 250, 100, 100);
        //Tree - Caption
        g.setColor(new Color(0, 0, 0));
        g.drawString("Tree", 350, 375);
        //Moon
        g.setColor(new Color(255, 255, 255));
        g.fillOval(500, 30, 100, 100);
        g.setColor(new Color(0, 0, 0));
        g.fillOval(500, 30, 75, 75);
        //Moon - Caption
        g.setColor(new Color(0, 0, 0));
        g.drawString("Moon", 525, 75);
        //Stars - 5 Points
        g.setColor(new Color(255, 255, 255));
        int []xstar1 = new int[] {50,75,0,100,15};
        int []ystar1 = new int[] {60,110,80,80,110};
        g.fillPolygon(xstar1, ystar1, 5);
        //
        int []xstar4 = new int[] {450, 475, 400, 500, 415};
        int []ystar4 = new int[] {160, 210, 180, 180, 210};
        g.fillPolygon(xstar4, ystar4, 5);
        //
        int []xstar5 = new int[] {650, 675, 600, 700, 615};
        int []ystar5 = new int[] {160, 210, 180, 180, 210};
        g.fillPolygon(xstar5, ystar5, 5);
        //Stars - 6 Points
        int []xstar2 = new int[] {120,160,140};
        int []ystar2 = new int[] {50, 50, 100};
        g.fillPolygon(xstar2, ystar2, 3);
        int []xstar22 = new int[] {120,160,140};
        int []ystar22 = new int[] {80,80,25};
        g.fillPolygon(xstar22, ystar22, 3);
        //Stars - 7 points
        int []xstar3 = new int[] {200, 400, 200, 400, 225, 300, 375};
        int []ystar3 = new int [] {50, 100, 100, 50, 150, 25, 150};
        g.fillPolygon(xstar3, ystar3, 7);
        //Flowers
        g.setColor(new Color(102, 51, 0));
        g.fillRect(15, 500, 5, 20);
        g.setColor(new Color(255, 0, 0));
        g.fillOval(12, 490, 13, 13);
        g.fillOval(10, 489, 13, 13);
        g.fillOval(16, 485, 13, 13);
        g.fillOval(15, 491, 13, 13);
        //
        g.setColor(new Color(102, 51, 0));
        g.fillRect(455, 500, 5, 30);
        g.setColor(new Color(255, 255, 0));
        g.fillRect(450, 500, 20, 20);
        g.setColor(new Color(102, 0, 204));
        g.fillRect(455, 506, 10, 10);
        //
        g.setColor(new Color(102, 51, 0));
        g.fillRect(605, 500, 5, 35);
        g.setColor(new Color(102, 102, 255));
        g.fillOval(600, 490, 25, 25);
        g.setColor(new Color(255, 0, 0));
        g.fillOval(603, 495, 15, 15);
        
    }
    
}
