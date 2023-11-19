package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;

/**
 * Class used to represent empty space on the board. In practice, there is only ever one Space object, and the latter 
 * three methods should never be called.
 */
public class Space extends GameObject {

	public Space() {
		super(null, null, 0);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getSymbol() {
		return Messages.EMPTY;
	}
	
	@Override
	public void automaticMove() {
		return;
	}

	@Override
	protected int getDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int getArmour() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public boolean isOnPosition(Position pos) {
		// TODO Auto-generated method stub
		return false;
	}
}
