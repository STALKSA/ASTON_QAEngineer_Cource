
import org.example.MathOperations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MathOperationsTest {

    @Test
    void testAdd() {
        assertEquals(5, MathOperations.add(2, 3));
        assertEquals(-1, MathOperations.add(2, -3));
        assertEquals(0, MathOperations.add(0, 0));
    }

    @Test
    void testSubtract() {
        assertEquals(-1, MathOperations.subtract(2, 3));
        assertEquals(5, MathOperations.subtract(2, -3));
        assertEquals(0, MathOperations.subtract(0, 0));
    }

    @Test
    void testMultiply() {
        assertEquals(6, MathOperations.multiply(2, 3));
        assertEquals(-6, MathOperations.multiply(2, -3));
        assertEquals(0, MathOperations.multiply(0, 5));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, MathOperations.divide(6, 3));
        assertEquals(-2.0, MathOperations.divide(6, -3));
        assertEquals(0.5, MathOperations.divide(1, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            MathOperations.divide(5, 0);
        });
    }
}
