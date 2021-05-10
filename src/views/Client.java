package views;

import storage.FileManager;

import java.util.Scanner;

public class Client {
    static final String NAME="hoang";
    static final String PASS="danphuong";
    public static void showMain() {
        System.out.println("------------Quản lý phòng net Creat by HoangNguyen--------");
        System.out.println("1. Hiện thị số lương máy trong quán");
        System.out.println("2. Thêm một máy mới vào sử dụng");
        System.out.println("3. Sửa thông tin của một máy");
        System.out.println("4. Loại bỏ một máy không sử dụng");
        System.out.println("5. Hiện thị danh sách máy tính ");
        System.out.println("6. Danh sách máy đang online ");
        System.out.println("7. Danh sách máy đang offline");
        System.out.println("8. Tính tiền cho khách");
        System.out.println("9. Thêm tài khoản đăng nhập mới");
        System.out.println("10. Xóa bỏ một tài khoản cũ");
        System.out.println("11. Hiện thị danh sách Acount");
        System.out.println("12. Hiện thị danh sach Bill");
        System.out.println("13. Doanh thu trong một ngày");
        System.out.println("14. Thêm người sử dụng máy tính");
        System.out.println("15. Danh sách người đang chơi game");
        System.out.println("0. Exit");
    }
    public static void loginAcount(){
        int count = 3;
        do {
            System.out.println("Tên đăng nhập");
            String name = new Scanner(System.in).nextLine();
            System.out.println("Nhập mật khẩu đăng nhập");
            String pass = new Scanner(System.in).nextLine();
            if (name.equals(NAME) && pass.equals(PASS)) {
                return;
            }else {
                System.out.println("Bạn nhập sai dữ liệu, số lượng lần đăng nhập là 3");
                count--;
            }
        }while(count>0);
        if (count==0){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
//        loginAcount();
        FileManager fileManager= FileManager.getInstance();
        Method method = new Method();
        Scanner sc = new Scanner(System.in);

        String choice = "";
        do {
            showMain();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    method.showNumberOfComputer();
                    break;
                case "2":
                    method.addComputer();
                    break;
                case "3":
                    method.updateComputer();
                    break;
                case "4":
                    method.deleteComputer();
                    break;
                case "5":
                    method.showComputerList();
                    break;
                case "6":
                    method.showComputerOn();
                    break;
                case "7":
                    method.showComputerOff();
                    break;
                case "8":
                    method.getMoneyForPlayer();
                    break;

                case "9":
                    method.addPlayerAcount();
                    break;
                case "10":
                    method.deletelayerAcount();
                    break;
                case "11":
                    method.showAcountPlayerList();
                    break;
                case "12":
                    method.showBillList();
                    break;
                case "13":
                    method.getSumMoneyOnDay();
                    break;
                case "14":
                    method.setComputerForPlayer();
                    break;
                case "15":
                    method.showPlayerOnGameList();
                    break;

                case "0":
                    System.exit(-1);
            }
        }while (true);


    }


}
