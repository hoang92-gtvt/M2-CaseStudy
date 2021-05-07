package model;

import java.io.Serializable;

public class Player implements Serializable {
    private String id;
    private String pass;
    private Computer computer;
    private int numberOfHour = 1;

    public Player() {
    }

    public Player(String id, String pass) {
        this.id = id;
        this.pass = pass;

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

    public Computer getComputer() {
        return computer;
    }
    public void setComputer(Computer computer) {
        this.computer = computer;
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
