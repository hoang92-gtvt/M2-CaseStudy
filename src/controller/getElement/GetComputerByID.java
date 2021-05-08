package controller.getElement;

import model.Computer;

import java.util.ArrayList;

public  class GetComputerByID extends GetComputer {

    public GetComputerByID() {
    }

    @Override
    public Computer getElement(ArrayList<Computer> list, String valueOfProperty) {
        for (Computer c: list
        ) {
            if (c.getId().equals(valueOfProperty)) {
                return c;
            }

        }
        return null;
    }
}
