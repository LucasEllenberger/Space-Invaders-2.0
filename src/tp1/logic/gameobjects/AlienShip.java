package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;

public class AlienShip extends EnemyShip {
	protected static Move direction = Move.LEFT;
	
	public AlienShip(Game game, Position pos, int life, AlienManager alienManager) {
		super(game, pos, life, alienManager);
		alienManager.alienSpawn();
		// TODO Auto-generated constructor stub
	}
	
	public boolean onLastRow() {
		return super.getPos().getRow() == (Game.DIM_Y - 1);
	}
	
	public boolean onEdge() {
		int currCol = super.getPos().getCol();
		return (currCol == 0 || currCol == (Game.DIM_X - 1));
	}

	public static void changeDirection(Move move) {
		direction = move;
	}
	
	@Override
	public void onDelete() {
		super.onDelete();
		alienManager.alienDeath();
	}
	
	@Override
	public void automaticMove() {
		if (alienManager.shouldMove()) {
			boolean before = onEdge();
			Position.update(super.getPos(), alienManager.getDirection());
			boolean after = onEdge();
			if (onLastRow()) {
				alienManager.enableLastRow();
			}
			if (!before && after) {
				alienManager.enableEdge();
			}
		}
	}
}
