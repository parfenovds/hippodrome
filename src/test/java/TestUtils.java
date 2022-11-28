import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestUtils {
    public static final String DEFAULT_NAME = "defaultName";
    public static final int DEFAULT_SPEED = 0;
    public static final int DEFAULT_DISTANCE = 0;
    public static final String NAME_CANNOT_BE_NULL = "Name cannot be null.";

    public static final String NAME_CANNOT_BE_BLANK = "Name cannot be blank.";

    public static final String SPEED_CANNOT_BE_NEGATIVE = "Speed cannot be negative.";
    public static final String DISTANCE_CANNOT_BE_NEGATIVE = "Distance cannot be negative.";



    public void horseConstructorExceptionCheck(Class<? extends Throwable> exceptionClass,
                                                String name,
                                                int speed,
                                                int distance) {
        assertThrows(exceptionClass, () -> new Horse(name, speed, distance));
    }
    public void horseConstructorMessageCheck(String message,
                                             String name,
                                             int speed,
                                             int distance) {
        try {
            new Horse(name, speed, distance);
        } catch (IllegalArgumentException e) {
            assertEquals(message, e.getMessage());
        }
    }
}
