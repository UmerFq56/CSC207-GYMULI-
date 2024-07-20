package data_access.similarityMapUpdaterFacade;

import data_access.similarityMapUpdaterFacade.mapGenerator.MapGenerator;
import data_access.similarityMapUpdaterFacade.mapGenerator.MapGeneratorInterface;
import data_access.similarityMapUpdaterFacade.mapUpdater.MapUpdater;
import data_access.similarityMapUpdaterFacade.mapUpdater.MapUpdaterInterface;
import entity.User;

import java.time.LocalDateTime;
import java.util.*;

import entity.CommonUserFactory;

import static data_access.userMap_ignore.getMap;

public class Facade implements FacadeInterface {

    public void UpdateDB(User user, Map<String, User> accounts){
        MapGeneratorInterface mapGenerator = new MapGenerator();
        MapUpdaterInterface mapUpdater = new MapUpdater();
        mapUpdater.updateMap(mapGenerator.generateMap(user, accounts)) ;
    }


    // ignore this, testing purposes only
    public static void main(String[]args){
        // Create an instance of CommonUserFactory
        CommonUserFactory userFactory = new CommonUserFactory();

        List<String> hobbies5 = new ArrayList<>();
        hobbies5.add("Dancing");
        hobbies5.add("Painting");

        List<String> friends5 = new ArrayList<>();
        friends5.add("Charlie");
        friends5.add("David");

        List<String> chats5 = new ArrayList<>();
        chats5.add("Chat9");
        chats5.add("Chat10");

        User user = userFactory.createUser(
                "Mayank Bharwal", "password131415", "Bio for Eve", 29, "Computer Science",
                hobbies5, friends5, chats5, LocalDateTime.now()
        );

        Map<String, User> accounts = new HashMap<>();
        accounts = getMap();

        FacadeInterface facade = new Facade();
        facade.UpdateDB(user, accounts);
    }
}
