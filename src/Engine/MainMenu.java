package Engine;

import javax.swing.*;

public class MainMenu extends MenuState {
	
	public MainMenu(TuneInEngine engine, JPanel panel) {
		super(engine, panel);
	}
	
	/**
	 * Main Menu contains a Create Profile button, a Load Profile button
	 */
	@Override
	public void display() {
		JButton createProfileButton = new JButton("Create Profile");
		createProfileButton.addActionListener(event -> {
			// this is how to load different menus
			this.engine.changeState(new CreateProfileMenu(this.engine, this.panel));
		});
		
		JButton loadProfileButton = new JButton("Load Profile");
		loadProfileButton.addActionListener(event -> {
			// TODO: complete loadProfile functionality
		});
		this.panel.add(createProfileButton);
		this.panel.add(loadProfileButton);
		super.display();
	}
}
