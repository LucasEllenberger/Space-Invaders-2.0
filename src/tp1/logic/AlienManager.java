package tp1.logic;

import tp1.logic.gameobjects.DestroyerAlien;
import tp1.logic.gameobjects.RegularAlien;
import tp1.logic.gameobjects.Ufo;

public class AlienManager  {
	
	private Game game;
	private Move dir = Move.LEFT; 
	private int remainingAliens = 0;
	private int speed;
	private int turnsWaited = 0;
	private boolean ufo = false;
	private boolean edge = false;
	private boolean wasLeft = true;
	
	//TODO fill with your code
	public AlienManager(Game game) {
		this.game = game;
		speed = game.getLevel().getSpeed();
	}

	public  GameObjectContainer initialize() {
		this.remainingAliens = 0;
		GameObjectContainer container = new GameObjectContainer();
		
		initializeOvni(container);
		initializeRegularAliens(container);
		initializeDestroyerAliens(container);
		
		//TODO fill with your code
		
		return container;
	}
	
	private void initializeOvni(GameObjectContainer container) {
//		container.add(new Ufo(game, null, this));
	}
	
	private void initializeRegularAliens (GameObjectContainer container) {

		//TODO fill with your code
		int numRegRows = game.getLevel().getNumRowsRegularAliens();
		int numRegAliens = game.getLevel().getNumRegularAliens();
		int numPerRow = numRegAliens / numRegRows;
		int start = (9 - numPerRow) / 2;
		for (int i = 0; i < numRegRows; i++) {
			for (int j = 0; j < numPerRow; j++) {
				Position position = new Position(start + j, i + 1);
				container.add(new RegularAlien(game, position, this));
			}
		}
		//		container.add(new RegularAlien(....));
	}
	
	private void initializeDestroyerAliens(GameObjectContainer container) {
		//TODO fill with your code
		int numDesAliens = game.getLevel().getNumDestroyerAliens();
		int start = (9 - numDesAliens) / 2;
		int row = game.getLevel().getNumRowsRegularAliens() + 1;
		for (int i = 0; i < numDesAliens; i++) {
			Position position = new Position(start + i, row);
			container.add(new DestroyerAlien(game, position, this));
		}
	}

	public boolean shouldMove() {
		return (edge || (turnsWaited == speed));
	}
	
	//TODO fill with your code
	
	public int getRemainingAliens() {
		return remainingAliens;
	}
	
	public Move getDirection() {
		return dir;
	}

	public boolean onLastRow() {
		// TODO Auto-generated method stub
		return false;
	}

	public void alienDeath() {
		remainingAliens--;
	}
	
	public void alienSpawn() {
		remainingAliens++;
	}

	public void orienter() {
		if (shouldMove()) {
			if (edge) {
				if (dir.equals(Move.DOWN)) {
					if (wasLeft) {
						dir = Move.RIGHT;
					} else {
						dir = Move.LEFT;
					}
					edge = false;
				} else {
					dir = Move.DOWN;
				}
			}
		}
	}
	
	public void resolveWaitTime() {
		if (shouldMove()) {
//			if (edge && !(turnsWaited == speed)) {
//				edge = false;
//			}
			turnsWaited = 0;
		} else {
			turnsWaited++;
		}
	}
}
