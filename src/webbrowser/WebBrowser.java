package webbrowser;
import java.awt.*;
import java.net.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class WebBrowser extends JFrame {
	private ResourceBundle resources;
	private WebToolBar toolBar;
	private WebBrowserPane browserPane;
	private WebBrowserPane favouriteBrowserPane;

	public WebBrowser(Locale locale) throws MalformedURLException {
		
		resources = ResourceBundle.getBundle("locales.Strings&Labels", locale);
		setTitle(resources.getString("applicationTitle"));
		browserPane = new WebBrowserPane();
		toolBar = new WebToolBar(browserPane, locale);
		
		favouriteBrowserPane = new WebBrowserPane();
		favouriteBrowserPane.addHyperlinkListener(toolBar);
		favouriteBrowserPane.goToUrl(getClass().getResource("favourites/"+resources.getString("favouriteWebsite")));
		
		JSplitPane splitPane = new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT,
				new JScrollPane(favouriteBrowserPane),
				new JScrollPane(browserPane)
				);
		splitPane.setDividerLocation (210);
		splitPane.setOneTouchExpandable(true);
		
		Container contentPane = getContentPane();
		contentPane.add(toolBar, BorderLayout.NORTH);
		contentPane.add(splitPane, BorderLayout.CENTER);
	}
	

	public WebBrowser(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public WebBrowser(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public WebBrowser(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

}
