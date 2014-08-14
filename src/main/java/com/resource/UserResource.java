package com.resource;

import static com.util.PathConstants.USERS_SERVICE_PATH;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.WebApplicationException;

import com.persistence.beans.User;
import com.persistence.service.UserService;
/**
 */
@Path(USERS_SERVICE_PATH)
public class UserResource {

    private static final String AUTHENTICATE_RESOURCE_PATH = "/authenticate";
    private static final String USER_RESOURCE_PATH = "/{userId}";

    private UserService userService = new UserService();

    @POST
    @Path("")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public User addUser(User user)
    {
        User  userAdded = new User();
        userAdded = getUserService().addUser(user);
        if(null == userAdded){
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return userAdded;
    }

    /**
     * curl -X GET http://127.0.0.1:9090/freeapis/users/authenticate?email=xyz@abc.com&password=xyzabc
     */
    @GET
    @Path(AUTHENTICATE_RESOURCE_PATH)
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    public User authenticateUser(@QueryParam("password") String password, @QueryParam("emailId") String emailId)
    {
        User u = new User();
        try{
            u = getUserService().getUser(emailId, password);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        if(null == u){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return u;
    }



    private UserService getUserService(){
        return userService;
    }
}
