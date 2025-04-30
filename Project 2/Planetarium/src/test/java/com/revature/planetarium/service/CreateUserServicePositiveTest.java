package com.revature.planetarium.service;

import com.revature.planetarium.entities.User;
import com.revature.planetarium.repository.user.UserDao;
import com.revature.planetarium.repository.user.UserDaoImp;
import com.revature.planetarium.service.user.UserService;
import com.revature.planetarium.service.user.UserServiceImp;
import com.revature.planetarium.util.TestUtilities;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@RunWith(Parameterized.class)
public class CreateUserServicePositiveTest {

    private UserDao userDao;
    private UserService userService;

    private User positiveUser;
    private User stubbedUser;

    @Parameterized.Parameter
    public String username;
    @Parameterized.Parameter(1)
    public String password;
    @Parameterized.Parameters
    public static String[][] inputs() {
        return new String[][]{
                {"Robin", "Bobb1"},
                {"bobby", "Bobb1"},
                {"Robin_1-5", "Bobb1"},
                {"Robin", "Bob_b-1"}
        };
    }

    @Before
    public void setup() throws IOException, InterruptedException {
        TestUtilities.resetDatabase();
        // since we are unit testing the service we need to mock the dao
        userDao = Mockito.mock(UserDaoImp.class);
        userService = new UserServiceImp(userDao);
        positiveUser = new User(0,username,password);
        // this is the user we will return to simulate getting back our newly created user from the database
        stubbedUser = new User(3,username,password);
    }

    @Test
    public void createUserServicePositiveTest() throws SQLException {
        // since this is a happy path execution, the dao should return an empty optional since the username should not be present in the database
        Mockito.when(userDao.findUserByUsername(positiveUser.getUsername())).thenReturn(Optional.empty());
        // the next stub is telling Mockito to return an object that we would expect if we called the real message
        Mockito.when(userDao.createUser(positiveUser)).thenReturn(Optional.of(stubbedUser));
        String result = userService.createUser(positiveUser);
        Assert.assertEquals("User created successfully", result);
    }

}
