package controller.getElement;

import model.Computer;

import java.util.ArrayList;

public class GetComputerByStatus extends GetComputer{

    @Override
    public Computer getElement(ArrayList<Computer> list, String valueOfProperty) {
        for (Computer c:list ) {
            if(!c.getStatus()){
                c.getOnComputer();
                return c;
            }
        }
        return null;
    }
}
