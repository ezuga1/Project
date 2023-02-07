package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.UserDaoSQLImpl;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MarketException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UserManagerTest {
    private UserManager userManager;
    private User user;
    private UserDaoSQLImpl userDaoSQLMock;
    private List<User> users;

    /**
     * This method will be called before each test method
     */
    @BeforeEach
    public void initalizeObjectsWeNeed(){
        userManager = Mockito.mock(UserManager.class);
        user = new User();
        user.setUsername("Test");
        user.setPassword("Test");
        user.setEmailAddress("test@test.com");
        user.setId(20);

        userDaoSQLMock = Mockito.mock(UserDaoSQLImpl.class);
        users = new ArrayList<>();
        users.addAll(Arrays.asList(new User("Test"), new User("User"), new User("Test_User"), new User("User_Test")));
    }
}
