package controller;

import model.Player;
import storage.FileManager;

import java.io.IOException;
import java.util.ArrayList;


public  class Manager<E> {
    private String name;
    public ArrayList<E> list = new ArrayList<>();

    public Manager() {
    }

    public Manager(ArrayList<E> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<E> getList() {
        return list;
    }

    public void setList(ArrayList<E> list) {
        this.list = list;
    }

    public void add(E element){};
    public  void delete(E element){};
    public  void edit(E element, String newId){};

    public void show(){
        for (E e:list
        ) {
            System.out.println(e);

        }
    };





//
 }
