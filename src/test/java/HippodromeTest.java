import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    public static final String HORSES_CANNOT_BE_NULL = "Horses cannot be null.";
    public static final String HORSES_CANNOT_BE_EMPTY = "Horses cannot be empty.";

    @Test
    void whenNullInConstructor_thenThrowIllegalArgumentException() {
        hippodromeConstructorExceptionCheck(null);
    }

    @Test
    void whenNullInConstructor_thenMessageIsHorsesCannotBeNull() {
        hippodromeConstructorMessageCheck(HORSES_CANNOT_BE_NULL, null);
    }

    @Test
    void whenEmptyListInConstructor_thenThrowIllegalArgumentException() {
        hippodromeConstructorExceptionCheck(new ArrayList<>());
    }

    @Test
    void whenNullInConstructor_thenMessageIsHorsesCannotBeEmpty() {
        hippodromeConstructorMessageCheck(HORSES_CANNOT_BE_EMPTY, new ArrayList<>());
    }

    @Test
    void getHorsesReturnsCorrectList() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            String horseName = "horse+" + (i);
            horses.add(new Horse(horseName, i + 10, i - 1));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses, hippodrome.getHorses());
    }

    @Test
    void moveCallsForEveryHorse() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(Mockito.mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();
        for (Horse horse : hippodrome.getHorses()) {
            Mockito.verify(horse).move();
        }
    }

    @Test
    void getWinnerReturnsHorseWithBiggestDistance() {
        List<Horse> horses = new ArrayList<>();
        int limit = 50;
        for (int i = 1; i <= limit; i++) {
            String horseName = "horse+" + (i);
            horses.add(new Horse(horseName, i + 10, i - 1));
        }
        Horse furthestHorse = horses.get(limit - 1);
        Collections.shuffle(horses);
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(furthestHorse, hippodrome.getWinner());
    }

    private void hippodromeConstructorExceptionCheck(List<Horse> horses) {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(horses));
    }

    private void hippodromeConstructorMessageCheck(String message, List<Horse> horses) {
        try {
            new Hippodrome(horses);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), message);
        }
    }


}