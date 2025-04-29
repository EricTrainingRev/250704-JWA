package com.revature.planetarium.repository.user;

import com.revature.planetarium.entities.User;
import com.revature.planetarium.util.TestUtilities;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

/*
    Looking over my test data, I have multiple usernames and passwords that are valid that
    cover various requirements for the Planetarium application. This makes the createUser method a
    good candidate for a parameterized test using the Parameterized test runner
 */
@RunWith(Parameterized.class)
public class CreateUserPositiveTest {

    private UserDao userDao;

    private User positiveUser;

    @Parameterized.Parameter
    public String username;
    @Parameterized.Parameter(1)
    public String password;

    @Parameterized.Parameters
    public static String[][] inputs(){
        return new String[][]{
                /*
                    You can cover multiple requirements per row of data if needed, but keep in mind the
                    more requirements you are testing per row of data, the less specificity you have in
                    your test results

                    Keep in mind the test values here are hard coded, for long term use it would be better
                    to have the test data stored in a resource like an excel or csv file for ease of refactoring
                 */
                {"Robin","Bobb1"},
                {"bobby","Bobb1"},
                {"Robin_1-5","Bobb1"},
                {"Robin","Bob_b-1"}
        };
    }

    /*
        To keep my test resources organized I will create and
        assign all test resources within the setup method, so any
        refactoring I need to do can be handled in one place instead
        of my needing to hunt down all references to any refactored
        resources
     */
    @Before
    public void setup() throws IOException, InterruptedException {
        // make sure to reset your test database between tests
        // current reset method requires planetarium to be up and running to ping the reset route
        TestUtilities.resetDatabase();
        userDao = new UserDaoImp();
        positiveUser = new User(0,username,password);
    }

    @Test
    public void createUserPositiveTest() throws SQLException {
        Optional<User> result = userDao.createUser(positiveUser);
        // here we check that the user was actually returned
        Assert.assertTrue(result.isPresent());
        User returnedUser = result.get();
        // here we check that the user object was assigned a new Id
        Assert.assertTrue(returnedUser.getId() > 0);

    }

}
