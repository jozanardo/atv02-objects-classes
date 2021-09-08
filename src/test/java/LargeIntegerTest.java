import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for LargeInteger.
 */
public class LargeIntegerTest {

    private static final String rationalTestCases = "src/test/resources/large-integer.csv";

    @Test
    public void fileTests() {
        try (var scanner = new Scanner(new File(rationalTestCases))) {
            while (scanner.hasNext()) {
                var strA = scanner.next();
                var strB = scanner.next();
                var a = new LargeInteger(strA);
                var b = new LargeInteger(strB);
                var complementA = new LargeInteger(scanner.next());
                var complementB = new LargeInteger(scanner.next());
                var compareAb = Integer.parseInt(scanner.next());
                var compareBa = Integer.parseInt(scanner.next());
                var plusAb = new LargeInteger(scanner.next());
                var plusBa = new LargeInteger(scanner.next());
                var minusAb = new LargeInteger(scanner.next());
                var minusBa = new LargeInteger(scanner.next());

                Assertions.assertEquals(complementA, new LargeInteger(a).ninesComplement(),
                    String.format("%s has wrong 9's complement", strA));
                Assertions.assertEquals(complementB, new LargeInteger(b).ninesComplement(),
                    String.format("%s has wrong 9's complement", strB));
                Assertions
                    .assertEquals(compareAb,
                        new LargeInteger(a).compareTo(new LargeInteger(b)),
                        String.format("%s compared to %b lead to wrong result", strA, strB));
                Assertions
                    .assertEquals(compareBa,
                        new LargeInteger(b).compareTo(new LargeInteger(a)),
                        String.format("%s compared to %b lead to wrong result", strB, strA));
                Assertions.assertEquals(plusAb,
                    new LargeInteger(a).plus(new LargeInteger(b)),
                    String.format("%s + %s lead to wrong result", strA, strB));
                Assertions.assertEquals(plusBa,
                    new LargeInteger(b).plus(new LargeInteger(a)),
                    String.format("%s + %s lead to wrong result", strB, strA));
                Assertions.assertEquals(minusAb,
                    new LargeInteger(a).minus(new LargeInteger(b)),
                    String.format("%s - %s lead to wrong result", strA, strB));
                Assertions.assertEquals(minusBa,
                    new LargeInteger(b).minus(new LargeInteger(a)),
                    String.format("%s - %s lead to wrong result", strB, strA));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
