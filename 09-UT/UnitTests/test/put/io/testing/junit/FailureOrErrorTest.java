package put.io.testing.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FailureOrErrorTest {

    @Test
    void test1() {
        assertEquals(1, 2, "This should always fail");
    }

    @Test
    void test2() {
        throw new RuntimeException("This is an arbitrary exception");
    }

    @Test
    void test3() {
        try {
            assertEquals(1, 2, "This should always fail");
        } catch (Throwable t) {
            System.out.println("Caught throwable: " + t.getClass().getSimpleName());
            t.printStackTrace();
        }
    }

}
