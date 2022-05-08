package webbrowser;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.*;
import javax.swing.event.*;
import actions.HighlightDecorator;
import actions.TemplateAction;
import history.Editor;
import history.History;

public class WebToolBar extends JToolBar implements HyperlinkListener {
	
	private WebBrowserPane webBrowserPane;
	private JButton backButton = new JButton(new ImageIcon(getClass().getResource("images/left.png")));
	private JButton forwardButton = new JButton(new ImageIcon(getClass().getResource("images/right.png")));
	private JButton historyButton = new JButton(new ImageIcon(getClass().getResource("images/historyicon.png")));
	private JTextField urlTextField;
	

	public WebToolBar(WebBrowserPane browser, Locale locale) throws MalformedURLException {
		ResourceBundle resources = ResourceBundle.getBundle("locales.Strings&Labels", locale);
		setName(resources.getString("toolbarTitle"));
		webBrowserPane = browser;
		webBrowserPane.addHyperlinkListener(this);
		var editor = new Editor();
		var history = new History();
		urlTextField = new JTextField(25);
		urlTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					URL url = new URL(urlTextField.getText());
					webBrowserPane.goToUrl(url);
					editor.setContent(url);
					history.push(editor.createEditorState());
				}catch (MalformedURLException urlException) {
					urlException.printStackTrace();
				}
			}
		});
		TemplateAction backAction = new TemplateAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					URL url = webBrowserPane.back();
					urlTextField.setText(url.toString());	
				} catch (Exception e2) {
					System.out.println("404");
				}
				
			}
		};
		backAction.setShortDescription(resources.getString("backToolTip"));
		
		TemplateAction forwardAction = new TemplateAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					URL url = webBrowserPane.forward();
					urlTextField.setText(url.toString());
					
				} catch (Exception e2) {
				System.out.println("404");
				}
				}
		};
		forwardAction.setShortDescription(resources.getString("forwardToolTip"));
		
		TemplateAction historyAction = new TemplateAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(browser, history.toString());
				
				
			}
		};
		historyAction.setName("history");
		backButton.addActionListener(backAction);
		forwardButton.addActionListener(forwardAction);
		historyButton.addActionListener(historyAction);
		add(new HighlightDecorator(backButton) );
		add(new HighlightDecorator(forwardButton) );
		add(urlTextField);
		add(historyButton);
		
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
