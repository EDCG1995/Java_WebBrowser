package webbrowser;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.MalformedURLException;
import java.util.*;

import javax.swing.*;
/**
 * 
 * The Launcher class uses the Singleton Pattern by making its constructor private, creating a private instance and providing a getter for the instance. 
 *
 */
public class Launcher extends JFrame {
	private static Launcher instance = new Launcher();
	private JComboBox<Locale> localeComboBox;
	private Launcher() {
		super("Browser Launcher");
		localeComboBox = new JComboBox<Locale>();
		localeComboBox.addItem(Locale.ENGLISH);
		localeComboBox.addItem(Locale.FRENCH);
		localeComboBox.addItem(new Locale("ES"));
		localeComboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
					try {
						launchBrowser((Locale)localeComboBox.getSelectedItem());
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}
			}
		});
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		container.add(new JLabel("Select Locale"));
		container.add(localeComboBox);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public static Launcher getInstance(){
	      return instance;
	   }
	private void launchBrowser(Locale locale) throws MalformedURLException {
		WebBrowser browser = new WebBrowser(locale);
		browser.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		browser.setSize(640,480);
		browser.setVisible(true);
	}

}
