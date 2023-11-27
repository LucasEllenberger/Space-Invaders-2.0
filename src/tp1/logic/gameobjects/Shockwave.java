package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.AlienManager;

public class Shockwave extends UCMWeapon {
	
	private boolean shockwave = false;

	public Shockwave(Game game) {
		super(game, null, 0);
		// TODO Auto-generated constructor stub
	}
	
	public void enableShockwave() {
		shockwave = true;
	}
	
	public boolean getShockwave() {
		return shockwave;
	}

	public boolean attack() {
		if (shockwave) {
			// do attack
			return true;
		} else {
			return false;
		}
	}
}
