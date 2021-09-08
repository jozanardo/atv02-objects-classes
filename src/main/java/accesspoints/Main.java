package accesspoints;

/**
 * Main do exercicio inteiro.
 */
public class Main {

    /**
     * Faz as verificações para diversos casos possiveis.
     *
     * @param args argumento da main
     */

    public void main(String[] args) {

        AcessPoint acesspoint1 = new AcessPoint(false);
        AcessPoint acesspoint2 = new AcessPoint(true, 1987, 5);
        AcessPoint acesspoint3 = new AcessPoint(true, 2015, 1);

        Room room1 = new Room(9);
        Room room2 = new Room(7);

        room1.addacesspoint(acesspoint1);
        room1.addacesspoint(acesspoint2);
        room2.addacesspoint(acesspoint3);

        Floor floor1 = new Floor(7);

        floor1.addroom(room1);
        floor1.addroom(room2);

        Building building1 = new Building(9);

        building1.addFloor(floor1);

        System.out.println(building1);

    }

}