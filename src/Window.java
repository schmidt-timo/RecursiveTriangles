/**
 * Lab 9 - Recursive Triangles
 * @author: Silpa Prajapati, Timo Schmidt
 * @version: 2020.01.05
 */

import javax.swing.*;
import java.awt.*;

/**
 * Exercise 1
 * Creating a window
 * Draw an equilateral triangle
 */
public class Window {

    // Determine display size
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;

    public Window() {
        // Create a new frame
        JFrame frame = new JFrame("Recursive Triangle");
        // Set frame size to the max screen size
        frame.setSize(screenWidth, screenHeight);
        // Add triangle to frame
        frame.add(new Triangle(frame.getSize()));
        // Make it visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Window win = new Window();
    }

}
