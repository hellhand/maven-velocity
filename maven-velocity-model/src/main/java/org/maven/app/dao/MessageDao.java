package org.maven.app.dao;

import org.maven.app.model.Message;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: marc
 * Date: 05/04/14
 * Time: 20:36
 * To change this template use File | Settings | File Templates.
 */

@Transactional
public interface MessageDao {

    Message getTranslation(String key);
}
