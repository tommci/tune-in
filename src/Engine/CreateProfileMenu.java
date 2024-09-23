package Engine;

import javax.swing.*;

public class CreateProfileMenu extends MenuState {
	public CreateProfileMenu(TuneInEngine engine, JPanel panel) {
		super(engine, panel);
	}
	
	@Override
	public void display() {
		JTextField test = new JTextField("test");
		this.panel.add(test);
		super.display();
	}
}
