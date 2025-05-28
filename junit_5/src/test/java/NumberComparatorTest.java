
import org.example.NumberComparator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class NumberComparatorTest {

    @Test
    void testCompare() {
        assertEquals("5 is greater than 3", NumberComparator.compare(5, 3));
        assertEquals("3 is less than 5", NumberComparator.compare(3, 5));
        assertEquals("4 is equal to 4", NumberComparator.compare(4, 4));
    }
}
