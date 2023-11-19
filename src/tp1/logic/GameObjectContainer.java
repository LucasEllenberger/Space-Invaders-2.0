package tp1.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.logic.gameobjects.GameObject;

public class GameObjectContainer {

	private List<GameObject> objects;

	public GameObjectContainer() {
		objects = new ArrayList<>();
	}

	public void add(GameObject object) {
		objects.add(object);
	}

	public void remove(GameObject object) {
		objects.remove(object);
	}

	public void automaticMoves() {
		for (int i=0;i<objects.size();i++) {
				GameObject object = objects.get(i);
				//TODO fill with your code
				object.automaticMove();
		}
		//TODO fill with your code
	}

	public void computerActions() {
		// TODO fill with your code
		
	}

	public String toString(Position position) {
		// TODO Auto-generated method stub
		for (int i=0;i<objects.size();i++) {
			GameObject object = objects.get(i);
			//TODO fill with your code
			if (object.getPos().equals(position)) {
				return object.toString();
			}
	}
		return "";
	}

	//TODO fill with your code
	
}
