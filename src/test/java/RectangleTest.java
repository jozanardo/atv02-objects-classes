import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for Rectangle.
 */
public class RectangleTest {
    private static final String rectanglesTestCases = "src/test/resources/rectangles.csv";
    private static final double threshold = 0.001d;

    @Test
    public void testRectangle() {
        try (var scanner = new Scanner(new File(rectanglesTestCases))) {
            while (scanner.hasNext()) {
                var caseName = scanner.next();

                var r1 = new Rectangle(
                    Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                var area1 = Double.parseDouble(scanner.next());
                var perimeter1 = Double.parseDouble(scanner.next());
                var r2 = new Rectangle(
                    Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next())
                );
                var area2 = Double.parseDouble(scanner.next());
                var perimeter2 = Double.parseDouble(scanner.next());
                var intersects12 = scanner.nextBoolean();
                var intersects21 = scanner.nextBoolean();
                var contains12 = scanner.nextBoolean();
                var contains21 = scanner.nextBoolean();

                Assertions.assertEquals(area1, r1.area(), threshold,
                    String.format("%s: area does not match. %s", caseName, r1));
                Assertions.assertEquals(perimeter1, r1.perimeter(), threshold,
                    String.format("%s: perimeter does not match. %s", caseName, r1));

                Assertions.assertEquals(area2, r2.area(), threshold,
                    String.format("%s: area does not match. %s", caseName, r2));
                Assertions.assertEquals(perimeter2, r2.perimeter(), threshold,
                    String.format("%s: perimeter does not match. %s", caseName, r2));

                Assertions.assertEquals(intersects12, r1.intersects(r2),
                    String.format("%s: a.intersects(b) should be %s. a = %s, b = %s",
                        caseName, intersects12, r1, r2));
                Assertions.assertEquals(intersects21, r2.intersects(r1),
                    String.format("%s: b.intersects(a) should be %s. a = %s, b = %s",
                        caseName, intersects21, r1, r2));

                Assertions.assertEquals(contains12, r1.contains(r2),
                    String.format("%s: a.contains(b) should be %s. a = %s, b = %s",
                        caseName, contains12, r1, r2));
                Assertions.assertEquals(contains21, r2.contains(r1),
                    String.format("%s: b.contains(a) should be %s. a = %s, b = %s",
                        caseName, contains21, r1, r2));

                Assertions.assertTrue(r1.intersects(r1),
                    String.format("%s always intersect itself", r1));
                Assertions.assertTrue(r1.contains(r1),
                    String.format("%s always contains itself", r1));

                Assertions.assertTrue(r2.intersects(r2),
                    String.format("%s always intersect itself", r2));
                Assertions.assertTrue(r2.contains(r2),
                    String.format("%s always contains itself", r2));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to load rectangle test cases");
            e.printStackTrace();
        }
    }
}
