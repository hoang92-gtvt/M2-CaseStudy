package model;

public class Computer {
    private String id;
    private Boolean status;
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

    public Player getPlayerOfGame() {
        return playerOfGame;
    }

    public void setPlayerOfGame(Player playerOfGame) {
        this.playerOfGame = playerOfGame;
    }

    @Override
    public String toString() {
        return "Computer:"  +
                "id='" + id + '\'' +
                ", status=" + status +
                ", playerOfGame=" + playerOfGame               ;
    }
}
