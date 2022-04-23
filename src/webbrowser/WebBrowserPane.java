package webbrowser;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;


public class WebBrowserPane extends JEditorPane {

	private List<URL> history = new ArrayList<URL>();
	private int historyIndex;

	
	public WebBrowserPane() {
		setEditable(false);
	}
	public void goToUrl(URL url) {
		displayPage(url);
		history.add(url);
	
		historyIndex = history.size()-1;
	}
	
	public URL forward() {			
		historyIndex++;
		if(historyIndex >= history.size()) 
			historyIndex = history.size()-1;
		URL url = (URL) history.get(historyIndex);
		displayPage(url);
		return url;
	}
	
	public URL back() {
		historyIndex--;
		if (historyIndex < 0)
			historyIndex= 0;
		URL url = (URL) history.get(historyIndex);
		displayPage(url);
		return url;
	}
	
	private void displayPage(URL pageURL) {
		try {
			setPage(pageURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public WebBrowserPane(URL initialPage) throws IOException {
		super(initialPage);
		// TODO Auto-generated constructor stub
	}

	public WebBrowserPane(String url) throws IOException {
		super(url);
		// TODO Auto-generated constructor stub
	}

	public WebBrowserPane(String type, String text) {
		super(type, text);
		// TODO Auto-generated constructor stub
	}

}
