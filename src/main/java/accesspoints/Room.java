package accesspoints;

import java.util.List;

/**
* analisa a sala.
* */
public class Room {

    private int length;
    private List<AcessPoint> acesspoint;

    /**
     * Verifica se a quantidade de salas é menor que 0.
     *
     * @param length quantidade de salas.
     */
    public Room(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("The number must be greater than 0");
        }
        this.length = length;
    }

    /**
     * Adiciona um AcessPoint caso a capacidade máxima não tenha sido excedida.
    */
    public void addacesspoint(AcessPoint acesspoint) {
        this.acesspoint.add(acesspoint);
    }

    @Override
    public String toString() {
        return "Room{"
            + "length="
            + length
            + ", acesspoint="
            + acesspoint.size()
            + '}';
    }
}