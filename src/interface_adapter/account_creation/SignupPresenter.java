package interface_adapter.account_creation;

import interface_adapter.Login.LoginViewModel;
import interface_adapter.ViewModelManager;
import use_case.account_creation.AccountCreationOutputBoundary;
import use_case.account_creation.AccountCreationOutputData;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SignupPresenter implements AccountCreationOutputBoundary {

    private final SignupViewModel signupViewModel;
    private final ViewModelManager viewModelManager;
    private final LoginViewModel loginViewModel;


    public SignupPresenter(ViewModelManager viewModelManager, SignupViewModel signupViewModel, LoginViewModel loginViewModel) {
        this.viewModelManager = viewModelManager;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
    }

    /**
     * changes the view to show the successful account creation
     * @param user - User of program
     */
    @Override
    public void setPassView(AccountCreationOutputData user) {
        if (user == null || user.getCreationTime() == null) {
            throw new NullPointerException("AccountCreationOutputData or its creationTime is null");
        }


        LocalTime responseTime = LocalTime.parse(user.getCreationTime(), DateTimeFormatter.ISO_LOCAL_TIME);
        user.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        signupViewModel.setUsername(user.getUsername());
        signupViewModel.setError(null);
        signupViewModel.firePropertyChanged("updateSuccess", null, "Account successfully created!");

        viewModelManager.setActiveView("LoginView");
        viewModelManager.firePropertyChanged();
    }

    /**
     * presents the failed account creation
     * @param error - error message
     */
    @Override
    public void setFailView(String error) {
        signupViewModel.setError(error);
        signupViewModel.firePropertyChanged("generalError", null, error);
    }
}
