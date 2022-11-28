import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HorseTest {
    private Horse threeParametersHorse;
    private Horse twoParametersHorse;


    @BeforeAll
    void createTwoHorsesForTests() {
        threeParametersHorse = new Horse(CommonConstants.DEFAULT_NAME, CommonConstants.DEFAULT_SPEED, CommonConstants.DEFAULT_DISTANCE);
        twoParametersHorse = new Horse(CommonConstants.DEFAULT_NAME, CommonConstants.DEFAULT_SPEED);
    }

    @Test
    @Order(1)
    void getName() {
        assertEquals(CommonConstants.DEFAULT_NAME, threeParametersHorse.getName());
        assertEquals(CommonConstants.DEFAULT_NAME, twoParametersHorse.getName());
    }

    @Test
    @Order(2)
    void getSpeed() {
        assertEquals(CommonConstants.DEFAULT_SPEED, threeParametersHorse.getSpeed());
        assertEquals(CommonConstants.DEFAULT_SPEED, twoParametersHorse.getSpeed());
    }

    @Test
    @Order(3)
    void getDistance() {
        assertEquals(CommonConstants.DEFAULT_DISTANCE, threeParametersHorse.getDistance());
        assertEquals(0, twoParametersHorse.getDistance());
    }

    @Test
    @Order(4)
    void parametersOfGetRandomDouble() {
        try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {
            threeParametersHorse.move();
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

    @Test
    @Order(5)
    void resultOfGetRandomDouble() {
        try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {
            mockedStatic.when(() -> Horse.getRandomDouble(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(1D);
            twoParametersHorse.move();
            assertEquals(twoParametersHorse.getSpeed(), twoParametersHorse.getDistance());
            mockedStatic.when(() -> Horse.getRandomDouble(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(0D);
            twoParametersHorse.move();
            assertEquals(twoParametersHorse.getSpeed(), twoParametersHorse.getDistance());
            mockedStatic.when(() -> Horse.getRandomDouble(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(1D);
            twoParametersHorse.move();
            assertEquals(twoParametersHorse.getSpeed() * 2, twoParametersHorse.getDistance());
        }
    }
}