package org.acme;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

//    @POST
//    @Path("/user")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response createUser(User user)
//    {
//        System.out.println(user.getFirstname());
//        return Response.created(URI.create("1")).build();
//    }

//    @GET
//    @Path("/user")
//    @Produces(MediaType.APPLICATION_JSON)
//    public User getUserData()
//    {
//        final User user = new User();
//        user.setFirstname("first name for testing");
//
//        return user;
//    }
//
//    @GET
//    @Path("/username")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getUserName()
//    {
//        final User user = new User();
//        user.setFirstname("first name for testing");
//
//        return user.getFirstname();
//    }
}