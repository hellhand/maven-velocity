package org.maven.app.model;

import org.junit.Assert;
import org.junit.Test;
import org.maven.app.dao.UserDao;
import org.maven.app.test.JdbcUnitTest;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest extends JdbcUnitTest {

    @Autowired
    UserDao userDao;
    
    @Test
    public void testReading() {
        User user = userDao.getUserByUsername("myself");
        Assert.assertNotNull(user);
        Assert.assertTrue("myself".equals(user.getUsername()));
    }
    
    @Test
    public void testInsertion() {
        User user = new User();
        user.setEnabled(true);
        user.setUsername("marc");
        user.setPassword("myself");
        userDao.addUser(user);
        
        User dbuser = userDao.getUserByUsername("marc");
        Assert.assertNotNull(dbuser);
        Assert.assertTrue("marc".equals(dbuser.getUsername()));
    }
}
