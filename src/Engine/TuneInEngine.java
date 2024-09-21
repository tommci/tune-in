package Engine;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class TuneInEngine {
	
	private JFrame frame;
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 768;
	
	public void setupGUI() {
		this.frame = new JFrame("Tune-In");
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		JPanel contentPanel = new JPanel(new FlowLayout());
		
		this.frame.setContentPane(contentPanel);
		
		this.frame.setVisible(true);
	}
	
	public void mainMenu() {
		JButton createProfileBut = new JButton("Create User Profile");
		createProfileBut.addActionListener((e)->{
			// TODO write create profile button behavior here
		});
		this.frame.add(createProfileBut);
		
		JButton loadProfileBut = new JButton("Load User Profile");
		loadProfileBut.addActionListener((e)->{
			// TODO write load profile button behavior here
		});
		this.frame.add(loadProfileBut);
	}

	public static void main(String[] args) {
		TuneInEngine program = new TuneInEngine();
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                program.setupGUI();
                program.mainMenu();
            }
        });
	}
}
