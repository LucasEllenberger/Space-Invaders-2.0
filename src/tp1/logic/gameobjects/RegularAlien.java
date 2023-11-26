package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;
import tp1.logic.gameobjects.Attributes;

public class RegularAlien extends AlienShip {
	
	private static Move direction = Move.LEFT;
	private int armour = 2;
	private int damage = 0;
//	private AlienManager alienManager;
	
//	public RegularAlien(Game game, Position pos, AlienManager alienManager) {
//		// TODO TEST!!
//		super(game, pos, 2);
//		this.alienManager = alienManager;
//	}
	
	public RegularAlien(Game game, Position pos, AlienManager alienManager) {
		super(game, pos, 2, alienManager);
//		this.alienManager = alienManager;
//		game.changeMetric("aliens", 1);
//		game.addObject(this);
	}
	
//	public static void changeDirection(Move move) {
//		direction = move;
//	}
	
	@Override
	public void computerAction() {
		return;
	}

	@Override
	public void automaticMove() {
		if (game.shouldMove()) {
			Position.update(super.getPos(), direction);
			if (Position.onBorder(super.getPos()) && !direction.equals(Move.DOWN)) {
				game.changeState(getSymbol(), null);
			}
		}
	}
	
//	public boolean reduceHealth(int damage)  {
//		this.life -= damage;
//		if (life <= 0) {
//			game.changeMetric("points", Attributes.RegularAlien.points);
//			game.changeMetric("aliens", -1);
//			return true;
//		}
//		return false;
//	}

	@Override
	public boolean isOnPosition(Position pos) {
		// TODO fill with your code
		return this.pos.equals(pos);
	}

//	@Override
//	public String toString() {
//		return String.format(Messages.GAME_OBJECT_STATUS, getSymbol(), life);
//	}
	
	@Override
	protected String getSymbol() {
		// TODO fill with your code
		return Messages.REGULAR_ALIEN_SYMBOL;
	}

	@Override
	protected int getDamage() {
		// TODO fill with your code
		return damage;
	}

	@Override
	protected int getArmour() {
		// TODO Auto-generated method stub
		return armour;
	}
	
//	@Override
//	public boolean receiveAttack(UCMWeapon weapon) {
//		this.life -= weapon.getDamage();
//		if (life <= 0) {
//			onDelete();
//			return true;
//		}
//		return false;
//	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		super.onDelete();
		game.changeMetric("points", Attributes.RegularAlien.points);
//		game.changeMetric("aliens", -1);
	}
}
