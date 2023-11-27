package tp1.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import tp1.logic.gameobjects.Attributes;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.Space;
import tp1.logic.gameobjects.UCMLaser;
import tp1.logic.gameobjects.UCMShip;
import tp1.logic.gameobjects.Ufo;
import tp1.view.Messages;


public class Game implements GameStatus, GameModel, GameWorld {

	//TODO fill with your code

	public static final int DIM_X = 9;
	public static final int DIM_Y = 8;
	
	private GameObjectContainer container;
	private UCMShip player;
	private AlienManager alienManager;
	private int currentCycle;
	
	private long seed;
//	private Move direction = Move.LEFT;
	private Level level;
	private Random random;
	private Space space = new Space();
	private UCMLaser currentLaser;
//	private Ufo ufo = new Ufo(this, null, alienManager);
//	private GameObject[][] board;
	private Map<String, Boolean> state = new HashMap<String, Boolean>() {{
        put("laser", false);
        put("edge", false);
        put("ufo", false);
        put("shockwave", false);
        put("running", true);
        put("finished", false);
   }};
	private Map<String, Integer> metrics = new HashMap<String, Integer>() {{
	     put("points", 0);
	     put("cycles", 0);
	     put("aliens", 0);
	     put("speed", 0);
	     put("wait", 0);
	}};
	
	//TODO fill with your code

	public Game (Level level, long seed) {
		//TODO fill with your code
		this.level = level;
        this.seed = seed;
        this.random = new Random(seed);
        this.alienManager = new AlienManager(this);
		initGame();
	}
		
	private void initGame () {	
		//TODO fill with your code
		currentCycle = 0;
		this.container = alienManager.initialize();
		this.player = new UCMShip(this, new Position(DIM_X / 2, DIM_Y - 1));
		container.add(player);
	}
	
	/**
	 * Change boolean game attributes
	 * 
	 * @param field Name of attribute
	 * @param value Value that the attribute should be
	 */
	public void changeState(String field, Boolean value) {
		state.put(field, value);
	}
	
	/**
	 * Access boolean game attributes
	 * 
	 * @param field Name of attribute 
	 * @return Boolean value corresponding to attribute
	 */
	
	public boolean getState(String field) {
		return state.get(field);
	}
	
	/**
	 * Access integer game attributes
	 * 
	 * @param field Name of attribute 
	 * @return Integer value corresponding to attribute
	 */
	
	public int getMetric(String field) {
		return metrics.get(field);
	}
	
	/**
	 * Change integer game attributes
	 * 
	 * @param field Name of attribute
	 * @param value Value that the attribute should be
	 */
	
	public void changeMetric(String field, int value) {
		metrics.put(field, metrics.get(field) + value);
	}

	//CONTROL METHODS
	
	public boolean isFinished() {
		// TODO TEST!!
		return (playerWin() || aliensWin() || getState("finished"));
	}

	public void exit() {
		// TODO Want to remove state fields
		changeState("finished", true);
		return;
	}

	public void update() {
	    this.currentCycle++;
	    alienManager.orienter();
	    this.container.computerActions();
	    this.container.automaticMoves();
	    alienManager.resolveWaitTime();
	}

	// TODO fill with your code

	//CALLBACK METHODS
	
	/**
	 * Returns a value that determines when it is permitted to move for entities that are affected by speed
	 * 
	 * @return A boolean representing whether the cycle and speed coincide
	 */
	
//	public boolean shouldMove() {
//		return (getState("edge") || (getMetric("wait") == getMetric("speed")));
//	}
	
	public void addObject(GameObject object) {
	    this.container.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.container.remove(object);
	}

	// TODO fill with your code
	
	//VIEW METHODS
	
	public String positionToString(int col, int row) {
//		return board[row][col].getSymbol();
		return container.toString(new Position(col, row));
	}
	
	

	@Override
	public String infoToString() {
		// TODO fill with your code
		StringBuilder buffer = new StringBuilder();
		String NEW_LINE = System.lineSeparator();
		buffer.append(Messages.ucmShipDescription(Messages.UCMSHIP_DESCRIPTION, Attributes.Player.endurance, Attributes.Player.damage))
		.append(NEW_LINE)
		.append(Messages.alienDescription(Messages.REGULAR_ALIEN_DESCRIPTION, Attributes.RegularAlien.points, Attributes.RegularAlien.damage, Attributes.RegularAlien.endurance))
		.append(NEW_LINE)
		.append(Messages.alienDescription(Messages.DESTROYER_ALIEN_DESCRIPTION, Attributes.DestroyerAlien.points,  Attributes.DestroyerAlien.damage, Attributes.DestroyerAlien.endurance))
		.append(NEW_LINE)
		.append(Messages.alienDescription(Messages.UFO_DESCRIPTION, Attributes.Ufo.points,  Attributes.Ufo.damage,  Attributes.Ufo.endurance))
		.append(NEW_LINE);
		
		return buffer.toString();
	}

	@Override
	public String stateToString() {
		StringBuilder buffer = new StringBuilder();
		String NEW_LINE = System.lineSeparator();
		String SPACE = " ";
		buffer.append(Messages.LIFE).append(SPACE).append(player.getLife()).append(NEW_LINE)
		.append(Messages.POINTS).append(SPACE).append(getMetric("points")).append(NEW_LINE)
		.append(Messages.SHOCKWAVE).append(SPACE).append(player.getShockwave() ? "ON" : "OFF").append(NEW_LINE);
		return buffer.toString();
//		return null;
	}

	@Override
	public boolean playerWin() {
		// TODO TEST!!
		return (alienManager.getRemainingAliens() == 0);
	}

	@Override
	public boolean aliensWin() {
		return (!(player.isAlive()) || alienManager.onLastRow());
//		for (Entity entity : entities) {
//			if ((entity instanceof RegularAlien || entity instanceof DestroyerAlien) 
//					&& Position.onLastRow(entity.getPosition())) {
//				return true;
//			}
//		}
	}

	@Override
	public int getCycle() {
		// TODO TEST!!
		return currentCycle;
	}

	@Override
	public int getRemainingAliens() {
		// TODO fill with your code
		return alienManager.getRemainingAliens();
	}

	public Random getRandom() {
		return this.random;
	}

	public Level getLevel() {
		return this.level;
	}

	@Override
	public boolean move(Move move) {
		// TODO Test
		return player.move(move);
	}

	@Override
	public boolean shootLaser() {
		// TODO Test
		return player.shoot();
	}

	@Override
	public void reset() {
		// TODO Test
		this.random = new Random(seed);
		initGame();
		return;
	}
	
	@Override
	public boolean shockwave() {
		return player.shockwave();
	}
}
