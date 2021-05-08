package controller.getElement;

import model.Computer;
import model.Player;

import java.util.ArrayList;

public class GetPlayerByID implements GetElement<Player> {
    @Override
    public Player getElement(ArrayList<Player> list, String valueOfProperty) {
        for (Player c: list
        ) {
            if (c.getId().equals(valueOfProperty)) {
                return c;
            }
        }
        return null;
    }
}
