package controller;

import model.Computer;
import storage.FileManager;

import java.io.IOException;
import java.util.ArrayList;

public class ComputerManager extends Manager<Computer> {
//    private ArrayList<Computer> listComputer= new ArrayList();
    private static final String computerFile = "ComputerFile";

    public ComputerManager( ArrayList<Computer> listComputer) {
        super.list = listComputer;
    }

    @Override
    public void add(Computer computer) {
        list.add(computer);
        writeFile();
    }
    @Override
    public void delete(Computer computer) {
        list.remove(computer);
        writeFile();
    }
    @Override
    public void edit(Computer computer, String newId) {
        computer.setId(newId);
        writeFile();
    }
//    @Override
//    public void show() {
//        for (Computer c:list
//             ) {
//            System.out.println(c);
//        }
//
//    }

    private void writeFile() {
        FileManager fileManager = FileManager.getInstance();
        try {
            fileManager.writeFile(list,computerFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Lưu file bị lỗi");
        }
    }
}
