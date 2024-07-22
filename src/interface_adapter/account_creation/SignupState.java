package interface_adapter.account_creation;

import java.util.ArrayList;
import java.util.List;

public class SignupState {

    private String username = "";
    private String password = "";
    private String repeatPassword = "";
    private String programOfStudy = "";
    private String bio = "";
    private Integer age;
    private String interest1 = "";
    private String interest2 = "";
    private String interest3 = "";
    private String error = "";


    public SignupState() {
    }

    /**
     * the following are setter and getter method to set and retrieve the account information
     * @return each the elements of an account
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getProgramOfStudy() {
        return programOfStudy;
    }

    public void setProgramOfStudy(String programOfStudy) {
        this.programOfStudy = programOfStudy;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInterest1() {
        return interest1;
    }

    public void setInterest1(String interest1) {
        this.interest1 = interest1;
    }

    public String getInterest2() {
        return interest2;
    }

    public void setInterest2(String interest2) {
        this.interest2 = interest2;
    }

    public String getInterest3() {
        return interest3;
    }

    public void setInterest3(String interest3) {
        this.interest3 = interest3;
    }

    public List<String> getInterests() {
        List<String> interests = new ArrayList<>();
        interests.add(interest1);
        interests.add(interest2);
        interests.add(interest3);
        return interests;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
