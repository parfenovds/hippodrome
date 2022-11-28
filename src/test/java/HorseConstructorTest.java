import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HorseConstructorTest {

    public static final String NAME_CANNOT_BE_NULL = "Name cannot be null.";

    static Stream<String> emptyAndWhitespaceStringProvider() {
        return Stream.of("", " ", " \t", "\n", " \n ");
    }

    @Test
    void nullNameException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 0, 0));
    }

    @Test
    void nullNameMessage() {
        try {
            new Horse(null, 0, 0);
        } catch (IllegalArgumentException e) {
            assertEquals(NAME_CANNOT_BE_NULL, e.getMessage());
        }
    }

    @ParameterizedTest
    @MethodSource("emptyAndWhitespaceStringProvider")
    void emptyOrWhitespaceNameException(String argument) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(argument, 0, 0));
    }

    @ParameterizedTest
    @MethodSource("emptyAndWhitespaceStringProvider")
    void emptyOrWhitespaceNameMessage(String argument) {
        try {
            new Horse(null, 0, 0);
        } catch (IllegalArgumentException e) {
            assertEquals(NAME_CANNOT_BE_NULL, e.getMessage());
        }
    }
}
