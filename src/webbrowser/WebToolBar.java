package webbrowser;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.event.*;

import actions.MyAbstractAction;

public class WebToolBar extends JToolBar implements HyperlinkListener {
	
	private WebBrowserPane webBrowserPane;
	private JButton backButton;
	private JButton forwardButton;
	private JTextField urlTextField;

	public WebToolBar(WebBrowserPane browser, Locale locale) throws MalformedURLException {
		ResourceBundle resources = ResourceBundle.getBundle("locales.Strings&Labels", locale);
		setName(resources.getString("toolbarTitle"));
		webBrowserPane = browser;
		webBrowserPane.addHyperlinkListener(this);
		
		urlTextField = new JTextField(25);
		urlTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					URL url = new URL(urlTextField.getText());
					webBrowserPane.goToUrl(url);
				}catch (MalformedURLException urlException) {
					urlException.printStackTrace();
				}
			}
		});
		MyAbstractAction backAction = new MyAbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				URL url = webBrowserPane.back();
				urlTextField.setText(url.toString());
			}
		};
		backAction.setSmallIcon(new ImageIcon(getClass().getResource("images/left.png")));
		backAction.setShortDescription(resources.getString("backToolTip"));
		
		MyAbstractAction forwardAction = new MyAbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				URL url = webBrowserPane.forward();
				urlTextField.setText(url.toString());
			}
		};
		forwardAction.setSmallIcon(new ImageIcon(getClass().getResource("images/right.png")));
		forwardAction.setShortDescription(resources.getString("forwardToolTip"));
		
		add(backAction);
		add(forwardAction);
		add(urlTextField);
		
	}

	public WebToolBar(int orientation) {
		super(orientation);
		// TODO Auto-generated constructor stub
	}

	public WebToolBar(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public WebToolBar(String name, int orientation) {
		super(name, orientation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hyperlinkUpdate(HyperlinkEvent e) {
		if(e.getEventType()== HyperlinkEvent.EventType.ACTIVATED) {
			URL url = e.getURL();
			webBrowserPane.goToUrl(e.getURL());
			urlTextField.setText(url.toString());
		}
		
	}

}
