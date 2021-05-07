package views;

import controller.BillManager;
import controller.ComputerManager;
import controller.Manager;
import controller.PlayerManager;
import model.Bill;
import model.Computer;
import model.Player;
import model.Service;
import storage.FileManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Method {
//    private static Pattern pattern;
//    private static Matcher matcher;
    private  static Scanner scanner = new Scanner(System.in);
    private  static ArrayList<Player> playerList = new ArrayList();
    private  static ArrayList<Computer> computerList=new ArrayList();
    private  static ArrayList<Bill> billList = new ArrayList();

    Manager playerManager = new PlayerManager(playerList);
    Manager computerManager = new ComputerManager(computerList);
    Manager billManager = new BillManager(billList);
    private static FileManager fileManager= FileManager.getInstance();





    public Method() {
        try {
            this.playerList = fileManager.readFile("playerFile");
            this.computerList = fileManager.readFile("computerFile");
            this.computerList = fileManager.readFile("billFile");
        }catch (Exception e){
            System.err.println("Đọc file thất bại");
        }
    }


    public  Player  inputPlayerAcount() {
        String id = inputIdPlayer();
        String pass= inputPassPlayer();
//        Player newPlayer = new Player(id, pass);
//        playerList.add(newPlayer);
        return new Player(id, pass);
    }
    private String inputIdPlayer(){
        Boolean check = false;
        String id = "";
        do {
            System.out.println("Nhập ID của người chơi");
            id = new Scanner(System.in).nextLine();
            check = checkIDPlayer(check, id);

        }while(check);
        return id;
    }
    private Boolean checkIDPlayer(Boolean check, String id) {
        for (Player p:playerList
             ) {
            if (p.getId().equals(id)){
                check = true;
                break;
            }
        }
        if (!id.matches("^[//w._-]{6,15}$")){
            check = true;
        }
        return check;
    }
    private String inputPassPlayer(){
        Boolean check = false;
        String pass = "";
        do {
            System.out.println("Nhập mật khẩu của người chơi");
            pass = new Scanner(System.in).nextLine();
            check = checkPassPlayer(check, pass);

        }while(check);
        return pass;
    }
    private Boolean checkPassPlayer(Boolean check, String pass) {
        for (Player p:playerList
        ) {
            if (p.getPass().equals(pass)){
                check = true;
                break;
            }
        }
        if (pass ==""){
            check = true;
        }
        if (!pass.matches("^[//w._-]{6,10}$")){
            check = true;
        }
        return check;
    }


    public Computer inputComputer(){
        String id = inputIdComputer();
        return new Computer(id);
    }
    private String inputIdComputer(){
        Boolean check = false;
        String id = "";
        do {
            System.out.println("Nhập ID của máy mới theo M00");
            id = new Scanner(System.in).nextLine();
            check = checkIdComputer(check, id);

        }while(check);
        return id;
    }
    private Boolean checkIdComputer(Boolean check, String id) {
        for (Computer c:computerList
        ) {
            if (c.getId().equals(id)){
                check = true;
                break;
            }
        }

        if (!id.matches("^M[0-9]{2}$")){
            check = true;
        }
        return check;
    }

    public Service inputSerive(){
        String nameOfService = inputNameOfService();
        int priceOfService = inputPriceOfService();
        return new Service(nameOfService, priceOfService);
    }
    private String inputNameOfService(){
        Boolean check= false;
        String name= "";
        do{
            System.out.println("Nhập tên dịch vụ");
            name = new Scanner(System.in).nextLine();
            check = checkNameOfSerive( name);
        }while(true);

        return name;
    }
    private Boolean checkNameOfSerive( String name) {
        for (Player p:playerList
        ) {
            if (p.getId().equals(name)){
                return true;
            }
        }
        if (!name.matches("^[A-Z]{1}[a-zA-Z]{3,15}$")){
            return true;
        }
        return false;
    }
    private int inputPriceOfService(){
        Boolean check= false;
        int price;
        do{
            System.out.println("Nhập giá của dich vụ");
            try{
                price = new Scanner(System.in).nextInt();
            }catch(Exception e){
                System.out.println("Bạn nhập không đúng dạng số nguyên dương");
                check = true;
            }
        }while(true);

        return price;
    }



    public void addPlayerAcount(){
        Player newPlayer = inputPlayerAcount();
        playerManager.add(newPlayer);
    }
    public void addComputer(){
        Computer newComputer = inputComputer();
        computerManager.add(newComputer);
    }













}
