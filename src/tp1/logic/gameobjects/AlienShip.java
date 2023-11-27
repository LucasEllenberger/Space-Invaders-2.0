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
			Position.update(super.getPos(), alienManager.getDirection());
			alienManager.enableEdge();
		}
	}
}
