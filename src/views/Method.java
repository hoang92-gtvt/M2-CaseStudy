package views;

import controller.BillManager;
import controller.ComputerManager;
import controller.Manager;
import controller.PlayerManager;
import controller.getElement.GetComputer;
import controller.getElement.GetComputerByID;
import controller.getElement.GetElement;
import controller.getElement.GetPlayerByID;
import model.Bill;
import model.Computer;
import model.Player;
import model.Service;
import storage.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Method {

    private static FileManager fileManager = FileManager.getInstance();
    private static ArrayList<Player> playerList;
    private static ArrayList<Computer> computerList;
    private static ArrayList<Bill> billList;


    private final static Service service1 = new Service("nuocngot", 13000);
    private final static Service service2 = new Service("bim bim", 8000);

    static Manager playerManager;
    static Manager computerManager;
    static Manager billManager;



    public Method() {
        try {
            playerList = fileManager.readFile("playerFile.txt");
            computerList = fileManager.readFile("ComputerFile.txt");
            billList = fileManager.readFile("billFile.txt");

            playerManager = new PlayerManager(playerList);
            computerManager =new ComputerManager(computerList);
            billManager = new BillManager(billList);

        }catch (Exception e){
            System.err.println("Đọc file thất bại");
        }
    }

    public void showNumberOfComputer(){
        int number = computerManager.list.size();
//        int numberOfComputer = computerList.size();
        System.out.println("Phòng đang có " + number + "máy tính");
    }

    public void addComputer(){
        Computer newComputer = inputComputer();
        computerManager.add(newComputer);

    }

    public void deleteComputer(){
        System.out.println("Nhập id của máy tính muốn xóa");
        String id = new Scanner(System.in).nextLine();

        GetComputer element = new GetComputerByID();
        Computer deleteComputer = element.getElement(computerManager.getList(),id);
        computerManager.delete(deleteComputer);

    }

    public void updateComputer(){
        System.out.println("Nhập tên id máy cần thay");
        String id = new Scanner(System.in).nextLine();

        GetComputer element = new GetComputerByID();
        Computer editComputer = element.getElement(computerManager.getList(),id);

        System.out.println("Nhập giá trị id mới cho máy");
        String newId = new Scanner(System.in).nextLine();
        computerManager.edit(editComputer,newId);

    }

    public void showComputerList(){
        ArrayList<Computer> computerList = computerManager.getList();
        System.err.println("Danh sách máy tính trong quán nét ");
        for (Computer c:computerList ) {
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
        ArrayList<Computer> computerList = computerManager.getList();
        for (Computer c:computerList
        ) {
            // "trạng thái off tương ứng với false
            if(!c.getStatus()){
                System.out.println(c);
            }

        }
    }

    public void getMoneyForPlayer(){
        Bill newbill= inputBill();
        int choice;
        do {
            System.out.println("Lựa chọn dịch vụ nếu có");
            System.out.println("1: Nước ngot");
            System.out.println("2: bim bim");
            System.out.println("3: Không thêm dịch vụ gì");
            choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    newbill.addServiceForBill(service1);
                    break;
                case 2:
                    newbill.addServiceForBill(service2);
                    break;
                case 3:
                     break;
                default:
                    System.out.println("bạn muốn thêm dịch vụ nào ko");
                    System.out.println("4: Yes");
                    System.out.println("5: No");
                    int choice2 = new Scanner(System.in).nextInt();
                    if (choice2==4){
                        choice=0;
                    }else choice=3;
            }
        }while(choice==0);
        System.out.println("Số tiền khách phải trả là : "+ newbill.getMoney());
        billManager.add (newbill);

    }

    public void addPlayerAcount(){
        Player newPlayer = inputPlayerAcount();
        playerManager.add(newPlayer);
    }

    public void deletelayerAcount(){
        System.out.println("Nhập id của tài khoản muốn xóa");
        String id = new Scanner(System.in).nextLine();

        GetPlayerByID element = new GetPlayerByID();
        Player deletePlayer = element.getElement(playerManager.getList(),id);
        playerManager.delete(deletePlayer);

    }
    public void showAcountPlayerList(){
        ArrayList<Player> playerList = playerManager.getList();
        for (Player p:playerList ) {
            System.out.println(p);
        }
    }

    public void showBillList(){
        ArrayList<Bill> billList = billManager.getList();
        for (Bill b:billList ) {
            System.out.println(b);
        }
    }

    public void getSumMoneyOnDay(){

    }


    public  Player  inputPlayerAcount() {
        String id = inputIdPlayer();
        String name = inputNameAcount();
        String pass= inputPassPlayer();

//        Player newPlayer = new Player(id, pass);
//        playerList.add(newPlayer);
        return new Player(id,name, pass);
    }

    private String inputIdPlayer(){
        Boolean check = false;
        String id = "";
        do {
            System.out.println("Nhập ID của người chơi theo P00");
            id = new Scanner(System.in).nextLine();
            check = checkIDPlayer(check, id);

        }while(check);
        return id;
    }
    private Boolean checkIDPlayer(Boolean check, String id) {
        ArrayList<Player> playerList = playerManager.getList();
        check =false;
        for (Player p : playerList)
            if (p.getId().equals(id)) {
                System.out.println("Đã tồn tại tên người chơi");
                return true;
            }
        if (!id.matches("^P[0-9]{2}$")){
            check = true;
            System.out.println("chưa nhập đúng định dạng");
        }
        return check;
    }
    private String inputNameAcount(){
        Boolean check = false;
        String name = "";
        do {
            System.out.println("Nhập name của người chơi theo chữ không dấu");
            name = new Scanner(System.in).nextLine();
            check = checkNamePlayer(check, name);

        }while(check);
        return name;
    }
    private Boolean checkNamePlayer(Boolean check, String name) {
        check = false;
        ArrayList<Player> playerList = playerManager.getList();
        for (Player p:playerList) {
            if (p.getNameAcount().equals(name)){
                return true;
            }
        }
        if (!name.matches("^[\\w\\._]{6,15}$")){
            check = true;
        }
        return check;
    }
    private String inputPassPlayer(){
        Boolean check = false;
        String pass = "";
        do {
            System.out.println("Nhập mật khẩu của người chơi từ 6-15 ký tự không dấu");
            pass = new Scanner(System.in).nextLine();
            check = checkPassPlayer(check, pass);

        }while(check);
        return pass;
    }
    private Boolean checkPassPlayer(Boolean check, String pass) {
        check = false;
        ArrayList<Player> playerList = playerManager.getList();
        for (Player p:playerList) {
            if (p.getPass().equals(pass)){
                return true;
            }
        }
        if (pass ==""){
            check = true;
        }
        if (!pass.matches("^[\\w\\._]{6,15}$")){
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
        ArrayList<Computer> computerList = computerManager.getList();
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

        }while(check);

        return name;
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
        int price = 0 ;
        do{
            System.out.println("Nhập giá của dich vụ");
            try{
                price = new Scanner(System.in).nextInt();
            }catch(Exception e){
                System.out.println("Bạn nhập không đúng dạng số nguyên dương");
                check = true;
            }
        }while(check);

        return price;
    }


    public Bill inputBill(){
        System.out.println("Nhập mã Bill theo định dạng B01.dd.MM.yyyy");
        String newId = inputIdBill();

        Player player = inputPlayerOfBill();
        Computer computerForPlayer = inputComputerForPlayer();
        player.setComputer(computerForPlayer);

        int hourOfGame = inputHourOfGame();

        return new Bill(newId, player, hourOfGame);
    }
    private String inputIdBill() {
        Boolean check = false;
        String id= "";
        do {

            System.out.println("Nhập mã Bill theo định dạng B01.dd.MM.yy");
            id = new Scanner(System.in).nextLine();
            check = checkIdBill(id);
        }while(check);
        return id;
    }
    private Boolean checkIdBill(String id){
        ArrayList<Bill> billList = billManager.getList();
        if(!id.matches("^B[0-9]{2}(\\.[0-9]{2}){3}$")){
            return true;
        }else {
            for (Bill b : billList) {
                if (b.getId().equals(id)) {
                    return true;
                }
            }
            return false;
        }
    }
    private Player inputPlayerOfBill(){
        System.out.println("Nhập mã id người chơi sử dụng dịch vụ P00");
        String idOfPlayer = new Scanner(System.in).nextLine();

        GetPlayerByID getPlayerByID = new GetPlayerByID();
        Player  player = getPlayerByID.getElement(playerList, idOfPlayer);
        while(player==null){
            System.out.println("1: Bạn muốn nhập lại");
            System.out.println("2: Bạn muốn thêm mới");
            int choice = new Scanner(System.in).nextInt();
            switch (choice){
                case 1:
                    System.out.println("Nhập mã id người chơi sử dụng dịch vụ P00");
                    idOfPlayer = new Scanner(System.in).nextLine();
                    player = getPlayerByID.getElement(playerList, idOfPlayer);
                    break;
                case 2:
                    player = inputPlayerAcount();
                    playerManager.add(player);

                    break;
                default:
                    System.out.println("Hãy nhập đúng số dạng 1 và 2");
                    break;
            }
        }
        return player;
    }
    private Computer inputComputerForPlayer(){
        for (Computer p:computerList
             ) {
            if(!p.getStatus()) {
                p.getOnComputer();
                return p;
            }
        }
        return null;
    }
    private int inputHourOfGame(){
        System.out.println("Nhập số giờ chơi");
        int hour =0;
        do{
            try {
                hour = new Scanner(System.in).nextInt();
                return hour;
            }catch (Exception e){
                System.err.println("Bạn cần nhập số nguyên dương");
            }
        }while(true);

    }










}
