package task2;

public class SupermanJr extends Superman {
    private int experienceLevel; 
    private boolean training;

    public SupermanJr(String costumeColor, boolean xRay, int strength, 
                      String firstName, String lastName, int birthYear, 
                      boolean training, int experienceLevel) {

        super(costumeColor, xRay, strength, firstName, lastName, birthYear);
        this.training = training;
        this.experienceLevel = experienceLevel;
    }

    // Getter methods
    public boolean getTrainingStatus() {
        return training;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    // Method to start training
    public String startTraining() {
        training = true;
        experienceLevel += 1; // Increases experience level when training starts
        return "Training has started, experience level is now: " + experienceLevel;
    }

    // Override the toString() method to include new properties
    @Override
    public String toString() {
        return super.toString() + ", Training: " + training + ", Experience Level: " + experienceLevel+ ", md5: " + hashMd5();
    }
}
