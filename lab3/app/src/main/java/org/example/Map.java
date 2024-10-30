package org.example;
import java.util.ArrayList;

public class Map {

    private int xGrid;
    private int yGrid;


    public Map(int xGrid, int yGrid){
        this.xGrid = xGrid;
        this.yGrid = yGrid;
    }
    
    public Tile[][] creatMap() {
        Tile[][] myMap = new Tile[xGrid][yGrid];  // Use xGrid and yGrid to dynamically set the grid size
        for(int i = 0; i < xGrid; i++) {
            for(int j = 0; j < yGrid; j++) {
                myMap[i][j] = new Tile(i, j, null);  // Initialize each Tile with its coordinates
            }
        }
        return myMap;  // Return the created map
    }
    
    public static void printMap(Tile[][] map){
        for(int i = 0; i < map.length; i++){
            if(i == 9){
                System.out.print(i+1 + " ");
            }else{
                System.out.print(i+1 + "  ");
            }
            for( int j = 0; j < map[i].length; j++){
                if(map[i][j].getObject() == null){
                System.out.print("⬜");
                }else{
                    System.out.print(map[i][j].getObject().getSymbol());
                }
            }
            System.out.println();
        }
    }
    
}
