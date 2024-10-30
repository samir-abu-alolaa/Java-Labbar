package org.example;


public interface GameObjects {
    
    int getX();
    int getY();
    boolean isMovable();
    void setX(int x);
    void setY(int y);
    String getSymbol();
    String getSound();
    
}