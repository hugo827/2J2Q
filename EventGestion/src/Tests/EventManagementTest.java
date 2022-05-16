package Tests;

import BusinessLogic.EventsManagementBusiness;
import Exceptions.DataAccessException;
import org.junit.jupiter.api.*;

import java.sql.SQLException;


public class EventManagementTest {

    private static EventsManagementBusiness eventsManagementBusiness;
    private static int i = 1;


    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Test started");
        eventsManagementBusiness = new EventsManagementBusiness();
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Test finished");
    }
    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Setting up for test " + i);
        i++;
    }

    @AfterEach
    public void tearDown() throws Exception {

    }


    @Test
    @DisplayName("throws DataAccessException")
    public void testException() {
        DataAccessException thrown = Assertions.assertThrows(DataAccessException.class, () -> {
            eventsManagementBusiness.getEvent(-1);
        });
        Assertions.assertEquals("This value -1 isn't correct !", thrown.getMessage());
    }

    @Test
    @DisplayName("Test return correct value with promotion")
    public void test_correct_value() throws DataAccessException, SQLException {
        String res = eventsManagementBusiness.getInformationEvent(1);
        String expected = " - Nombre de participant : 5\n"
                    + " - Somme total : 37.5\n"
                    + " - Somme total prommotion : 20.625\n"
                    + " - Somme final : 16.875\n";
        Assertions.assertEquals( expected, res);
    }

    @Test
    @DisplayName("Test return correct value without promotion")
    public void test_correct_value_2() throws DataAccessException, SQLException {
        String res = eventsManagementBusiness.getInformationEvent(5);
        String expected = " - Nombre de participant : 4\n"
                + " - Somme total : 60.0\n"
                + " - Somme total prommotion : 0.0\n"
                + " - Somme final : 60.0\n";
        Assertions.assertEquals( expected, res);
    }

    @Test
    @DisplayName("event not exist")
    public void non_existent_line() throws DataAccessException, SQLException {
        String res = eventsManagementBusiness.getInformationEvent(25);
        String expected = " - Nombre de participant : 0\n"
                + " - Somme total : 0.0\n"
                + " - Somme total prommotion : 0.0\n"
                + " - Somme final : 0.0\n";
        Assertions.assertEquals ( expected, res);
    }

}
