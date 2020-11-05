package web;


import org.springframework.data.domain.PageRequest;
import service.MemberService;
import service.dto.MemberDTO;
import service.dto.PageableImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;


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
    public Response saveMember(MemberDTO m) throws URISyntaxException {
            MemberDTO result = service.addMember(m);
            return Response.created(new
                    URI("/application/member/add/" + result.getId())).entity(result).build();
    }

    @GET
    @Path("/members/{page}")
    public Response getAllMembers(@PathParam(value = "page") int page)
    {
        System.out.println("REST request to get all member");
        try {
            PageRequest pageRequest = PageRequest.of(page,4);

            return Response.ok().entity(service.findAll(pageRequest)).build();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    @GET
    @Path("/members")
    public Response findAllMembers()
    {
        System.out.println("REST request to get all member");
        try {
            return Response.ok().entity(service.findAllMember()).build();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }


    @GET
    @Path("/member/{id}")
    public Response getUserById(@PathParam(value="id") Long _id)
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
    public Response UpdateUser(MemberDTO m)
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
