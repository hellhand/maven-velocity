package org.maven.app.velocity;

import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.config.ValidScope;
import org.maven.app.dao.MessageDao;
import org.maven.app.model.Message;
import org.maven.app.spring.ApplicationContextProvider;
import org.springframework.context.ApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: marc
 * Date: 05/04/14
 * Time: 20:51
 * To change this template use File | Settings | File Templates.
 */

@ValidScope(value = {Scope.APPLICATION})
@DefaultKey("translator")
public class TranslationTool {

    private MessageDao messageDao;

    private ApplicationContext applicationContext;

    public TranslationTool() {
        applicationContext = ApplicationContextProvider.getApplicationContext();
        messageDao = applicationContext.getBean(MessageDao.class);
    }

    public String translate(String key) {
        Message message = messageDao.getTranslation(key);
        return message == null ? key : message.getMessage();
    }
}
