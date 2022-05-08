package actions;
import java.awt.GridLayout;
import javax.swing.JComponent;

abstract class Decorator extends JComponent {
	public Decorator(JComponent c) {
		setLayout(new GridLayout());
		add(c);
	}
}
