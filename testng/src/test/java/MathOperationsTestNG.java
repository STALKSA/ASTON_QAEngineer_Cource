import org.example.MathOperations;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class MathOperationsTestNG {
    @Test
    public void testAdd() {
        assertEquals(MathOperations.add(2, 3), 5);
    }

    @Test
    public void testSubtract() {
        assertEquals(MathOperations.subtract(5, 3), 2);
    }

    @Test
    public void testMultiply() {
        assertEquals(MathOperations.multiply(2, 3), 6);
    }

    @Test
    public void testDivide() {
        assertEquals(MathOperations.divide(6, 3), 2.0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        MathOperations.divide(5, 0);
    }
}
