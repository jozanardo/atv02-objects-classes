package accesspoints;

import java.util.Calendar;

/**
* Analise o ponto de acesso e verifica se esta ligado ou desligado.
*/
public class AcessPoint {

    private int year;
    private int month;
    private boolean turn;

    /**
    * Função para quando o argumento passado for somente a condição do AcessPoint.
    *
    * @param turn = condição do AcessPoint
    */
    public AcessPoint(boolean turn) {
        this.turn = turn;
    }

    /**
    * Pega os parametros para quando o AcessPoint estiver ligado.
    *
    * @param turn = condição de estar ligado
    * @param year = ano referente a ultima data que ele esteve ligado
    * @param month = mês referente a ultima data que ele esteve ligado
    */
    public AcessPoint(boolean turn, int year, int month) {
        this.turn = turn;
        this.year = year;
        this.month = month;
    }

    /**
    * Inverte a condição do AcessPoint.
    * True se torna False
    * False se torna True
    */
    public Boolean turninvert() {
        turn = !turn;

        if (turn) {
            Calendar data = Calendar.getInstance();
            this.year = data.get(Calendar.YEAR);
            this.month = data.get(Calendar.MONTH) + 1;
        }

        return turn;
    }

    @Override
    public String toString() {
        if (turn) {
            return "AcessPoint{"
                + "Turn = "
                + turn
                + ", Month = "
                + month + ", Year = "
                + year
                + "}";
        } else {
            return "AcessPoint{" + "Turn = " + turn + "}";
        }
    }

}
