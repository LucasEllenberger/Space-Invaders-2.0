package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class Ufo extends EnemyShip {

	public Ufo(Game game, Position pos) {
		super(game, pos, 1);
		// TODO Auto-generated constructor stub
	}

	public String getSymbol() {
		return String.format(Messages.GAME_OBJECT_STATUS, Messages.UFO_SYMBOL, life);
	}

	public Position getPosition() {
		return pos;
	}
	
	private void die() {
		game.changeState("ufo", false);
		game.removeObject(this);
	}
	
	public void automaticMove() {
		Position.update(pos, Move.LEFT);
		if(Position.outside(pos)) {
			game.changeState("ufo", false);
			
		}
	}
	
	public boolean reduceHealth(int damage) {
		life -= damage;
		if (life <= 0) {
			pos = null;
			game.changeMetric("points", Attributes.Ufo.points);
			game.changeState("shockwave", true);
			die();
			return true;
		}
		return false;
	}
	
	/**
	 * Attempt to spawn a UFO
	 * 
	 * @return A boolean representing whether a UFO was created 
	 */
	
	public void computerAction() {
		if(!game.getState("ufo") && game.getRandom().nextDouble() < game.getLevel().getUfoFrequency()) {
			life = 1;
			pos = new Position(Game.DIM_X - 1, 0);
			game.addObject(this);
			game.changeState("ufo", true);	
		}
	}
}
