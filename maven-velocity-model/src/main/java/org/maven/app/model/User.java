package org.maven.app.model;

import com.jpattern.orm.annotation.Column;
import com.jpattern.orm.annotation.Generator;
import com.jpattern.orm.annotation.Id;
import com.jpattern.orm.annotation.Table;
import com.jpattern.orm.annotation.generator.GeneratorType;

@Table(tableName = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @Generator(generatorType = GeneratorType.SEQUENCE, name = "users_seq")
    private Integer id;
    private String username;
    private String password;
    private Boolean enabled;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
