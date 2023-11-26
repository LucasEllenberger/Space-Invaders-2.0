package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class UCMShip extends Ship {
	private UCMLaser laser;
	private Shockwave shockwave = new Shockwave(game);

	public UCMShip(Game game, Position pos) {
		super(game, pos, 3);
		// TODO Auto-generated constructor stub
	}
	
	//TODO fill with your code
	public String toString() {
		return (life == 0) ?  Messages.UCMSHIP_DEAD_SYMBOL : Messages.UCMSHIP_SYMBOL;
	}
	
	public String getSymbol() {
		return (life == 0) ?  Messages.UCMSHIP_DEAD_SYMBOL : Messages.UCMSHIP_SYMBOL;
	}
	
	public void automaticMove() {
		return;
	}
	
	public int getLife() {
		return super.getLife();
	}
	
	public boolean receiveAttack(EnemyWeapon weapon) {
		life -= weapon.getDamage();
		if (life <= 0) {
//			game.aliensWin();
			return true;
		}
		return false;
	}

	public boolean move(Move move) {
		// TODO Test
		return Position.updateSafe(this.getPos(), move);
	}
	
	public boolean shockwave() {
		return shockwave.attack();
	}
}
