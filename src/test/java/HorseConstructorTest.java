import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HorseConstructorTest {
    public static final String NAME_CANNOT_BE_NULL = "Name cannot be null.";

    public static final String NAME_CANNOT_BE_BLANK = "Name cannot be blank.";

    public static final String SPEED_CANNOT_BE_NEGATIVE = "Speed cannot be negative.";
    public static final String DISTANCE_CANNOT_BE_NEGATIVE = "Distance cannot be negative.";

    static Stream<String> emptyAndWhitespaceStringProvider() {
        return Stream.of("", " ", " \t", "\n", " \n ");
    }

    static IntStream negativeIntProvider() {
        return IntStream.of(-1, -1000, Integer.MIN_VALUE);
    }

    @Test
    void nullNameException() {
        horseConstructorExceptionCheck(
                null,
                CommonConstants.DEFAULT_SPEED,
                CommonConstants.DEFAULT_DISTANCE);
    }
    @Test
    void nullNameExceptionForConstructorWithTwoParameters() {
        horseConstructorExceptionCheck(
                null,
                CommonConstants.DEFAULT_SPEED);
    }

    @Test
    void nullNameMessage() {
        horseConstructorMessageCheck(NAME_CANNOT_BE_NULL,
                null,
                CommonConstants.DEFAULT_SPEED,
                CommonConstants.DEFAULT_DISTANCE);
    }
    @Test
    void nullNameMessageForConstructorWithTwoParameters() {
        horseConstructorMessageCheck(NAME_CANNOT_BE_NULL,
                null,
                CommonConstants.DEFAULT_SPEED);
    }

    @ParameterizedTest
    @MethodSource("emptyAndWhitespaceStringProvider")
    void emptyOrWhitespaceNameException(String argument) {
        horseConstructorExceptionCheck(
                argument,
                CommonConstants.DEFAULT_SPEED,
                CommonConstants.DEFAULT_DISTANCE);
    }
    @ParameterizedTest
    @MethodSource("emptyAndWhitespaceStringProvider")
    void emptyOrWhitespaceNameExceptionForConstructorWithTwoParameters(String argument) {
        horseConstructorExceptionCheck(
                argument,
                CommonConstants.DEFAULT_SPEED);
    }

    @ParameterizedTest
    @MethodSource("emptyAndWhitespaceStringProvider")
    void emptyOrWhitespaceNameMessage(String argument) {
        horseConstructorMessageCheck(NAME_CANNOT_BE_BLANK,
                argument,
                CommonConstants.DEFAULT_SPEED,
                CommonConstants.DEFAULT_DISTANCE);
    }
    @ParameterizedTest
    @MethodSource("emptyAndWhitespaceStringProvider")
    void emptyOrWhitespaceNameMessageForConstructorWithTwoParameters(String argument) {
        horseConstructorMessageCheck(NAME_CANNOT_BE_BLANK,
                argument,
                CommonConstants.DEFAULT_SPEED);
    }

    @ParameterizedTest
    @MethodSource("negativeIntProvider")
    void negativeSpeedException(int speed) {
        horseConstructorExceptionCheck(
                CommonConstants.DEFAULT_NAME,
                speed,
                CommonConstants.DEFAULT_DISTANCE);
    }
    @ParameterizedTest
    @MethodSource("negativeIntProvider")
    void negativeSpeedExceptionForConstructorWithTwoParameters(int speed) {
        horseConstructorExceptionCheck(
                CommonConstants.DEFAULT_NAME,
                speed);
    }

    @ParameterizedTest
    @MethodSource("negativeIntProvider")
    void negativeSpeedMessage(int speed) {
        horseConstructorMessageCheck(SPEED_CANNOT_BE_NEGATIVE,
                CommonConstants.DEFAULT_NAME,
                speed,
                CommonConstants.DEFAULT_DISTANCE);
    }
    @ParameterizedTest
    @MethodSource("negativeIntProvider")
    void negativeSpeedMessageForConstructorWithTwoParameters(int speed) {
        horseConstructorMessageCheck(SPEED_CANNOT_BE_NEGATIVE,
                CommonConstants.DEFAULT_NAME,
                speed);
    }

    @ParameterizedTest
    @MethodSource("negativeIntProvider")
    void negativeDistanceException(int distance) {
        horseConstructorExceptionCheck(
                CommonConstants.DEFAULT_NAME,
                CommonConstants.DEFAULT_SPEED,
                distance);
    }

    @ParameterizedTest
    @MethodSource("negativeIntProvider")
    void negativeDistanceMessage(int distance) {
        horseConstructorMessageCheck(DISTANCE_CANNOT_BE_NEGATIVE,
                CommonConstants.DEFAULT_NAME,
                CommonConstants.DEFAULT_SPEED,
                distance
        );
    }

    private void horseConstructorExceptionCheck(String name, int speed, int distance) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));
    }

    private void horseConstructorExceptionCheck(String name, int speed) {
        assertThrows((Class<? extends Throwable>) IllegalArgumentException.class, () -> new Horse(name, speed));
    }

    private void horseConstructorMessageCheck(String message, String name, int speed, int distance) {
        try {
            new Horse(name, speed, distance);
        } catch (IllegalArgumentException e) {
            assertEquals(message, e.getMessage());
        }
    }

    private void horseConstructorMessageCheck(String message, String name, int speed) {
        try {
            new Horse(name, speed);
        } catch (IllegalArgumentException e) {
            assertEquals(message, e.getMessage());
        }
    }
}
