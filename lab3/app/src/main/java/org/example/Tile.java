package org.example;
import java.util.ArrayList;

public class Tile {
    private int xPosition;
    private int yPosition;
    private GameObjects obj;
    //private boolean occoupiad = false;

    public Tile(int xPosition, int yPosition, GameObjects obj){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.obj = obj;
        //this.occoupiad = occoupiad;
    }

    public int getX(){
        return xPosition;
    }
    public int getY(){
        return yPosition;
    }

    public GameObjects getObject(){
        return obj;
    }

    public void setX(int x){
        this.xPosition = x;
    }
    public void setY(int y){
        this.yPosition = y;
    }
    public void setObject(GameObjects obj){
        this.obj = obj;
    }
    public void removeObject(GameObjects obj){
        this.obj = null;
    }
}
