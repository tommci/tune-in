package Engine;

import javax.swing.*;

/*  I leaned away from CardLayouts since I read that they maintain all cards in memory at once which sounds horrendous.
 *  This way should also support better code organization and make it easier for me to track my progress and work. */
public abstract class MenuState { // should never create just a MenuState object, so we can make this abstract
	
	protected TuneInEngine engine;
	protected JPanel panel;
	
	public MenuState(TuneInEngine engine, JPanel panel) {
		this.panel = panel;
		this.engine = engine;
	}
	
	/**
	 *  Renders the current state, creates objects.
	 *  Should implement this in each child class as well with panel elements needed per menu.
	 */
	public void display() {
		this.panel.revalidate();
		this.panel.repaint();
	}
	
	/**
	 *  Clears the state.
	 *  This is a fairly universal function, so shouldn't need to override
	 */
	public void clear() {
		this.panel.removeAll();
	}
}
