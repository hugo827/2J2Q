package test;

import businessLogic.EventsManagementBusiness;
import exception.CalculateReductionException;
import exception.EventException;
import exception.ReductionBetweenException;
import model.BusinessTaskModel;
import model.ReductionModel;
import model.UserModel;
import org.junit.jupiter.api.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


public class EventManagementTest {

    private static EventsManagementBusiness eventsManagementBusiness;

    private BusinessTaskModel actual;

    private  ArrayList<ReductionModel> reductionModels;
    private UserModel userModel;


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
        reductionModels = new ArrayList<>();
        reductionModels.add(new ReductionModel(50,100.0));
        reductionModels.add(new ReductionModel(10, 10.0));
        actual = eventsManagementBusiness.calculateReduction(100, 9.99, reductionModels);
    }

    @AfterEach
    public void tearDown() throws Exception {

    }

    @Test
    @DisplayName("Test de la sum final ")
    public void compare_sumFinal(){
        Assertions.assertEquals(489.51, actual.getSumFinal(), 0.01);
    }

    @Test
    @DisplayName("Test de la reduction ")
    public void compare_reduction() {
        Assertions.assertEquals(509.49, actual.getSumTotalPromotion(),0.01);
    }

    @Test
    @DisplayName("Test exception reduction null")
    public void verifie_exception_reduction() {
        reductionModels.add(new ReductionModel(null,null));
        Assertions.assertThrows(CalculateReductionException.class, () -> eventsManagementBusiness.calculateReduction(100,9.99, reductionModels));
    }

    @Test
    @DisplayName("Test exception reduction supérieur à 100")
    public void verifie_exception() {
        reductionModels.add(new ReductionModel(10,150.0));
        Assertions.assertThrows(ReductionBetweenException.class, () -> eventsManagementBusiness.calculateReduction(100,9.99, reductionModels));
    }

    @Test
    @DisplayName("Test setters nbr d'enfants inférieur à 0")
    public void verifie_setter_bChildren() throws EventException, ParseException {
        String date = "2000/12/24";
        Date Date = new SimpleDateFormat("yyyy/MM/dd").parse(date);
        userModel=new UserModel("Jean","Weber",Date,true,"gendarme",-3,1);
         Assertions.assertEquals(0,userModel.getNbChildren());
    }

}