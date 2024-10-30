package org.example;

public class Cat extends Animal {
    private final String symbol = "🐱";
    private final String sound = "Meow";

    public Cat(int x_position, int y_position){
        super(x_position, y_position);
    }

    public String getSymbol() {
        return this.symbol;
    }
    public String getSound() {
        return this.sound;
    }
}
