package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class GameObjectsTest {
    Tile[][] map = Action.creatEmptyMap();

        @Test void testGetRandomObject(){
        ArrayList<Integer> cords = Action.getRandomCoordinates(map);
        int x = cords.get(1);
        System.out.println(x);
        int y = cords.get(1);
        System.out.println(y);
        assertEquals(2, cords.size());
        assertTrue(x >= 0 && x <=10);
        assertTrue(y >= 0 && y <=10);
        Dog dog = new Dog(1, 1);
        map[x][y].setObject(dog);
        assertNotNull(map[x][y].getObject());
    }

    @Test void GetObjectFromType(){
        GameObjects dog = Action.getObjectFromType(Dog.class, 3, 5);

        assertNotNull(dog);
        assertTrue(dog instanceof Dog);
        assertEquals(3, dog.getX());
        assertEquals(5, dog.getY());

        GameObjects cat = Action.getObjectFromType(Cat.class, 1, 1);
        assertNotNull(cat);
        assertTrue(cat instanceof Cat);
        assertEquals(1, cat.getX());
        assertEquals(1, cat.getY());

        GameObjects fox = Action.getObjectFromType(Fox.class, 2, 2);
        assertNotNull(fox);
        assertTrue(fox instanceof Fox);
        assertEquals(2, fox.getY());
        assertEquals(2, fox.getY());

        GameObjects Bush = Action.getObjectFromType(Bush.class, 5, 5);
        assertNotNull(Bush);
        assertTrue(Bush instanceof Bush);
        assertEquals(5, Bush.getX());
        assertEquals(5, Bush.getY());

        GameObjects tree = Action.getObjectFromType(Tree.class, 7, 7);
        assertNotNull(tree);
        assertTrue(tree instanceof Tree);
        assertEquals(7, tree.getX());
        assertEquals(7, tree.getY());

        GameObjects rock = Action.getObjectFromType(Rock.class, 5, 2);
        assertNotNull(rock);
        assertTrue(rock instanceof Rock);
        assertEquals(5, rock.getX());
        assertEquals(2, rock.getY());
    }

    @Test void checkAllObjInMap() {
        // Create a new map
        Tile[][] map = Action.creatEmptyMap();
        
        // Call the method to place 10 random objects
        Action.get10RandomObjects(map);
        
        // Initialize counters for each type
        int dogCount = 0;
        int catCount = 0;
        int foxCount = 0;
        int rockCount = 0;
        int treeCount = 0;
        int bushCount = 0;
        int totalObjectCount = 0;
    
        // Iterate through the map and count objects
        for (Tile[] row : map) {
            for (Tile tile : row) {
                GameObjects obj = tile.getObject();
                if (obj != null) {
                    totalObjectCount++;  // Count the total number of objects
                    if (obj instanceof Dog) dogCount++;
                    if (obj instanceof Cat) catCount++;
                    if (obj instanceof Fox) foxCount++;
                    if (obj instanceof Rock) rockCount++;
                    if (obj instanceof Tree) treeCount++;
                    if (obj instanceof Bush) bushCount++;
                }
            }
        }
    
        // Assert that the total number of objects is 10
        assertEquals(10, totalObjectCount, "There should be exactly 10 objects on the map.");
    
        // Assert that at least one of each type exists
        assertTrue(dogCount > 0, "There should be at least one Dog.");
        assertTrue(catCount > 0, "There should be at least one Cat.");
        assertTrue(foxCount > 0, "There should be at least one Fox.");
        assertTrue(rockCount > 0, "There should be at least one Rock.");
        assertTrue(treeCount > 0, "There should be at least one Tree.");
        assertTrue(bushCount > 0, "There should be at least one Bush.");
    }
}
