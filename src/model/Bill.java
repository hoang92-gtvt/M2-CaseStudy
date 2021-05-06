package model;

import java.util.ArrayList;

public class Bill {
    public static final int COSTFORHOUR = 5000;
    private String id;
    private Player player;
    private Computer computer;
    private int hourOfGame;
    private ArrayList<Service> lisService = new ArrayList<>();

    public Bill() {
    }

    public Bill(String id, Player player, Computer computer,int hour ,ArrayList<Service> lisService) {
        this.id = id;
        this.player = player;
        this.computer = computer;
        this.hourOfGame = hour;
        this.lisService = lisService;

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
                '}';
    }
}
