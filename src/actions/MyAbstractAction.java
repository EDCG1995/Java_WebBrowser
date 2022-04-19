package actions;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class MyAbstractAction extends AbstractAction {
	
	public MyAbstractAction() {}
	
	public MyAbstractAction(String name, Icon icon, String description, Integer mnemonic) {
	 setName(name);
	 setSmallIcon(icon);
	 setShortDescription(description);
	 setMnemonic(mnemonic);
	}

	public void setMnemonic(Integer mnemonic) {
		putValue(Action.MNEMONIC_KEY, mnemonic);
	}
	
	public void setShortDescription(String description) {
		putValue(Action.SHORT_DESCRIPTION, description);
	}

	public void setSmallIcon(Icon icon) {
		putValue(Action.SMALL_ICON, icon);
	}

	public void setName(String name) {
		putValue(Action.NAME, name);		
	}
	
	public abstract void actionPerformed(ActionEvent e);
	
}
