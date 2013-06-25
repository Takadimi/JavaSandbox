package LearningSpace;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class PieChart extends JFrame {
	
	public PieChart() {
		
		super("Pie Chart");
		setSize(200, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PieChartPanel panel = new PieChartPanel();
		add(panel);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		PieChart pie = new PieChart();
		
	}
	
}

class PieChartPanel extends JPanel {
	
	public void paintComponent(Graphics comp) {
		
		Graphics2D comp2D = (Graphics2D)comp;
		comp2D.setColor(Color.darkGray);
		comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		BasicStroke pen = new BasicStroke(2F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		comp2D.setStroke(pen);
		
		Arc2D.Float arc1 = new Arc2D.Float(100F, 100F, 50F, 50F, 270F, -90F, Arc2D.PIE);
		comp2D.fill(arc1);
		comp2D.setColor(Color.cyan);
		Arc2D.Float arc2 = new Arc2D.Float(100F, 100F, 50F, 50F, 180F, -90F, Arc2D.PIE);
		comp2D.fill(arc2);
		comp2D.setColor(Color.green);
		Arc2D.Float arc3 = new Arc2D.Float(100F, 100F, 50F, 50F, 90F, -90F, Arc2D.PIE);
		comp2D.fill(arc3);
		comp2D.setColor(Color.red);
		Arc2D.Float arc4 = new Arc2D.Float(100F, 100F, 50F, 50F, 0F, -90F, Arc2D.PIE);
		comp2D.fill(arc4);

	}
	
}