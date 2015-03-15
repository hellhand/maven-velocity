package org.maven.app.model;

import com.jpattern.orm.annotation.Column;
import com.jpattern.orm.annotation.Generator;
import com.jpattern.orm.annotation.Id;
import com.jpattern.orm.annotation.Table;
import com.jpattern.orm.annotation.generator.GeneratorType;

/**
 * Created with IntelliJ IDEA.
 * User: marc
 * Date: 05/04/14
 * Time: 20:37
 * To change this template use File | Settings | File Templates.
 */
@Table(tableName = "messages")
public class Message {

    @Id
    @Column(name = "message_id")
    @Generator(generatorType = GeneratorType.SEQUENCE, name = "message_seq")
    private Integer id;

    private String key;

    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
