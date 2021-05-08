package views;

import controller.BillManager;
import controller.ComputerManager;
import controller.Manager;
import controller.PlayerManager;
import controller.getElement.GetComputer;
import controller.getElement.GetComputerByID;
import controller.getElement.GetElement;
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
                return true;
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
                return true;
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
        check = false;
        for (Computer c:computerList
        ) {
            if (c.getId().equals(id)){
                return true;
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
        String name = "";
        do{

            System.out.println("Nhập tên dịch vụ");
            name = new Scanner(System.in).nextLine();
            check = checkNameOfSerive( name);
        }while(true);

//        return name;
    }
    private Boolean checkNameOfSerive( String name) {
        if (!name.matches("^[A-Z]{1}[a-zA-Z]{3,15}$")){
            return true;
        }else{
            for (Player p:playerList
            ) {
                if (p.getId().equals(name)){
                    return true;
                }
            }
            return false;
        }
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

//        return price;
    }



    public void addPlayerAcount(){
        Player newPlayer = inputPlayerAcount();
        playerManager.add(newPlayer);
    }


    public void addComputer(){
        Computer newComputer = inputComputer();
        computerManager.add(newComputer);

    }


    public void deleteComputer(){
        System.out.println("Nhập id của máy tính muốn xóa");
        String id = new Scanner(System.in).nextLine();

        GetComputer element = new GetComputerByID();
        Computer deleteComputer = element.getElement(computerList,id);
        computerManager.delete(deleteComputer);

    }


    public void showNumberOfComputer(){
//        int number = computerManager.getNumberOfComputer();
        int numberOfComputer = computerList.size();
        System.out.println("Phòng đang có " + numberOfComputer + "máy tính");
    }


    public void updateComputer(){
        System.out.println("Nhập tên id máy cần thay");
        String id = new Scanner(System.in).nextLine();

        GetComputer element = new GetComputerByID();
        Computer editComputer = element.getElement(computerList,id);

        System.out.println("Nhập giá trị id mới cho máy");
        String newId = new Scanner(System.in).nextLine();
        computerManager.edit(editComputer,newId);

    }


    public void showComputerList(){
        for (Computer c:computerList
             ) {
            System.out.println(c);
        }
    }


    public void showComputerOn(){
        for (Computer c:computerList
             ) {
            // "trạng thái online tương ứng với true
            if(c.getStatus()){
                System.out.println(c);
            }

        }
    }

    public void showComputerOff(){
        for (Computer c:computerList
        ) {
            // "trạng thái off tương ứng với false
            if(!c.getStatus()){
                System.out.println(c);
            }

        }
    }

    public void getMoneyForPlayer(){

    }
//    public Bill inputBill(){
//        System.out.println("Nhập mã Bill theo định dạng B01.dd.MM.yyyy");
//        String newId = inputIdBill();
//    }

    private String inputIdBill() {
        Boolean check = false;
        String id= "";
        do {

            System.out.println("Nhập mã Bill theo định dạng B01.dd.MM.yyyy");
            id = new Scanner(System.in).nextLine();
            check = checkIdBill(id);
        }while(check);
        return id;
    }
    private Boolean checkIdBill(String id){

        if(id.matches("^B[0-9]{2}(\\.[0-9]*){3}$")){
            return true;
        }
        for (Bill b:billList) {
            if(b.getId().equals(id)){
                 return true;
            }
        }
        return false;
    }



}
