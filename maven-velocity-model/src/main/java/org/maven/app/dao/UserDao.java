package org.maven.app.dao;

import org.maven.app.model.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDao {

    public User getUserByUsername(String username);

    public void addUser(User user);
}
