package Entity;

import java.util.ArrayList;

public class EntityCollectionImpC implements EntityCollection{
	
	private ArrayList<Entity> col = new ArrayList<Entity>(); 

	@Override
	public void add(Entity entity) {
		if (!col.contains(entity)){ // O(n)
			col.add(entity);
			col.sort(EntityComparator.instance); //O(n)
		}	
	}

	@Override
	public Entity removeMaxValue() {
		if (!col.isEmpty()){ // O(1)
			return col.remove(col.size() - 1); //O(1)
		}
		return null;
	}

	@Override
	public String toString() {
		return "collection=" + col;
	}

}
