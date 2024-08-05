package data_access.apiCallFacade;

import data_access.readDB.MongoConnection;
import data_access.apiCallFacade.apiCaller.APICaller;
import data_access.apiCallFacade.apiCaller.APICallerInterface;
import data_access.apiCallFacade.mapGenerator.MapGenerator;
import data_access.apiCallFacade.mapGenerator.MapGeneratorInterface;
import data_access.apiCallFacade.dbUpdater.MapUpdater;
import data_access.apiCallFacade.dbUpdater.MapUpdaterInterface;
import data_access.readDB.readDBInterface;
import entity.User;

import java.util.*;

public class Facade implements FacadeInterface {
    MapGeneratorInterface mapGenerator = new MapGenerator();
    MapUpdaterInterface mapUpdater = new MapUpdater();
    APICallerInterface apiCaller = new APICaller();
    readDBInterface mongoConnection = new MongoConnection();

    public Facade(MapGeneratorInterface mapGenerator, MapUpdaterInterface mapUpdater, APICallerInterface apiCaller) {
        this.mapGenerator = mapGenerator;
        this.mapUpdater = mapUpdater;
        this.apiCaller = apiCaller;
        this.mongoConnection = new MongoConnection();
    }

    public Facade(){}

    public Facade(readDBInterface mongoConnection){
        this.mongoConnection = mongoConnection;
    }

    public void UpdateDB(User user, Map<String,User> accounts){
        mapUpdater.updateMap(mapGenerator.generateMap(user, accounts), mongoConnection);
    }

    public String filter(String text){
        return apiCaller.filterProfanity(text);
    }

    public void use_paid(boolean paid){
        apiCaller.use_paid(paid);
    }
}
