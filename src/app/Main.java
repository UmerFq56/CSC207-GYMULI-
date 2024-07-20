package app;

import data_access.MongoConnection;
import interface_adapter.Login.LoginPresenter;
import interface_adapter.Login.LoginViewModel;
import interface_adapter.account_creation.SignupViewModel;
import interface_adapter.ViewModelManager;
import use_case.account_creation.AccountCreationInputBoundary;
import use_case.account_creation.AccountCreationInteractor;
import use_case.account_creation.AccountCreationOutputBoundary;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.account_creation.SignupPresenter;
import data_access.UserDataAccessObject;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import views.MainView;
import views.LoginView;
import views.SignupView;
import views.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        JFrame application = new JFrame("GYMULI");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setPreferredSize(new Dimension(800, 600));

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewModelManager viewModelManager = new ViewModelManager();
        new ViewManager(views, cardLayout, viewModelManager);

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();

        MongoConnection mongoConnection = new MongoConnection();

        UserFactory userFactory = new CommonUserFactory();
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject(userFactory, new HashMap<>(), mongoConnection);

        AccountCreationOutputBoundary accountCreationOutputBoundary = new SignupPresenter(viewModelManager, signupViewModel, loginViewModel);
        AccountCreationInputBoundary accountCreationInputBoundary = new AccountCreationInteractor(userDataAccessObject, accountCreationOutputBoundary, userFactory);

        SignupView signupView = SignupViewFactory.create(viewModelManager, loginViewModel, signupViewModel, accountCreationInputBoundary);
        views.add(signupView, signupView.viewName);

        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(loginViewModel, viewModelManager);
        LoginInputBoundary loginInputBoundary = new LoginInteractor(loginOutputBoundary, userDataAccessObject);

        LoginView loginView = LoginViewFactory.create(viewModelManager, loginViewModel, loginInputBoundary);
        views.add(loginView, loginView.viewName);

        MainView chatView = new MainView();
        views.add(chatView, MainView.viewName);

        viewModelManager.setActiveView(loginView.viewName);
        viewModelManager.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}

