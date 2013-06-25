package LearningSpace;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

public class BasicBrowser extends JFrame implements ActionListener, HyperlinkListener {

	JTextField urlAddressBar;
	JScrollPane displayScrollPane;
	JEditorPane display;

	public BasicBrowser() {

		super("Basic Web Browser");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		urlAddressBar = new JTextField();
		display = new JEditorPane();
		displayScrollPane = new JScrollPane(display);
		
		urlAddressBar.addActionListener(this);
		display.addHyperlinkListener(this);
		display.setEditable(false);

		add(urlAddressBar, BorderLayout.NORTH);
		add(displayScrollPane, BorderLayout.CENTER);

		setVisible(true);

	}

	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource() == urlAddressBar) {
			loadPage(urlAddressBar.getText());
		}

	}

	public void hyperlinkUpdate(HyperlinkEvent evt) {

		if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {

			loadPage(evt.getURL());

		}

	}

	private void loadPage(String url) {

		try {
			display.setPage(url);
			urlAddressBar.setText(url.toString());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
	
	private void loadPage(URL url) {
		
		try {
			display.setPage(url);
			urlAddressBar.setText(url.toString());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void main(String[] args) {

		BasicBrowser newBrowser = new BasicBrowser();

	}

}
