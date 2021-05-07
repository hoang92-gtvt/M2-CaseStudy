package storage;

import java.io.*;
import java.util.ArrayList;

public class FileManager<E> {

    private static FileManager INTANCE;

    private FileManager() {

    }
    public static FileManager getInstance(){
        if(INTANCE== null){
            INTANCE = new FileManager();
        }
        return INTANCE;
    }

    public ArrayList<E> readFile(String filePath ) throws IOException, ClassNotFoundException {
        ArrayList<E> inputFile = new ArrayList<>();
        File newFile = new File(filePath);
        if(newFile.exists()){
            newFile.createNewFile();
        }
        if (newFile.length()>0) {
            FileInputStream fis = new FileInputStream(newFile);
            ObjectInputStream oIS = new ObjectInputStream(fis);
            Object object = oIS.readObject();
            inputFile = (ArrayList<E>) object;
            oIS.close();
            fis.close();
            return inputFile;

        }
        return new ArrayList<E>();
    }

    public void writeFile(ArrayList<E> listFile, String filePath)throws IOException{
        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream oOS= new ObjectOutputStream(fos);
        oOS.writeObject(listFile);
        oOS.close();
        fos.close();

    }


}
