package Entity;

import java.sql.Timestamp;
import java.util.Random;

public class Main {
	static void testPerformance(EntityCollection entities){
		Timestamp start = new Timestamp(System.currentTimeMillis());

		Random rn = new Random();
		int max = 10000;
		int min = 10;
		for (int i=0; i< 20000 ; i++){
			int range =  max - min + 1;
			int randomNum =  rn.nextInt(range) + min;
			entities.add(new EntityImp(randomNum));
		}
		
		
		for (int i=0; i< 20000 ; i++){
			entities.removeMaxValue();
		}

		Timestamp end = new Timestamp(System.currentTimeMillis());
		long delta = end.getTime() - start.getTime();
		System.out.println("Total time: " + delta + " ms");

	}
	
	static void  testImp(EntityCollection entities){
		
    	entities.add(new EntityImp(10) );
    	entities.add(new EntityImp(3) );
    	entities.add(new EntityImp(6) );
    	entities.add(new EntityImp(6) );
    	entities.add(new EntityImp(13) );
    	entities.add(new EntityImp(9) );
    	entities.add(new EntityImp(1) );
    	
    	System.out.println(entities.toString());
    	
    	Entity e = entities.removeMaxValue();
    	System.out.println("removed: " + e.toString());
    	System.out.println(entities.toString());

    	e = entities.removeMaxValue();
    	System.out.println("removed: " + e.toString());    	
    	System.out.println(entities.toString());

    	
    	entities.add(new EntityImp(200) );
    	entities.add(new EntityImp(-1) );

    	System.out.println(entities.toString());
    	
    	e = entities.removeMaxValue();
    	System.out.println("removed: " + e.toString());
    	System.out.println(entities.toString());
		
	}
	
	
    public static void main(String[] args) {
    	   	
    	System.out.println("Test implementation A - add (high), remove (low) - LinkedHashSet");
    	testImp(new EntityCollectionImpA());
    	testPerformance(new EntityCollectionImpA());
    	System.out.println();
    	
    	System.out.println("Test implementation B - add (medium), remove (medium) - TreeSet");
    	testImp(new EntityCollectionImpB());
    	testPerformance(new EntityCollectionImpB());    	
    	System.out.println();
    	
    	System.out.println("Test implementation C - add (low), remove (high) - ArrayList");
    	testImp(new EntityCollectionImpC());
    	testPerformance(new EntityCollectionImpC());
	}

}
