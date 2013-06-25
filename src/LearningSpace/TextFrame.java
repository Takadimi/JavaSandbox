package LearningSpace;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TextFrame extends JFrame {
	
	public TextFrame(String text, String fontName) {
		
		super("Show Font");
		setSize(425, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 1));
		TextFramePanel sf = new TextFramePanel(text, fontName);
		ButtonFramePanel bf = new ButtonFramePanel();
		add(sf);
		add(bf);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		TextFrame frame = new TextFrame("Able was I ere I saw Elba", "Times New Roman");
		
	}

}

class ButtonFramePanel extends JPanel implements ActionListener {
	
	JButton newButton;
	
	public ButtonFramePanel() {
		
		super();
		newButton = new JButton("This button rocks!");
		newButton.addActionListener(this);
		add(newButton);
		
	}
	
	public void actionPerformed(ActionEvent evt) {
		
		if (evt.getSource() == newButton) {
			JOptionPane.showMessageDialog(null, "Peace Bitches!!!");
			System.exit(0);
		}
		
	}
	
}

class TextFramePanel extends JPanel implements KeyListener {
	
	String text;
	String fontName;
	int w;
	int x;
	int y;
	int z;
	
	public TextFramePanel(String text, String fontName) {
		
		super();
		this.text = text;
		this.fontName = fontName;	
		setFocusable(true);
		addKeyListener(this);
		
	}
	
	public void paintComponent(Graphics comp) {
		
		super.paintComponent(comp);
		Graphics2D comp2D = (Graphics2D)comp;
		comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		setBackground(new Color(0, 0, 0));
		comp2D.setColor(Color.magenta);
		
		GradientPaint gp = new GradientPaint(13F, 15F, Color.WHITE, 36F, 42F, Color.GREEN);
		comp2D.setPaint(gp);
		
		Font font = new Font(fontName, Font.BOLD + Font.ITALIC, 18);
		FontMetrics metrics = getFontMetrics(font);
		comp2D.setFont(font);
		x = ((getSize().width - metrics.stringWidth(text)) / 2) + z;
		y = getSize().height / 2 + w;
		comp2D.drawString(text, x, y);
		
		BasicStroke pen = new BasicStroke(2.0F, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);
		comp2D.setStroke(pen);
		
		Rectangle2D.Float rc = new Rectangle2D.Float(13F, 15F, 36F, 42F);
		
		comp2D.fill(rc);
		comp2D.draw(rc);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
				
		if (e.getKeyChar() == 'd') {
			if (x <= getSize().width) {
				z += 6;
				System.out.println("Typed: " + e.getKeyChar());
				repaint();
			}
		}
		
		if (e.getKeyChar() == 'a') {
			if (x >= 0) {
				z -= 6;
				System.out.println("Typed: " + e.getKeyChar());
				repaint();
			}
		}
		
		if (e.getKeyChar() == 'w') {
			w -= 6;
			System.out.println("Typed: " + e.getKeyChar());
			repaint();
		}
		
		if (e.getKeyChar() == 's') {
			w += 6;
			System.out.println("Typed: " + e.getKeyChar());
			repaint();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}