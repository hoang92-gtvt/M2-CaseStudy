package controller.getElement;

import model.Computer;

import java.util.ArrayList;

public interface GetElement<E> {
    public E getElement(ArrayList<E> list, String valueOfProperty);
}
