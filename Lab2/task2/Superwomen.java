package task2;

public class Superwomen extends Person {
    private int speed;
    private boolean fly;
    private String costumeColor;
    

    public Superwomen(String costumeColor, boolean fly, int speed, String firstName, String lastName, int birthYear) {
        super(firstName, lastName, birthYear);
        this.costumeColor = costumeColor;
        this.fly = fly;
        this.speed = speed;
    }

    // Getters
    public String getCostumeColor() {
        return costumeColor;
    }


    public boolean canFly() { 
        return fly;
    }

    public int getSpeed() {
        return speed;
    }

    // Setters


    public void setCostumeColor(String costumeColor) {
        this.costumeColor = costumeColor;
    }


    public void setFly(boolean fly) {
        this.fly = fly;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Superwoman: " + getFirstName() + " " + getLastName() + " Powers: Costume Color = " 
               + costumeColor + ", Can Fly = " + fly + ", Speed = " + speed + ", md5: " + hashMd5();
    }
}