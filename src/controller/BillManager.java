package controller;

import model.Bill;
import storage.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class BillManager extends Manager<Bill> {
//    private ArrayList<Bill> listBill= new ArrayList();
    private static final String billFile = "billFile";
    public BillManager( ArrayList<Bill> listBill) {
        super.list = listBill;
    }

    @Override
    public void add(Bill element) {
        super.add(element);
        writeFile();
    }

    @Override
    public void delete(Bill element) {
        list.remove(element);
        writeFile();
    }

    @Override
    public void edit(Bill bill, String newId) {
        bill.setId(newId);
        writeFile();
    }

    private void writeFile() {
        FileManager fileManager = FileManager.getInstance();
        try {
            fileManager.writeFile(list,billFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Lưu file bị lỗi");
        }
    }
}
