package web;


import pojo.Member;
import service.MemberService;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/application")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MemberResource {

    private final MemberService service;

    @Inject
    public MemberResource(MemberService memberService) {
        this.service = memberService;
    }


    // @Path("/member/{id}") => @PathParam
    // @Path("/member") => @QueryParam
    // @Path("/member") => body


    @POST
    @Path("/member/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveMember(Member m) {
        return Response.ok().entity(service.addMember(m)).build();
    }

    @GET
    @Path("/members")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMembers()
    {
        System.out.println("REST request to get all member");
        try {
            return Response.ok().entity(service.findAll()).build();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("/member/{_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam(value="_id") Long _id)
    {
        System.out.println("REST request get member by id");
        try {
            return Response.ok().entity(service.FindMemberById(_id)).build();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    @PUT
    @Path("/member/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response UpdateUser(Member m)
    {
        System.out.println("REST request update member by id");
        try {
            return Response.ok().entity(service.UpdateUser(m)).build();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }


    @DELETE
    @Path("/member/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateUser(@PathParam(value="id") Long id)
    {
        System.out.println("REST request delete member by id");
        try {

             service.DeleteUser(id);
            return Response.ok().build();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

}
