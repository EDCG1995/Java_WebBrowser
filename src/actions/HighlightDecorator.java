package actions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;


public class HighlightDecorator extends Decorator {
	boolean mouse_over;
	JComponent comp;
	public HighlightDecorator(JComponent c) {
		super(c);
		comp = this;
		mouse_over = false;
		c.addMouseListener(new MouseAdapter() {

		@Override
			public void mouseEntered(MouseEvent e) {
			mouse_over = true;
			comp.repaint();
			}
		@Override
			public void mouseExited(MouseEvent e) {
			mouse_over = false;
				comp.repaint();
			}
		});
		setVisible(true);
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(mouse_over) {
			Dimension size = super.getMinimumSize();
			int x;
			int y;
			ArrayList<Integer> xList = new ArrayList<Integer>();
			ArrayList<Integer> yList = new ArrayList<Integer>();
			g.setColor(Color.YELLOW);
			for(y= size.height; y>size.height-5;--y) {
				yList.add(y);
			}
			for(x= size.width; x> size.width-5; --x) {
				xList.add(x);
			}
			for(y= 0; y<yList.size()-1;++y) {
				for(x= 0; x<xList.size()-1; ++x) {
					if(x == y) {
						g.drawRect(x,y,xList.get(x)-x, yList.get(y)-y);
						
					}
				}
			}
		}	
	}
}
