import com.vetere.graphing.Term;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TermTest {
    Term term, term1, term2;

    @Test
    void termBasic() {
        term = new Term("+5x^2");
        assertAll("Basic positive terms",
                () -> assertEquals(false, term.neg),
                () -> assertEquals(5, term.constant),
                () -> assertEquals(2, term.exponent));
        term = new Term("-1x^3");
        assertAll("Basic neg terms",
                () -> assertEquals(true, term.neg),
                () -> assertEquals(1, term.constant),
                () -> assertEquals(3, term.exponent));
        term = new Term("5x^2");
        assertAll("Basic no sign terms",
                () -> assertEquals(false, term.neg),
                () -> assertEquals(5, term.constant),
                () -> assertEquals(2, term.exponent));
        term = new Term("x^2");
        assertAll("No num no sign terms",
                () -> assertEquals(false, term.neg),
                () -> assertEquals(1, term.constant),
                () -> assertEquals(2, term.exponent));
        term = new Term("+x^2");
        assertAll("No num pos sign terms",
                () -> assertEquals(false, term.neg),
                () -> assertEquals(1, term.constant),
                () -> assertEquals(2, term.exponent));
        term = new Term("-x^2");
        assertAll("No num neg sign terms",
                () -> assertEquals(true, term.neg),
                () -> assertEquals(1, term.constant),
                () -> assertEquals(2, term.exponent));
        term = new Term("1x");
        assertAll("No ex no sign terms",
                () -> assertEquals(false, term.neg),
                () -> assertEquals(1, term.constant),
                () -> assertEquals(1, term.exponent));
        term = new Term("+1x");
        assertAll("No ex pos sign terms",
                () -> assertEquals(false, term.neg),
                () -> assertEquals(1, term.constant),
                () -> assertEquals(1, term.exponent));
        term = new Term("-1x");
        assertAll("No ex neg sign terms",
                () -> assertEquals(true, term.neg),
                () -> assertEquals(1, term.constant),
                () -> assertEquals(1, term.exponent));
        term = new Term("2");
        assertAll("just num",
                () -> assertEquals(false, term.neg),
                () -> assertEquals(2, term.constant),
                () -> assertEquals(0, term.exponent));
    }
    @Test
    void termCalculate() {
        term = new Term("+5x^2");
        assertAll("Positive all values",
                () -> assertEquals(0, term.Calculate(0)),
                () -> assertEquals(5, term.Calculate(1)),
                () -> assertEquals(20, term.Calculate(2)));
        term = new Term("-1x^3");
        assertAll("Negative all values",
                () -> assertEquals(0, term.Calculate(0)),
                () -> assertEquals(-1, term.Calculate(1)),
                () -> assertEquals(-8, term.Calculate(2)));
        term = new Term("5x^2");
        assertAll("No sign all values",
                () -> assertEquals(0, term.Calculate(0)),
                () -> assertEquals(5, term.Calculate(1)),
                () -> assertEquals(20, term.Calculate(2)));
        term = new Term("5x");
        assertAll("No sign all values",
                () -> assertEquals(0, term.Calculate(0)),
                () -> assertEquals(5, term.Calculate(1)),
                () -> assertEquals(10, term.Calculate(2)));
        term = new Term("x^2");
        assertAll("No sign all values",
                () -> assertEquals(0, term.Calculate(0)),
                () -> assertEquals(1, term.Calculate(1)),
                () -> assertEquals(4, term.Calculate(2)));
        term = new Term("x");
        assertAll("No sign all values",
                () -> assertEquals(0, term.Calculate(0)),
                () -> assertEquals(1, term.Calculate(1)),
                () -> assertEquals(2, term.Calculate(2)));
        term = new Term("5");
        assertAll("No sign all values",
                () -> assertEquals(5, term.Calculate(0)),
                () -> assertEquals(5, term.Calculate(1)),
                () -> assertEquals(5, term.Calculate(2)));
    }
    @Test
    void derive(){
        term = new Term("x^2");
        term1 = new Term("x");
        term2 = new Term("2");
        assertAll("Basic derivation",
                () -> assertEquals(2, term.constant),
                () -> assertEquals(1, term.exponent),
                () -> assertEquals(1, term2.constant),
                () -> assertEquals(0, term2.exponent),
                () -> assertEquals(null, term2)
                );
    }

}
