package org.maven.app.velocity;

import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.config.ValidScope;
import org.maven.app.spring.ApplicationContextProvider;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * Created with IntelliJ IDEA.
 * User: marc
 * Date: 05/04/14
 * Time: 20:51
 * To change this template use File | Settings | File Templates.
 */

@ValidScope(value = {Scope.APPLICATION})
@DefaultKey("path")
public class PathTool {

    private ApplicationContext applicationContext;

    private ServletContext servletContext;

    public PathTool() {
        this.applicationContext = ApplicationContextProvider.getApplicationContext();
        this.servletContext = applicationContext.getBean(ServletContext.class);
    }

    public String getPath() {
        return servletContext.getContextPath();
    }
}
