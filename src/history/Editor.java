package history;

import java.net.URL;

public class Editor {
	private URL content;
	public EditorState createEditorState(){
		return new EditorState(content);
		}
	public URL getContent() {
		return content;
	}
	public void restore(EditorState state) {
		content = state.getContent();
	}
	public void setContent(URL content) {
		this.content = content;
	}
}

