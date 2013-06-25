package LearningSpace;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {
	
	JTextField num1, num2;
	JLabel ans;
	JButton add, subtract;
	
	public Main() {
		
		super("Simple Calculator");
		setSize(480, 240);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		num1 = new JTextField("0", 5);
		num2 = new JTextField("0", 5);
		ans = new JLabel("");
		add = new JButton("+");
		subtract = new JButton("-");
		add.addActionListener(this);
		subtract.addActionListener(this);
		
		add(num1);
		add(num2);
		add(ans);
		add(add);
		add(subtract);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent evt) {
		
		try {
			int val1 = Integer.parseInt(num1.getText());
			int val2 = Integer.parseInt(num2.getText());
			
			if(evt.getSource() == add) {
				ans.setText("" + (val1 + val2));
			}
			
			if(evt.getSource() == subtract) {
				ans.setText("" + (val1 - val2));
			}
		} catch (NumberFormatException e) {
			num1.setText("0");
			num2.setText("0");
		}
		repaint();
	}
	
	private static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception exc) {
			System.err.println("Couldn't use the system look and feel: " + exc);
		}
	}
	
	public static void main(String[] args) {
		
		Main.setLookAndFeel();
		new Main();
		
	}
	
}
