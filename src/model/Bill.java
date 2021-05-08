package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Bill implements Serializable {
    public static final int COSTFORHOUR = 5000;
    private String id;
    private Player player;
    private Computer computer;
    private int hourOfGame;
    private ArrayList<Service> lisService = new ArrayList<>();
    private LocalDate date = LocalDate.now();

    public Bill() {
    }

    public Bill(String id, Player player,int hour ) {
        this.id = id;
        this.player = player;
//        this.computer = computer;
        this.hourOfGame = hour;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Computer getComputer() {
        return computer;
    }
    public void setComputer(Computer computer) {
        this.computer = computer;
    }


    public ArrayList<Service> getLisService() {
        return lisService;
    }

    public void setLisService(ArrayList<Service> lisService) {
        this.lisService = lisService;
    }

    public int getHourOfGame() {
        return hourOfGame;
    }

    public void setHourOfGame(int hourOfGame) {
        this.hourOfGame = hourOfGame;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    //phuong thuc tinh tien
    public void addServiceForBill(Service service){
        lisService.add(service);
    }

    public int getMoney(){
        int sumMoney = 0;
        for (Service s:lisService
             ) {sumMoney +=s.getMoney();
        }
        sumMoney +=this.hourOfGame* COSTFORHOUR;

        return sumMoney;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", player=" + player +
                ", computer=" + computer +
                ", hourOfGame=" + hourOfGame +
                ", lisService=" + lisService +
                ", Ngày chơi " + date +
                '}';
    }
}
