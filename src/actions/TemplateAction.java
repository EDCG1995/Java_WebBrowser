package actions;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * 
 * Template action uses the Template design pattern by creating an Abstract class and leaving actionPerformed abstract to be implemented into a subclass 
 *
 */
public abstract class TemplateAction extends AbstractAction {
	
	public TemplateAction() {}
	
	public TemplateAction(String name, Icon icon, String description, Integer mnemonic) {
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
