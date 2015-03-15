package org.maven.app.controllers;

import com.sun.jersey.api.view.Viewable;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: marc
 * Date: 16/08/13
 * Time: 18:40
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/error/")
public class ErrorController {

    @GET
    @Path("404")
    @Produces(MediaType.TEXT_HTML)
    public Response handle404() {
        return Response.status(Response.Status.OK).entity(new Viewable("error/404")).build();
    }

    @GET
    @Path("500")
    @Produces(MediaType.TEXT_HTML)
    public Response handle500() {
        return Response.status(Response.Status.OK).entity(new Viewable("error/500")).build();
    }

}
