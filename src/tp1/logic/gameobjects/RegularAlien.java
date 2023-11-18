package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class RegularAlien extends AlienShip {
	
	private static Move direction = Move.LEFT;
	private Game game;
	private Position position;
	private int health = 2;
	
	public RegularAlien(Game game, Position pos, AlienManager alienManager) {
		// TODO fill with your code
		super(game, pos, 0);
	}
	
	public RegularAlien(Game game, Position position) {
		this.game = game;
		this.position = position;
		game.changeMetric("aliens", 1);
		game.add(this);
	}
	
	public Position getPosition() {
		return position;
	}
	
	public static void changeDirection(Move move) {
		direction = move;
	}

	public boolean automaticMove() {
		if (game.shouldMove()) {
			Position.update(position, direction);
			if (Position.onBorder(position) && !direction.equals(Move.DOWN)) {
				game.changeState("edge", true);
			}
		}
		return true;
	}
	
	public boolean reduceHealth(int damage)  {
		this.health -= damage;
		if (health <= 0) {
			game.changeMetric("points", Attributes.RegularAlien.points);
			game.changeMetric("aliens", -1);
			return true;
		}
		return false;
	}

	@Override
	public boolean isOnPosition(Position pos) {
		// TODO fill with your code
		return false;
	}

	@Override
	protected String getSymbol() {
		// TODO fill with your code
		return Messages.REGULAR_ALIEN_SYMBOL;
	}

	@Override
	protected int getDamage() {
		// TODO fill with your code
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

	}

	@Override
	public void automaticMove() {
		// TODO Auto-generated method stub

	}

}
