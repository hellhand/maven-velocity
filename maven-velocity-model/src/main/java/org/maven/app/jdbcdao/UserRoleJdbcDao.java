package org.maven.app.jdbcdao;

import com.jpattern.orm.JPOrm;
import org.maven.app.dao.UserRoleDao;
import org.maven.app.model.User;
import org.maven.app.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marc
 * Date: 16/08/13
 * Time: 01:55
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class UserRoleJdbcDao implements UserRoleDao {

    @Autowired
    private JPOrm jpOrm;

    @Override
    public List<UserRole> getRolesByUser(User user) {
        return jpOrm.session().findQuery(UserRole.class).where().eq("userId", user.getId()).query().findList();
    }
}
