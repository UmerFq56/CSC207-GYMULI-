package interface_adapter.account_creation;

import use_case.account_creation.AccountCreationInputBoundary;
import use_case.account_creation.AccountCreationInputData;

import java.time.LocalDateTime;
import java.util.List;

public class SignupController {

    private final AccountCreationInputBoundary accountCreationInputBoundary;

    public SignupController(AccountCreationInputBoundary accountCreationInputBoundary) {
        this.accountCreationInputBoundary = accountCreationInputBoundary;
    }

    /**
     * executes the creation of the account given the info
     * @param username - username
     * @param password - password
     * @param repeatPassword - prompt to type password again
     * @param programOfStudy - university program user is taking
     * @param interests - personal interests
     * @param bio - biography by user
     * @param age - age of user
     */

    public void execute(String username, String password, String repeatPassword, String programOfStudy, List<String> interests, String bio, Integer age) {
        AccountCreationInputData inputData = new AccountCreationInputData(username, password, repeatPassword, programOfStudy, interests, bio, LocalDateTime.now(), age);
        accountCreationInputBoundary.execute(inputData);
    }

}