package controller.getElement;

import model.Computer;

import java.util.ArrayList;

public abstract class  GetComputer implements GetElement<Computer>{


    @Override
    public Computer getElement(ArrayList<Computer> list, String valueOfProperty) {
        for (Computer c: list
        ) {
            if (true) {
                return c;
            }

        }
        return null;
    }

}
