package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class DestroyerAlien extends AlienShip {
	
	private static Move direction = Move.LEFT;
	private Bomb currBomb;
	private Game game;
	private Position position;
	private int health;
	private boolean canBomb = true;
	private AlienManager alienManager;
	
	
	public DestroyerAlien(Game game, Position pos, AlienManager alienManager) {
		super(game, pos, 1);
		this.alienManager = alienManager;
		// TODO Auto-generated constructor stub
	}
	
//	public DestroyerAlien(Game game, Position position) {
//		this.game = game;
//		this.position = position;
//		game.changeMetric("aliens", 1);
//		game.add(this);
//	}
	
	public String getSymbol() {
		return String.format(Messages.GAME_OBJECT_STATUS, Messages.DESTROYER_ALIEN_SYMBOL, health);
	}
	
	public Position getPosition() {
		return position;
	}
	
	public static void changeDirection(Move move) {
		direction = move;
	}
	
	public void enableBomb() {
		canBomb = true;
	}
	
	public void automaticMove() {
		if (game.shouldMove()) {
			Position.update(position, direction);
			if (Position.onBorder(position) && !direction.equals(Move.DOWN)) {
				game.changeState("edge", true);
			}
		}
		dropBomb();
	}
	
	public boolean reduceHealth(int damage)  {
		this.health -= damage;
		if (health <= 0) {
			game.changeMetric("points", Attributes.DestroyerAlien.points);
			game.changeMetric("aliens", -1);
			return true;
		}
		return false;
	}
	
	
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
}
