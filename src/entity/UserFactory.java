package entity;

import java.time.LocalDateTime;
import java.util.List;

public interface UserFactory {
    /**
     *
     * @param name
     * @param password
     * @param bio
     * @param age
     * @param program
     * @param interest
     * @param friends
     * @param chats
     * @param date
     * @return new User object
     */
    User createUser(String name, String password, String bio, Integer age, String program, List<String> interest
            , List<String> friends, List<String> chats, LocalDateTime date);
}


