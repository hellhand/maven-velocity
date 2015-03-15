package org.maven.app.jdbcdao;

import com.jpattern.orm.JPOrm;
import org.maven.app.dao.MessageDao;
import org.maven.app.model.Message;
import org.maven.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: marc
 * Date: 05/04/14
 * Time: 20:39
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class MessageJdbcDao implements MessageDao {

    @Autowired
    private JPOrm jpOrm;

    @Override
    public Message getTranslation(String key) {
        return jpOrm.session().findQuery(Message.class).where().eq("key", key).query().find();
    }
}
