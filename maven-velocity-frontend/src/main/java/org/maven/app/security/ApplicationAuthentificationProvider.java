package org.maven.app.security;

import org.apache.log4j.Logger;
import org.maven.app.dao.UserDao;
import org.maven.app.dao.UserRoleDao;
import org.maven.app.model.User;
import org.maven.app.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationAuthentificationProvider implements AuthenticationProvider {
    
    private static Logger logger = Logger.getLogger(ApplicationAuthentificationProvider.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        logger.info("Login from " + auth.getCredentials() + " " + auth.getPrincipal());

        User user = userDao.getUserByUsername((String) auth.getPrincipal());
        if (user == null || user.getPassword() == null || !user.getPassword().equals(auth.getCredentials())) {
            throw new BadCredentialsException("User tried to login with wrong user : " + auth.getPrincipal());
        }
        List<UserRole> authorities = userRoleDao.getRolesByUser(user);

        return new UsernamePasswordAuthenticationToken(user, auth.getPrincipal(), authorities) ;
    }

    @Override
    public boolean supports(Class<? extends Object> action) {
        return action.equals(UsernamePasswordAuthenticationToken.class);
    }

}
