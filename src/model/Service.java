package model;

public class Service {
    private String name;
    private int money;

    public Service() {
    }

    public Service(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Service:" +
                "name=:" + name + '\'' +
                ", money=:" + money
               ;
    }
}


