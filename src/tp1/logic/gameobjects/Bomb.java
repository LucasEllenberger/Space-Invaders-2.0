package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;

public class Bomb extends EnemyWeapon {
	private DestroyerAlien destroyerAlien;
	
	public Bomb(Game game, Position pos, DestroyerAlien destroyerAlien) {
		super(game, pos, 1);
		this.destroyerAlien = destroyerAlien;
		// TODO Auto-generated constructor stub
	}

}
