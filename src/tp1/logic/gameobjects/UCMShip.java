package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class UCMShip extends Ship {

	public UCMShip(Game game, Position pos) {
		super(game, pos, 3);
		// TODO Auto-generated constructor stub
	}

	public int getLife() {
		// TODO TEST!!
		return life;
	}
	
	//TODO fill with your code
	public String getSymbol() {
		return (life == 0) ?  Messages.UCMSHIP_DEAD_SYMBOL : Messages.UCMSHIP_SYMBOL;
	}
	
	public Position getPosition() {
		return pos;
	}
	
	public void automaticMove() {
		return;
	}
	
	public boolean receiveAttack(EnemyWeapon weapon) {
		life -= weapon.getDamage();
		if (life <= 0) {
			game.aliensWin();
			return true;
		}
		return false;
	}
}
