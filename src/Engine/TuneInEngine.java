package Engine;

import java.awt.FlowLayout;
import javax.swing.*;

import User.Profile;

public class TuneInEngine {
	
	private JFrame frame;
	private JPanel contentPanel;
	private MenuState state;
	private Profile currentUser;
	
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 768;
	
	public TuneInEngine() {
		// default constructor, not needed for anything yet
	}
	
	public void changeState(MenuState newState) {
		this.state.clear();
		this.state = newState;
		this.state.display();
	}
	
	public void setupGUI() {
		this.frame = new JFrame("Tune-In");
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		this.contentPanel = new JPanel(new FlowLayout());
		this.frame.setContentPane(this.contentPanel);

		this.frame.setVisible(true);
		this.state = new MainMenu(this, contentPanel); // start in main menu state
		
		this.state.display();
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	public Profile getCurrentUser() {
		return this.currentUser;
	}
	
	public void setCurrentUser(Profile user) {
		this.currentUser = user;
	}

	public static void main(String[] args) {
		TuneInEngine program = new TuneInEngine();
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                program.setupGUI();
            }
        });
	}
}
