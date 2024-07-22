package entity;

import java.time.LocalDateTime;
import java.util.List;

public interface User {
    /**
     *
     * @return information of User
     */
    String getUsername();

    String getPassword();
  
    String getBio();

    String getProgramOfStudy();

    Integer getAge();

    List<String> getInterests();

    List<String> getFriends();

    List<String> getChats();

    LocalDateTime getDateCreated();

    void setUsername(String username);

    void setPassword(String password);

    void setBio(String bio);

    void setProgramOfStudy(String programOfStudy);

    void setAge(Integer age);

    void setInterests(List<String> interests);

    void setFriends(List<String> friends);

    void setChats(List<String> chats);

    void getChats(List<String> chats);

    void setDateCreated(LocalDateTime dateCreated);

}
