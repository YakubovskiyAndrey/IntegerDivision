package ua.com.foxminded.integerdevision;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LongDivisionTest {

    private LongDivision division;

    @BeforeEach
    void setUp() throws Exception {
        division = new LongDivision();
    }

    @Test
    void testShouldDivide() {

        String expected = "_78945│4\n" + " 4    │-----\n" + " -    │19736\n" + "_38\n" + " 36\n" + " --\n" + " _29\n"
                + "  28\n" + "  --\n" + "  _14\n" + "   12\n" + "   --\n" + "   _25\n" + "    24\n" + "    --\n"
                + "     1\n";
        assertEquals(expected, division.divide(78945, 4));
    }

    @Test
    void testDivisionByZero() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            division.divide(78945, 0);
        });
    }

    @Test
    void testDivisionByOne() {

        String expected = "_78945│1\n" + " 7    │-----\n" + " -    │78945\n" + " _8\n" + "  8\n" + "  -\n" + "  _9\n"
                + "   9\n" + "   -\n" + "   _4\n" + "    4\n" + "    -\n" + "    _5\n" + "     5\n" + "     -\n"
                + "     0\n";
        assertEquals(expected, division.divide(78945, 1));
    }

    @Test
    void testDivisionBySelf() {

        String expected = "_78945│78945\n" + " 78945│-\n" + " -----│1\n" + "     0\n";
        assertEquals(expected, division.divide(78945, 78945));
    }

    @Test
    void testDivisionByLargeNumber() {

        String expected = "_78942555│742\n" + " 742     │------\n" + " ---     │106391\n" + " _4742\n" + "  4452\n"
                + "  ----\n" + "  _2905\n" + "   2226\n" + "   ----\n" + "   _6795\n" + "    6678\n" + "    ----\n"
                + "    _1175\n" + "      742\n" + "      ----\n" + "      433\n";
        assertEquals(expected, division.divide(78942555, 742));
    }

    @Test
    void testDivisionByNegativeNumber() {

        String expected = "_78945│-87\n" + " 783  │----\n" + " ---  │-907\n" + "  _645\n" + "   609\n" + "   ---\n"
                + "    36\n";
        assertEquals(expected, division.divide(78945, -87));
    }

}
