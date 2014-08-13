package com.resource;

import static com.util.PathConstants.USERS_SERVICE_PATH;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.WebApplicationException;
import com.persistence.beans.User;
/**
 */
@Path(USERS_SERVICE_PATH)
public class UserResource {

    private static final String USER_RESOURCE_PATH = "/{userId}";

    @POST
    @Path("")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public User addUser(User user)
    {
        User  userAdded = new User();
        //userAdded = getUserService().addDocument(user);
        if(null == userAdded){
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return userAdded;
    }

    /**
     * curl -X GET http://127.0.0.1:5000/freeapis/users
     */
    @GET
    @Path(USER_RESOURCE_PATH)
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    public User getUser(@PathParam("userId") String userId)
    {
        return null;
    }
}
