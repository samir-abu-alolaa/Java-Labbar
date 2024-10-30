package org.example;

public class Rock extends EnvairomentalObjects {
    private final String symbol = "🪨 ";
    private final String sound = "Silence";
    
public Rock(int x_position, int y_position){
    super(x_position, y_position);
}
public String getSymbol() {
    return this.symbol;
}
public String getSound() {
    return this.sound;
}
}
