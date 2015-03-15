package org.maven.app.controllers;

import com.sun.jersey.api.view.Viewable;
import org.maven.app.dao.UserDao;
import org.maven.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component
@Path("/")
public class HelloController {
    
    Logger logger = Logger.getLogger(HelloController.class.getCanonicalName());

    @Autowired
    private UserDao userDao;
    
    @GET
    @Path("login")
    @Produces(MediaType.TEXT_HTML)
    public Response getLogin(@Context HttpServletRequest request, @QueryParam(value = "access") String access) {
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("access-error", access);

        return Response.status(Status.OK).entity(new Viewable("login", model)).build();
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getHello(@Context HttpServletRequest request) {
        User user = userDao.getUserByUsername(request.getUserPrincipal().getName());

        Map<String,Object> model = new HashMap<String, Object>();
        model.put("user", user);

        return Response.status(Status.OK).entity(new Viewable("hello", model)).build();
    }
    
    @GET
    @Path("logout")
    @Produces(MediaType.TEXT_HTML)
    public Response postLogin() {
        return Response.ok("/").build();
    }
}
