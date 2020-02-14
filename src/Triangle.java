/**
 * Lab 9 - Recursive Triangles
 * @author: Silpa Prajapati, Timo Schmidt
 * @version: 2020.01.05
 */

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Triangle extends JComponent {

    // Color array with all colors available
    Color[] color = {
            Color.yellow,
            Color.magenta,
            Color.cyan,
            Color.darkGray,
            Color.orange,
            Color.green,
            Color.blue,
            Color.red
    };

    // Counter for the colors
    int counter = 7;

    Triangle(Dimension d) {
        setSize(d);
    }

    /**
     * Exercise 1
     * Draw first triangle
     */
    public void paint(Graphics g)
    {
        Dimension d = getSize();

        int w = d.width;
        int h = d.height;
        int xc = w/2;                                   // x-center of width
        int side = (int) ((2 * h)/Math.sqrt(3.0));      // Formula to calculate side length
        int ha = side/2;                                // half of a

        // Draw triangle
        Point a = new Point(xc-ha, h);  // left
        Point b = new Point(xc+ha, h);  // right
        Point c = new Point(xc, 0);     // top

        drawTriangle(g, a, b, c);
        drawAndFillTriangle(g, 7, a, b, c);
    }

    /**
     * Exercise 2 + 3
     * Connecting midpoints to create new triangles
     * Expand your triangle drawing algorithm to draw in a specific color.
     * Choose a different color for every level of the algorithm.
     */
    public void drawTriangle(Graphics g, Point a, Point b, Point c) {

        g.drawLine(a.x, a.y, b.x, b.y);        // left line
        g.drawLine(b.x, b.y, c.x, c.y);        // bottom line
        g.drawLine(c.x, c.y, a.x, a.y);        // right line

        Point ab = getMidpoint(a, b);
        Point bc = getMidpoint(b, c);
        Point ca = getMidpoint(c, a);

        // Go through the color array and set color
        counter--;

        // If color array reaches the end, start again
        if (counter < 0)
            counter = 7;

        g.setColor(color[counter]);

        // Termination condition / Recursive methods
        if (getDistance(a, b) > 2) {
            drawTriangle(g, a, ab, ca);
            drawTriangle(g, ab, b, bc);
            drawTriangle(g, c, ca, bc);
        }

    }

    /**
     * Exercise 4
     * Fill the middle triangle on each step with an appropriate color.
     */
    public void drawAndFillTriangle(Graphics g, int base, Point a, Point b, Point c) {

        Polygon	p = new Polygon();
        p.addPoint(a.x, a.y);
        p.addPoint(b.x, b.y);
        p.addPoint(c.x, c.y);

        Point ab = getMidpoint(a, b);
        Point bc = getMidpoint(b, c);
        Point ca = getMidpoint(c, a);
        g.setColor(color[base]);
        g.fillPolygon(p);

        if (base > 0) {
            drawAndFillTriangle(g, base-1, a, ab, ca);
            drawAndFillTriangle(g, base-1, ab, b, bc);
            drawAndFillTriangle(g, base-1, c, ca, bc);
        }
    }

    public Point getMidpoint(Point a, Point b) {
        return new Point((a.x + b.x) / 2, (a.y + b.y) / 2);
    }

    public int getDistance(Point a, Point b) {
        return Math.abs(a.x - b.x);
    }

}
