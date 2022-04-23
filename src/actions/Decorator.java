package actions;
import java.awt.GridLayout;
import javax.swing.JComponent;

public class Decorator extends JComponent {
	public Decorator(JComponent c) {
		setLayout(new GridLayout());
		add(c);
	}
}
