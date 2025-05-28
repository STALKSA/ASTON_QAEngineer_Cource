import org.example.TriangleArea;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaTestNG {
    @Test
    public void testCalculateArea() {
        assertEquals(TriangleArea.calculateArea(5, 4), 10.0);
        assertEquals(TriangleArea.calculateArea(10, 5), 25.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testZeroBase() {
        TriangleArea.calculateArea(0, 10);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeHeight() {
        TriangleArea.calculateArea(10, -5);
    }
}
