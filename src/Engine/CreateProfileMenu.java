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
			if(usernameField.getText().matches(".*[ !@#$%^&*()~`:;\\\"\\'/?.>,<[{]}|\\\\+=_-].*")) { // regex to determine special chars
				JOptionPane.showMessageDialog(this.engine.getFrame(), // creates a simple dialog box with error message
					    "Username cannot contain special characters.");
			} else if(usernameField.getText().length() > 18) {
				JOptionPane.showMessageDialog(this.engine.getFrame(),
					    "Username must be 18 characters or less.");
			} else {
				Profile newUser = new Profile(usernameField.getText());
				newUser.saveUserToFile();
				// TODO: after user creation, move to next menu
			}
		});
		
		this.panel.add(usernameLabel);
		this.panel.add(usernameField);
		this.panel.add(confirmButton);
		
		super.display();
	}
}
