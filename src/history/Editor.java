package history;


public class Editor {
	private String content;
	public EditorState createEditorState(){
		return new EditorState(content);
		}
	public String getContent() {
		return content;
	}
	public void restore(EditorState state) {
		content = state.getContent();
	}
	public void setContent(String content) {
		this.content = content;
	}
}

