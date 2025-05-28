import org.example.NumberComparator;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NumberComparatorTestNG {
    @Test
    public void testCompare() {
        assertEquals(NumberComparator.compare(5, 3), "5 больше, чем 3");
        assertEquals(NumberComparator.compare(3, 5), "3 меньше, чем 5");
        assertEquals(NumberComparator.compare(4, 4), "4 равно 4");
    }
}
