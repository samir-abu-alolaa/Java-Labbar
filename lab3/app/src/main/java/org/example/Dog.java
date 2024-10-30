package org.example;

public class Dog extends Animal  {
    private final String symbol = "🐶";
    private final String sound = "Wouf";

    public Dog(int x_position, int y_position){
        super(x_position, y_position);
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    public String getSound() {
        return this.sound;
    }

}
