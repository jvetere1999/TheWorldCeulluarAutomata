import com.vetere.graphing.Function;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionTester {
    Function func;

    @Test
    void basicTest(){
        func = new Function("2x");
        assertAll("Single term functions",
                () -> assertEquals(0, func.get(0)),
                () -> assertEquals(2, func.get(1)));
        func = new Function("2x+1");
        assertAll("Double term functions",
                () -> assertEquals(1, func.get(0)),
                () -> assertEquals(3, func.get(1)),
                () -> assertEquals(5, func.get(2)));
        func = new Function("x^2+2x+1");
        assertAll("Triple term functions",
                () -> assertEquals(1, func.get(0)),
                () -> assertEquals(4, func.get(1)),
                () -> assertEquals(9, func.get(2)));
    }
}
