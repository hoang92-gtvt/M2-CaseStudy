package controller;

import model.Service;
import storage.FileManager;

import java.io.IOException;
import java.util.ArrayList;

public class ServiceManager extends Manager<Service> {
    private static final String serviceFile = "ServiceFile";
    private ArrayList<Service>  servicesList ;

    @Override
    public void add(Service element) {
        super.add(element);
        writeFile();
    }

    @Override
    public void delete(Service element) {
        super.delete(element);
        writeFile();
    }

    @Override
    public void edit(Service element, String newId) {
        super.edit(element, newId);
        writeFile();
    }
    private void writeFile() {
        FileManager fileManager = FileManager.getInstance();
        try {
            fileManager.writeFile(list, serviceFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Lưu file bị lỗi");
        }
    }
}
