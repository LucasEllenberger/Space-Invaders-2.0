package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class DestroyerAlien extends AlienShip {
	
	private static Move direction;
	private Bomb currBomb;
	private boolean canBomb = true;
//	private AlienManager alienManager;
	
	
	public DestroyerAlien(Game game, Position pos, AlienManager alienManager) {
		super(game, pos, 1, alienManager);
		direction = alienManager.getDirection();
//		this.alienManager = alienManager;
		// TODO Auto-generated constructor stub
	}
	
//	public DestroyerAlien(Game game, Position position) {
//		this.game = game;
//		this.position = position;
//		game.changeMetric("aliens", 1);
//		game.add(this);
//	}
	
//	public String toString() {
//		return String.format(Messages.GAME_OBJECT_STATUS, Messages.DESTROYER_ALIEN_SYMBOL, life);
//	}
	
	public String getSymbol() {
		return Messages.DESTROYER_ALIEN_SYMBOL;
	}
	
//	public boolean isAlive() {
//		return super.isAlive();
//	}
	
//	public Position getPos() {
//		return super.getPos();
//	}
	
//	Implemented in super class
//	public static void changeDirection(Move move) {
//		direction = move;
//	}
	
	public void enableBomb() {
		canBomb = true;
	}
	
	public void automaticMove() {
		super.automaticMove();
		dropBomb();
	}
	
//	public boolean receiveAttack(EnemyWeapon weapon)  {
//		this.life -= weapon.getDamage();
//		if (life <= 0) {
//			game.changeMetric("points", Attributes.DestroyerAlien.points);
//			game.changeMetric("aliens", -1);
//			return true;
//		}
//		return false;
//	}
	
	/**
	 * Attempts to spawn a bomb from the reference ship
	 */
	
	public void dropBomb() {
		if (canBomb && game.getRandom().nextDouble() < game.getLevel().getShootFrequency()) {
			currBomb = new Bomb(this.game, pos, this);
			game.addObject(currBomb);
			canBomb = false;
		}
	}
	
	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		super.onDelete();
		game.changeMetric("points", Attributes.DestroyerAlien.points);
//		game.changeMetric("aliens", -1);
	}
}
