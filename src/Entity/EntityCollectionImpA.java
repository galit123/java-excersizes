package Entity;

import java.util.LinkedHashSet;

public class EntityCollectionImpA implements EntityCollection {
	
	private LinkedHashSet<Entity> col = new LinkedHashSet<Entity>(); 
	
	@Override
	public void add(Entity e) {
		col.add(e);  // O(1)
	}

	@Override
	public Entity removeMaxValue() { 
		Entity max = null;
		for (Entity e: col){
			if ((max == null) || (e.getValue() > max.getValue())){
				max = e;
			}
		}
	
		if (max != null){
			col.remove(max);
		}
		return max;
	}

	@Override
	public String toString() {
		return "collection=" + col;
	}

}
