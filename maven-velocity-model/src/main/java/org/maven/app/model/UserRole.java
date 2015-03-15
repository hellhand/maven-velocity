package org.maven.app.model;

import com.jpattern.orm.annotation.Table;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created with IntelliJ IDEA.
 * User: marc
 * Date: 16/08/13
 * Time: 01:53
 * To change this template use File | Settings | File Templates.
 */
@Table(tableName = "user_roles")
public class UserRole implements GrantedAuthority {

    private String userRoleId;
    private String userId;
    private String authority;

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
