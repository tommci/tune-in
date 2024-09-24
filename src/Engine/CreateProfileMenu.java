package Engine;

import javax.swing.*;

import User.Profile;

public class CreateProfileMenu extends MenuState {
	
	public CreateProfileMenu(TuneInEngine engine, JPanel panel) {
		super(engine, panel);
	}
	
	@Override
	public void display() {
		JLabel usernameLabel = new JLabel("Username:");
		JTextField usernameField = new JTextField(18); // textfield is 18 units wide
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(event -> {
			// username special character test
			if(usernameField.getText().matches(".*[ !@#$%^&*()~`:;\\\"\\'/?.>,<[{]}|\\\\+=_-].*")) { // regex to determine special chars
				JOptionPane.showMessageDialog(this.engine.getFrame(), // creates a simple dialog box with error message
					    "Username cannot contain special characters.");
			// username length check
			} else if(usernameField.getText().length() > 18) {
				JOptionPane.showMessageDialog(this.engine.getFrame(),
					    "Username must be 18 characters or less.");
			// profile exists check
			} else if(Profile.userExists(usernameField.getText())) {
				JOptionPane.showMessageDialog(this.engine.getFrame(),
					    "User " + usernameField.getText() + " already exists.");
			// passed all checks: create profile
			} else {
				Profile newUser = new Profile(usernameField.getText());
				newUser.saveUserToFile();
				engine.setCurrentUser(newUser);
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
