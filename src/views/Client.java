package views;

import java.util.Scanner;

public class Client {
    public static void showMain() {
        System.out.println("1. Hiện thị số lương máy trong quán");
        System.out.println("2. Thêm một máy mới vào sử dụng");
        System.out.println("3. Sửa thông tin của một máy");
        System.out.println("4. Loại bỏ một máy không sử dụng");
        System.out.println("5. Hiện thị danh sách máy tính ");
        System.out.println("6. Danh sách máy đang online ");
        System.out.println("7. Danh sách máy đang offline");
        System.out.println("8. Tính tiền cho khách");
        System.out.println("9. Thêm dịch vụ vào cho khách");
        System.out.println("10. Thêm tài khoản đăng nhập mới");
        System.out.println("11. Xem doanh thu của quán theo ngày");
        System.out.println("0. Exit");


    }
    public static void main(String[] args) {
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
////                case "9":
////                    method.addServiceForPlayer();
//                    break;
                case "10":
                    method.addPlayerAcount();
                    break;
//                case "11":
//                    method.getSumMoneyOnDay();
//                    break;
                case "0":
                    System.exit(-1);
            }
        }while (true);


    }

}
