package accesspoints;

import java.util.ArrayList;
import java.util.List;

/**
* Adiciona a quantidade de andares no prédio.
*/
public class Building {
    private final int length;
    private final List<Floor> floors;

    /**
     * Verifica se o valor passado como parametro é menor que 0.
     *
     * @param length tamanho do prédio
     */
    public Building(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Precisar ser acima de zero");
        }
        this.length = length;
        floors = new ArrayList<>();
    }

    /**
    * Adiciona os andares caso a capacidade máximas de andares não tenha sido atingida.
    */
    public void addFloor(Floor floor) {
        if (this.floors.size() == length) {
            System.err.println("Maximum capacity of floors exceeded");
        } else {
            this.floors.add(floor);
        }
    }

    @Override
    public String toString() {
        return "Building{"
            + "length="
            + length
            + ", floors="
            + floors.size()
            + '}';
    }
}
