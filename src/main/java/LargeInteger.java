import java.util.Arrays;

/**
 * Abstraction of an Integer with arbitrary precision.
 */
public class LargeInteger {

    private char[] digits = {};

    /**
     * Construtor que cria um vetor de array de tamanho 1.
     */
    public LargeInteger() {
        // TODO: implementar
        digits = new char[1];

        digits[0] = '0';
    }

    /**
     * Construtor que irá criar um array de char a partir de um long.
     *
     * @param value numero
     */
    public LargeInteger(long value) {
        // TODO: implementar
        String value2 = Long.toString(value);

        digits = new char[value2.length()];

        for (int i = 0; i < value2.length(); i++) {
            digits[i] = value2.charAt(i);
        }

    }

    /**
     * Construtor que gera um vetor do tamanho do numero.
     *
     * @param value numero para base do vetor
     */
    public LargeInteger(LargeInteger value) {
        // TODO: implementar
        digits = new char[value.digits.length];

        for (int i = 0; i < value.digits.length; i++) {
            digits[i] = value.digits[i];
        }

    }

    /**
     * Converte uma string em um Array de char.
     *
     * @param value string a ser convertida
     * @throws IllegalArgumentException se não for um numero
     */
    public LargeInteger(String value) throws IllegalArgumentException {
        // TODO: implementar
        if (!value.matches("\\d+")) {
            throw new IllegalArgumentException("Value must be a number");
        }

        digits = new char[value.length()];

        for (int i = 0; i < value.length(); i++) {
            digits[i] = value.charAt(i);
        }

    }

    public int size() {
        // TODO: implementar
        return this.toString().length();
    }

    private static char[] addzero(char[] vector, int x) {
        char[] newvector = new char[x];

        int count = 0;

        for (int i = 0; i < x; i++) {
            if (i < (x - vector.length)) {
                newvector[i] = '0';
                count++;
            } else {
                newvector[i] = vector[i - count];
            }

        }
        return newvector;
    }

    /**
     * realiza a soma de 2 numeros.
     *
     * @param value numero a ser somado
     * @return soma dos dois numeros
     */
    public LargeInteger plus(LargeInteger value) {
        // TODO: implementar
        char[] digits2 = new char[value.digits.length];
        for (int i = 0; i < value.digits.length; i++) {
            digits2[i] = value.digits[i];
        }
        char[] digits3;
        char[] digits4;
        char[] digits5;


        if (value.digits.length > digits.length) {
            digits3 = addzero(digits, value.digits.length);
            digits4 = addzero(digits2, value.digits.length);
            digits5 = new char[value.digits.length + 1];
        } else {
            digits3 = addzero(digits, digits.length);
            digits4 = addzero(digits2, digits.length);
            digits5 = new char[digits.length + 1];
        }

        int count = 0;
        int aux = 0;
        for (int i = digits4.length - 1; i >= 0; i--) {
            int a = Character.getNumericValue(digits3[i]);
            a += count;
            count = 0;
            int b = Character.getNumericValue(digits4[i]);
            if (a + b > 9) {
                aux = (a + b) % 10;
                digits5[i + 1] = Character.forDigit(aux, 10);
                count = 1;
            } else {
                aux = a + b;
                digits5[i + 1] = Character.forDigit(aux, 10);
            }
        }
        digits5[0] = Character.forDigit(count, 10);

        StringBuilder number = new StringBuilder();
        number.append(digits5);

        return new LargeInteger(number.toString());
    }

    /**
     * Realiza o complemento de 9.
     *
     * @return numero após o complemento de 9.
     */
    public LargeInteger ninesComplement() {
        // TODO: implementar

        String novaString = toString();

        char[] nine = new char[novaString.length()];
        int aux = 0;
        for (int i = 0; i < novaString.length(); i++) {
            aux = 9 - Character.getNumericValue(novaString.charAt(i));
            nine[i] = Character.forDigit(aux, 10);
        }

        StringBuilder number = new StringBuilder();
        number.append(nine);
        return new LargeInteger(number.toString());
    }

    /**
     * Subtrai 2 numeros.
     *
     * @param value numero a ser subtraido.
     * @return valor final da subtração
     */
    public LargeInteger minus(LargeInteger value) {
        // TODO: implementar
        char[] digits2 = new char[value.digits.length];
        for (int i = 0; i < value.digits.length; i++) {
            digits2[i] = value.digits[i];
        }
        char[] digits3;
        char[] digits4;
        char[] digits5;


        if (value.digits.length > digits.length) {
            digits3 = addzero(digits, value.digits.length);
            digits4 = addzero(digits2, value.digits.length);
            digits5 = new char[value.digits.length + 1];
        } else {
            digits3 = addzero(digits, digits.length);
            digits4 = addzero(digits2, digits.length);
            digits5 = new char[digits.length + 1];
        }

        System.out.println("peniano " + ninesComplement());
        System.out.println("penis " + plus(value));

        return new LargeInteger();
    }

    /**
     * Faz o comparativo entre dois numeros.
     *
     * @param value numero a ser comparado
     * @return 1 se for maior, 0 se for igual e -1 se for menor.
     */
    public int compareTo(LargeInteger value) {
        // TODO: implementar
        char[] digits2 = new char[value.digits.length];
        for (int i = 0; i < value.digits.length; i++) {
            digits2[i] = value.digits[i];
        }

        char[] vector1;
        char[] vector2;

        if (value.digits.length > digits.length) {
            vector1 = addzero(digits, value.digits.length);
            vector2 = addzero(digits2, value.digits.length);
        } else {
            vector1 = addzero(digits, digits.length);
            vector2 = addzero(digits2, digits.length);
        }

        for (int i = 0; i < vector1.length; i++) {
            if (Character.getNumericValue(vector1[i]) > Character.getNumericValue(vector2[i])) {
                return 1;
            } else if (Character.getNumericValue(vector1[i])
                < Character.getNumericValue(vector2[i])) {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        // TODO: implementar
        String novaString = String.valueOf(digits);
        novaString = novaString.replaceAll("\\b0+(?!\\b)", "");
        return novaString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LargeInteger that = (LargeInteger) o;

        return compareTo(that) == 0;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(digits);
    }
}
