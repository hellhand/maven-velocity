package org.maven.app.dao;

import org.maven.app.model.User;
import org.maven.app.model.UserRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marc
 * Date: 16/08/13
 * Time: 01:53
 * To change this template use File | Settings | File Templates.
 */

@Transactional
public interface UserRoleDao {

    public List<UserRole> getRolesByUser(User user);
}
