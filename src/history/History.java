package history;

import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class History {
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private List<EditorState> states = new ArrayList<EditorState>();
 
	public void push(EditorState state) {
	 states.add(state);
	}
 
	public EditorState pop() {
		var lastIndex = states.size()-1;
		var laststate = states.get(lastIndex);
		states.remove(laststate);
		return laststate;
 }
	public List getList(){
		return states;
	}
	@Override
	public String toString() {
		String websites="";
		if(!states.isEmpty()) {
			websites="Pages visited: \n\n";
			for(int i =0; i<= states.size()-1; i++) {
				websites+= states.get(i).getContent().toString()+" at "+new Date().toString()+"\n";
			}
			return websites;
		}
		return "No websites searched yet";
		
	}
 
}
