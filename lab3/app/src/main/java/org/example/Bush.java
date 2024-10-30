package org.example;

public class Bush extends EnvairomentalObjects{
    private final String symbol = "🌳";
    private final String sound = "Rustle";
    
    public Bush(int x_position, int y_position){
        super(x_position, y_position);
    }
    public String getSymbol() {
        return this.symbol;
    }
    public String getSound() {
        return this.sound;
    }
}
