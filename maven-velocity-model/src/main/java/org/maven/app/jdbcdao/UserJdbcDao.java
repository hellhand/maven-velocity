package org.maven.app.jdbcdao;

import com.jpattern.orm.JPOrm;
import org.maven.app.dao.UserDao;
import org.maven.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcDao implements UserDao {

    @Autowired
    private JPOrm jpOrm;

    public User getUserByUsername(String username) {
        return jpOrm.session().findQuery(User.class).where().eq("username", username).query().find();
    }

    public void addUser(User user) {
        jpOrm.session().save(user);
    }
}
