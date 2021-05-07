package controller;

import model.Player;
import storage.FileManager;

import java.io.IOException;
import java.util.ArrayList;

public class PlayerManager extends Manager<Player> {

//    private ArrayList<Player>  playerList= new ArrayList();
    private static final String playerFile = "playerFile";

    public PlayerManager(ArrayList<Player> playerList) {
        super.list  = playerList;
    }
    @Override
    public void add(Player player) {
        list.add(player);
        writeFile();
    }
    @Override
    public void delete(Player player) {
        list.remove(player);
        writeFile();

    }

    @Override
    public void edit(Player player, String newId) {
        player.setId(newId);
        writeFile();
    }
//    @Override
//    public void show() {
//        for (Player p:list
//             ) {
//            System.out.println(p);
//
//        }
//
//    }

    private void writeFile() {
        FileManager fileManager = FileManager.getInstance();
        try {
            fileManager.writeFile(list, playerFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Lưu file bị lỗi");
        }
    }



}
