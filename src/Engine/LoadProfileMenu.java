package Engine;

import javax.swing.*;

import User.Profile;

public class LoadProfileMenu extends MenuState {
	
	public LoadProfileMenu(TuneInEngine engine, JPanel panel) {
		super(engine, panel);
	}
	
	@Override
	public void display() {
		JLabel usernameLabel = new JLabel("Username:");
		JTextField usernameField = new JTextField(18);
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(event -> {
			if(!Profile.userExists(usernameField.getText())) { // if we cannot find the user specified
				JOptionPane.showMessageDialog(this.engine.getFrame(),
					    "User " + usernameField.getText() + " does not exist or could not be found.");
			// load profile
			} else {
				Profile thisUser = Profile.loadUserFromFile(usernameField.getText());
				engine.setCurrentUser(thisUser);
				// TODO: after user creation, move to next menu
			}
		});
		
		// add relevant components to panel
		this.panel.add(usernameLabel);
		this.panel.add(usernameField);
		this.panel.add(confirmButton);
		
		// check to make sure we're on the event dispatch thread still
//		System.out.println(javax.swing.SwingUtilities.isEventDispatchThread());
		
		super.display();
	}
}
