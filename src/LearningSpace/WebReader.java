package LearningSpace;

import javax.swing.*;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class WebReader extends JFrame implements ActionListener, KeyListener {
	
	JTextArea box = new JTextArea("Getting data ...", 15, 30);
	JButton refreshData;
	static JTextField webAddressEntry = new JTextField("Enter URL here");
	
	public WebReader() {
		
		super("Get File Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(600, 380);
		
		JPanel pane = new JPanel();
		
		pane.setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane(box);
		refreshData = new JButton("Refresh Page");
		refreshData.addActionListener(this);
		webAddressEntry.addKeyListener(this);
		pane.add(webAddressEntry, BorderLayout.SOUTH);
		pane.add(scrollPane, BorderLayout.CENTER);
		pane.add(refreshData, BorderLayout.NORTH);
		add(pane);
		setVisible(true);
		
	}
	
	void getData(String address) throws MalformedURLException {
		
		setTitle(address);
		URL page = new URL(address);
		StringBuilder text = new StringBuilder();
		
		try {
			
			HttpURLConnection conn = (HttpURLConnection) page.openConnection();
			conn.connect();

			String key;
			String header;
			int i = 0;
			
			do {
				
				key = conn.getHeaderFieldKey(i);
				header = conn.getHeaderField(i);
				
				if (key == null) {
					key = "";
				} else {
					key = key + ": ";
				}
				
				if (header != null) {
					text.append(key);
					text.append(header);
					text.append("\n");
				}
				
				i++;
				
			} while (header != null);
			
			text.append("\n");
			
			InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
			BufferedReader buff = new BufferedReader(in);
			box.setText("Getting data ...");
			String line;
			do {
				line = buff.readLine();
				text.append(line);
				text.append("\n");
			} while (line != null);
			
			box.setText(text.toString());
			
			box.setCaretPosition(0);
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
	public void actionPerformed(ActionEvent evt) {
		
		if (evt.getSource() == refreshData) {
			
			try {
				getData(webAddressEntry.getText());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		try {
			
			WebReader app = new WebReader();
			app.getData("http://www.google.com");
			
		} catch (MalformedURLException mue) {
			System.out.println("Bad URL");
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			try {
				getData(webAddressEntry.getText());
			} catch (MalformedURLException me) {
				me.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
