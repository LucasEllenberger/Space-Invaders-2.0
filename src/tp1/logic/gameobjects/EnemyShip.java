package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class EnemyShip extends Ship {
	protected AlienManager alienManager;
	
	public EnemyShip(Game game, Position pos, int life, AlienManager alienManager) {
		super(game, pos, life);
		this.alienManager = alienManager;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return String.format(Messages.GAME_OBJECT_STATUS, getSymbol(), life);
	}
	
	protected String getSymbol() {
		return "";
	}
	
	@Override
	public boolean receiveAttack(UCMWeapon weapon) {
		this.life -= weapon.getDamage();
		if (life <= 0) {
			onDelete();
			return true;
		}
		return false;
	}
	
	@Override
	public void onDelete() {
		game.removeObject(this);
	}
}
