import org.example.TriangleArea;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaTest {

    @Test
    void testCalculateArea() {
        assertEquals(10.0, TriangleArea.calculateArea(5, 4));
        assertEquals(25.0, TriangleArea.calculateArea(10, 5));
        assertEquals(0.5, TriangleArea.calculateArea(1, 1));
    }

    @Test
    void testNonPositiveInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateArea(0, 10);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateArea(10, -5);
        });
    }
}
