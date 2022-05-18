package test;

import UI.panel.ReductionPanel;
import businessLogic.EventsManagementBusiness;
import exception.CalculateReductionException;
import exception.DataAccessException;
import exception.ReductionBetweenException;
import model.BusinessTaskModel;
import model.TestModel;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.ArrayList;


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

    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test ended " + i);
        i++;
    }

    /* ----------------------------- a supprimer apres nouveau test ------------*/
    @Test
    @DisplayName("throws DataAccessException")
    public void testException() {
        DataAccessException thrown = Assertions.assertThrows(DataAccessException.class, () -> {
            eventsManagementBusiness.getEvent(-1);
        });
        Assertions.assertEquals("The value -1 isn't correct !", thrown.getMessage());
    }

    @Test
    @DisplayName("correct value with promotion")
    public void test_correct_value() throws DataAccessException, SQLException {
        String res = eventsManagementBusiness.getInformationEvent(1);
        String expected = " - Number of participants : 5\n"
                    + " - Total sum : 37.5\n"
                    + " - Total promotion : 20.625\n"
                    + " - Final sum : 16.875\n";
        Assertions.assertEquals( expected, res);
    }

    @Test
    @DisplayName("correct value without promotion")
    public void test_correct_value_2() throws DataAccessException, SQLException {
        String res = eventsManagementBusiness.getInformationEvent(5);
        String expected = " - Number of participants : 4\n"
                + " - Total sum : 60.0\n"
                + " - Total promotion : 0.0\n"
                + " - Final sum : 60.0\n";
        Assertions.assertEquals( expected, res);
    }

    @Test
    @DisplayName("event not exist")
    public void no_existent_line() throws DataAccessException, SQLException {
        String res = eventsManagementBusiness.getInformationEvent(25);
        String expected = " - Number of participants : 0\n"
                + " - Total sum : 0.0\n"
                + " - Total promotion : 0.0\n"
                + " - Final sum : 0.0\n";
        Assertions.assertEquals ( expected, res);
    }

    /* -------------------------------------------------------------------------------*/

    /* exemple voir si correct */
    @Test
    public void test() throws CalculateReductionException, ReductionBetweenException {

        // Du coup ici au lieau d'avoir une liste JPanel, on a une liste d'objet et ce sera plus simple de recuper nos données d'ajouter des données ...
        ArrayList<TestModel> testModels = new ArrayList<>();
        testModels.add(new TestModel(50,100.0));
        testModels.add(new TestModel(10, 10.0));
        BusinessTaskModel actual = eventsManagementBusiness.calculateReduction(100, 9.99, testModels);
        BusinessTaskModel expected = new BusinessTaskModel(100,489.51,999.0,509.49);
        Assertions.assertEquals(489.51, actual.getSumFinal());
    }

}
