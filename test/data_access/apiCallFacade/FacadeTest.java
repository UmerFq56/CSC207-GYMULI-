package data_access.apiCallFacade;

import data_access.apiCallFacade.apiCaller.APICallerInterface;
import data_access.apiCallFacade.dbUpdater.MapUpdaterInterface;
import data_access.apiCallFacade.mapGenerator.MapGeneratorInterface;
import data_access.readDB.readDBInterface;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FacadeTest {

    private Facade facade;
    private MapGeneratorInterface mockMapGenerator;
    private MapUpdaterInterface mockMapUpdater;
    private APICallerInterface mockApiCaller;
    private readDBInterface mockMongoConnection;
    private User mockUser;
    private Map<String, User> mockAccounts;

    @BeforeEach
    void setUp() {
        mockMapGenerator = mock(MapGeneratorInterface.class);
        mockMapUpdater = mock(MapUpdaterInterface.class);
        mockApiCaller = mock(APICallerInterface.class);
        mockMongoConnection = mock(readDBInterface.class);

        mockUser = mock(User.class);
        mockAccounts = new HashMap<>();

        facade = new Facade(mockMongoConnection);
        facade.mapGenerator = mockMapGenerator;
        facade.mapUpdater = mockMapUpdater;
        facade.apiCaller = mockApiCaller;
    }

    @Test
    void getMap_returnsGeneratedMap() {
        Map<User, Double> mockMap = new HashMap<>();
        when(mockMapGenerator.generateDoc(mockUser, 5, mockAccounts)).thenReturn(mockMap);

        Map<User, Double> result = facade.getMap(mockUser, mockAccounts, 5);

        assertEquals(mockMap, result);
        verify(mockMapGenerator).generateDoc(mockUser, 5, mockAccounts);
    }

//    @Test
//    void updateDB_updatesMapWithGeneratedData() {
//        // Arrange
//        Map<String, Double> generatedMap = new HashMap<>();
//        when(mockMapGenerator.generateMap(mockUser, mockAccounts)).thenReturn(generatedMap);
//
//        facade.UpdateDB(mockUser, mockAccounts);
//
//        verify(mockMapGenerator).generateMap(mockUser, mockAccounts);
//        verify(mockMapUpdater).updateMap(generatedMap, mockMongoConnection);
//    }

    @Test
    void filter_callsApiFilter() {
        String text = "some text";
        String filteredText = "filtered text";
        when(mockApiCaller.filterProfanity(text)).thenReturn(filteredText);

        String result = facade.filter(text);

        assertEquals(filteredText, result);
        verify(mockApiCaller).filterProfanity(text);
    }

    @Test
    void use_paid_togglesPaidApiUsage() {
        facade.use_paid(true);

        verify(mockApiCaller).use_paid(true);
    }
}