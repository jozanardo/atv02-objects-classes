package accesspoints;

import java.util.List;

/**
* Colocar as salas nos respectivos andares.
*/
public class Floor {

    private int length;
    private List<Room> room;

    /**
     * Verifica se o tamanho é menor que zero.
     *
     * @param length quantidade de andares.
     */
    public Floor(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("The number must be greater than 0");
        }
        this.length = length;
    }

    /**
    * Adiciona uma sala caso a capacidade máxima não tenha sido excedida.
    *
    * @param room a ser adicionada
    */
    public void addroom(Room room) {
        if (this.room.size() == length) {
            System.err.println("Maximum capacity of rooms exceeded");
        } else {
            this.room.add(room);
        }
    }

    @Override
    public String toString() {
        return "Floor{"
            + "length="
            + length
            + ", room="
            + room.size()
            + '}';
    }
}
