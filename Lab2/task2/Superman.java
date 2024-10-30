package task2;

public class Superman extends Person{
    private int strength;
    private boolean xRay;
    private String costumeColor;
    

public Superman(String costumeColor, boolean xRay, int strength, String firstName, String lastName, int birthYear){
    super(firstName, lastName, birthYear);
    this.costumeColor = costumeColor;
    this.xRay = xRay;
    this.strength = strength;
}


public String getCostumeColor() {
    return costumeColor;
}
public boolean hasXRay(){
    return xRay;
}

public int getStrenghLevel(){
    return strength;
}


public void setCostumeColor(String costumeColor) {
    this.costumeColor = costumeColor;
}
public void setXRay(boolean xRay){
    this.xRay = xRay;
}

public void setStrenghtLevel(int strength){
    this.strength = strength;
}

// Getters eller protected för att få dem bli synliga
public String toString() {
    return "Superman: " + getFirstName() + " " + getLastName() + " Powers: Costume Color = " 
           + costumeColor + ", X-Ray Vision = " + xRay + ", Strength Level = " + strength+ ", md5: " + hashMd5() ;
}
}