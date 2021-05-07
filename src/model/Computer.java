package model;

import java.io.Serializable;

public class Computer implements Serializable {
    private String id;
    private Boolean status = false;
    private Player playerOfGame;


    public Computer() {

    }

    public Computer(String id) {
        this.id = id;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getOnComputer(){
        if(!getStatus()){
            return true;
        }
        return getStatus();
    }

    @Override
    public String toString() {
        return "Computer:"  +
                "id='" + id + '\'' +
                ", status=" + status +
                ", playerOfGame=" + playerOfGame               ;
    }
}
