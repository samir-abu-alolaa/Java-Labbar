package task2;
import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Person> members;


    public Team(String name){
        this.name = name;
        this.members = new ArrayList<>();
    }

    public void addMember(Person person){
        members.add(person);
    }

    public void removeAll(){
        members.clear();
    }
    public ArrayList<Person> getAll(){
        return members;
    }
    public String getTeamName(){
        return name;
    }

}
