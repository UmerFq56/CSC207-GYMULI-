package entity;

import java.time.LocalDateTime;
import java.util.List;

public interface UserFactory {
    User create(String name, String password, String bio, Integer age, String program, List<String> interest
            , List<String> friends, LocalDateTime date);
}


