import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HorseConstructorTest {
    private final TestUtils testUtils = new TestUtils();

    static Stream<String> emptyAndWhitespaceStringProvider() {
        return Stream.of("", " ", " \t", "\n", " \n ");
    }
    static IntStream negativeIntProvider() {
        return IntStream.of(-1, -1000, Integer.MIN_VALUE);
    }

    @Test
    void nullNameException() {
        testUtils.horseConstructorExceptionCheck(IllegalArgumentException.class,
                null,
                TestUtils.DEFAULT_SPEED,
                TestUtils.DEFAULT_DISTANCE);
    }

    @Test
    void nullNameMessage() {
        testUtils.horseConstructorMessageCheck(TestUtils.NAME_CANNOT_BE_NULL,
                null,
                TestUtils.DEFAULT_SPEED,
                TestUtils.DEFAULT_DISTANCE);
    }

    @ParameterizedTest
    @MethodSource("emptyAndWhitespaceStringProvider")
    void emptyOrWhitespaceNameException(String argument) {
        testUtils.horseConstructorExceptionCheck(IllegalArgumentException.class,
                argument,
                TestUtils.DEFAULT_SPEED,
                TestUtils.DEFAULT_DISTANCE);
    }

    @ParameterizedTest
    @MethodSource("emptyAndWhitespaceStringProvider")
    void emptyOrWhitespaceNameMessage(String argument) {
        testUtils.horseConstructorMessageCheck(TestUtils.NAME_CANNOT_BE_BLANK,
                argument,
                TestUtils.DEFAULT_SPEED,
                TestUtils.DEFAULT_DISTANCE);
    }

    @ParameterizedTest
    @MethodSource("negativeIntProvider")
    void negativeSpeedException(int speed) {
        testUtils.horseConstructorExceptionCheck(IllegalArgumentException.class,
                TestUtils.DEFAULT_NAME,
                speed,
                TestUtils.DEFAULT_DISTANCE);
    }

    @ParameterizedTest
    @MethodSource("negativeIntProvider")
    void negativeSpeedMessage(int speed) {
        testUtils.horseConstructorMessageCheck(TestUtils.SPEED_CANNOT_BE_NEGATIVE,
                TestUtils.DEFAULT_NAME,
                speed,
                TestUtils.DEFAULT_DISTANCE);
    }

    @ParameterizedTest
    @MethodSource("negativeIntProvider")
    void negativeDistanceException(int distance) {
        testUtils.horseConstructorExceptionCheck(IllegalArgumentException.class,
                TestUtils.DEFAULT_NAME,
                TestUtils.DEFAULT_SPEED,
                distance);
    }

    @ParameterizedTest
    @MethodSource("negativeIntProvider")
    void negativeDistanceMessage(int distance) {
        testUtils.horseConstructorMessageCheck(TestUtils.DISTANCE_CANNOT_BE_NEGATIVE,
                TestUtils.DEFAULT_NAME,
                TestUtils.DEFAULT_SPEED,
                distance
                );
    }
}
