package controller.getElement;

import model.Computer;

import java.util.ArrayList;

public interface getElement<E> {
    public E getElement(ArrayList<E> list, String valueOfProperty);
}
