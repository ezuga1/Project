package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.UserDaoSQLImpl;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MarketException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;


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
    /**
     * Test for username which doesn't exist in database
     */
    @Test
    void addWrong() throws MarketException {
        MockedStatic<DaoFactory> daoFactoryMockedStatic = Mockito.mockStatic(DaoFactory.class);
        daoFactoryMockedStatic.when(DaoFactory::userDao).thenReturn(userDaoSQLMock);

        when(DaoFactory.userDao().getAll()).thenReturn(users);
        Mockito.doCallRealMethod().when(userManager).add(user);
        Assertions.assertEquals(false, userManager.validate(user.getUsername(),user.getPassword()));
        daoFactoryMockedStatic.verify(DaoFactory::userDao);
        Mockito.verify(userManager).validate(user.getUsername(),user.getPassword());
        daoFactoryMockedStatic.close();
    }
}
