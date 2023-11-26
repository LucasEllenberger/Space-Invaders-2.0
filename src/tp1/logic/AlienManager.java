package tp1.logic;

import tp1.logic.gameobjects.DestroyerAlien;
import tp1.logic.gameobjects.RegularAlien;
import tp1.logic.gameobjects.Ufo;

public class AlienManager  {
	
	private Game game;
	private int remainingAliens;
	
	//TODO fill with your code
	public AlienManager(Game game) {
		this.game = game;
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

	//TODO fill with your code
	
	public int getRemainingAliens() {
		return remainingAliens;
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

}
