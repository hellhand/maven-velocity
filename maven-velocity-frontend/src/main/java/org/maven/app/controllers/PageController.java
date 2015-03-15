package org.maven.app.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.api.view.Viewable;
import org.springframework.stereotype.Component;

@Component
@Path("/otherpage")
public class PageController {
    
    @GET
    @Path("page1")
    @Produces(MediaType.TEXT_HTML)
    public Response getOtherPage() {
        return Response.status(Status.OK).entity(new Viewable("page1")).build();
    }

}
