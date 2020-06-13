package Entity;

import java.util.TreeSet;

public class EntityCollectionImpB implements EntityCollection {
	private TreeSet<Entity> col = new TreeSet<Entity>(EntityComparator.instance);

	@Override
	public void add(Entity entity) {
		col.add(entity); // O(log n)
	}

	@Override
	public Entity removeMaxValue() {
		if (!col.isEmpty()) {
			Entity max = col.last(); // O(log n)
			col.remove(max); // O(log n)
			return max;
		}
		return null;
	}

	@Override
	public String toString() {
		return "collection=" + col;
	}

}
