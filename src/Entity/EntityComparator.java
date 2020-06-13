package Entity;

import java.util.Comparator;

public enum EntityComparator implements Comparator<Entity> {
	instance;

	@Override
	public int compare(Entity e1, Entity e2) {
		return e1.getValue() - e2.getValue();
	}
}
