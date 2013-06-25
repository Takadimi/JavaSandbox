package LearningSpace;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Circle extends JFrame {
	
	public Circle() {
		
		super("Circle");
		setSize(200, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CirclePanel pane = new CirclePanel(30, (getSize().width / 2), (getSize().height / 2), Color.blue);
		add(pane);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		Circle frame = new Circle();
		
	}
	
}

class CirclePanel extends JPanel {
	
	int radius;
	int x;
	int y;
	Color col;
	
	public CirclePanel(int radius, int x, int y, Color col) {
		
		this.radius = radius;
		this.x = x;
		this.y = y;
		this.col = col;
		
		
		
	}
	
	public void paintComponent(Graphics comp) {
		
		Graphics2D comp2D = (Graphics2D) comp;
		comp2D.setColor(col);
		comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Ellipse2D.Float circ = new Ellipse2D.Float(x, y, (radius * 2), (radius * 2));
		comp2D.fill(circ);
		
	}
	
}