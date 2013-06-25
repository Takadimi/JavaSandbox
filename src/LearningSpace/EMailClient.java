package LearningSpace;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

//TODO Make a to, from, and subject textfield that gets sent and received with the E-Mail.

public class EMailClient extends JFrame implements ActionListener {
	
	JButton send, read, close;
	JTextArea messageBox;
	EMail email;
	
	public EMailClient() {
		
		super("E-Mail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel emailClientPane = new JPanel(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		JPanel textBoxPanel = new JPanel();
		send = new JButton("Send");
		read = new JButton("Read");
		close = new JButton("Close");
		send.addActionListener(this);
		read.addActionListener(this);
		close.addActionListener(this);
		messageBox = new JTextArea(20, 30);
		messageBox.setLineWrap(true);
		messageBox.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(messageBox, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		buttonPanel.add(send);
		buttonPanel.add(read);
		buttonPanel.add(close);
		textBoxPanel.add(scroll);
		
		emailClientPane.add(textBoxPanel, BorderLayout.CENTER);
		emailClientPane.add(buttonPanel, BorderLayout.SOUTH);
		
		add(emailClientPane);
		setSize(400, 300);
		setResizable(false);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == send) {
			createEMail(messageBox.getText());
			sendEMail();
		} else if (e.getSource() == read) {
			readEMail();
		} else if (e.getSource() == close) {
			System.exit(0);
		}
		
	}
	
	private void readEMail() {
		
		try {
			
			FileInputStream fi = new FileInputStream("E-Mail.obj");
			ObjectInputStream oi = new ObjectInputStream(fi);
			email = (EMail) oi.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		messageBox.setText(email.getMessage());
		
	}
	
	private void sendEMail() {
		
		try {
			
			FileOutputStream fo = new FileOutputStream("E-Mail.obj");
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			oo.writeObject(email);
			oo.close();
			System.out.println("E-Mail Sent!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void createEMail(String message) {
		
		email = new EMail(message);
		
	}
	
	public static void main(String[] args) {
		
		new EMailClient();
		
	}

}
