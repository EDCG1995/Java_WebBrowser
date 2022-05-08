package history;

import java.net.URL;

public class EditorState {
	private final URL content;
	
	public EditorState(URL content) {
		this.content = content;
	}
	public URL getContent() {
		return content;
	}
}
