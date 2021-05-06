package model;

public class Player {
    private String id;
    private String pass;
    private int numberOfHour = 1;

    public Player() {
    }

    public Player(String id, String pass, int numberOfHour) {
        this.id = id;
        this.pass = pass;
        this.numberOfHour = numberOfHour;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getNumberOfHour() {
        return numberOfHour;
    }

    public void setNumberOfHour(int numberOfHour) {
        this.numberOfHour = numberOfHour;
    }

    @Override
    public String toString() {
        return "Player: " +
                "id='" + id + '\'' +
                ", pass='" + pass + '\'' +
                ", numberOfHour=" + numberOfHour
                ;
    }
}
