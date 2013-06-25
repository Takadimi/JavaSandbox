package LearningSpace;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Threads extends JFrame implements Runnable, ActionListener {
	
	Thread threadOne = new Thread(this);
	Thread threadTwo = new Thread(this);
	
	JButton thread1, thread2, stopThread1, stopThread2;
	JLabel results1, results2;
	
	public Threads() {
		
		super("Threads!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(2, 1));
		
		JPanel pane = new JPanel();
		thread1 = new JButton("Thread 1");
		thread2 = new JButton("Thread 2");
		stopThread1 = new JButton("Stop 1st Thread");
		stopThread2 = new JButton("Stop 2nd Thread");
		results1 = new JLabel("");
		results2 = new JLabel("");
		
		pane.add(thread1);
		pane.add(thread2);
		pane.add(stopThread1);
		pane.add(stopThread2);
		pane.add(results1);
		pane.add(results2);
		
		add(pane);
		
		thread1.addActionListener(this);
		thread2.addActionListener(this);
		stopThread1.addActionListener(this);
		stopThread2.addActionListener(this);
		
		pack();
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == thread1 && !threadOne.isAlive()) {
			System.out.println("CLICKED");
			threadOne.start();
		} 
		
		if (e.getSource() == thread2 && !threadTwo.isAlive()) {
			threadTwo.start();
		}
		
		if (e.getSource() == stopThread1 || e.getSource() == stopThread2) {
			System.out.println("Stop thread");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void run() {
		
		System.out.println("Thread ran");
		if (threadOne.isAlive()) {
			for (int i = 0; i <= 10000000; i++) {
				String iResults = Integer.toString(i);
				results1.setText(iResults);
			}
		}
		
		if (threadTwo.isAlive()) {
			for (int i = 0; i <= 10000000; i++) {
				String iResults = Integer.toString(i);
				results2.setText(iResults);
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Threads();
	}
	
}
