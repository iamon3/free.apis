package com.resource;

import static com.util.PathConstants.USERS_SERVICE_PATH;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.WebApplicationException;

import com.persistence.beans.User;
import com.persistence.beans.Transaction;
import com.persistence.service.UserService;
import com.persistence.service.UserTransactionService;

import java.util.Collection;
import java.util.List;

/**
 */
@Path(USERS_SERVICE_PATH)
public class UserResource {

    private static final String AUTHENTICATE_RESOURCE_PATH = "/authenticate";
    private static final String USER_RESOURCE_PATH = "/{userId}";
    private static final String TRANSACTIONS_RESOURCE_PATH = "/transactions";

    private UserService userService = new UserService();
    private UserTransactionService userTransactionService = new UserTransactionService();

    @POST
    @Path("")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public User addUser(User user)
    {
        System.out.println(user);
        User  userAdded = new User();
        userAdded = getUserService().addUser(user);
        if(null == userAdded){
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return userAdded;
    }

    /**
     * curl -X GET http://127.0.0.1:9090/freeapis/users
     */
    @GET
    @Path("")
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    public Collection<User> getUsers()
    {
        Collection<User> u = getUserService().getUsers();
        if(null != u){
            return u;

        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    /**
     * curl -X GET http://127.0.0.1:9090/freeapis/users/authenticate?email=xyz@abc.com&password=xyzabc
     */
    @GET
    @Path(AUTHENTICATE_RESOURCE_PATH)
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    public User authenticateUser(@QueryParam("password") String password, @QueryParam("email") String emailId)
    {
        System.out.print("Password : " + password + ", email : " + emailId);
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

    @GET
    @Path(USER_RESOURCE_PATH + TRANSACTIONS_RESOURCE_PATH)
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    public List<Transaction> getTransactions(@PathParam("userId") String userId, @QueryParam("emailId") String emailId){
        List<Transaction> trs = null;
        try{
            trs = getUserTransactionService().getUserTransaction(emailId);
        }catch (Exception e){
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return trs;
    }

    // TODO : Add one more parameter Transaction
    @POST
    @Path(USER_RESOURCE_PATH + TRANSACTIONS_RESOURCE_PATH)
    @Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public Transaction saveTransaction(@PathParam("userId") String userId, @QueryParam("email") String emailId, Transaction transaction){
        Transaction trs = null;
        try {
            trs = getUserTransactionService().addUserTransaction(emailId, transaction);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return trs;
    }

    private UserService getUserService(){
        return userService;
    }

    private UserTransactionService getUserTransactionService(){return  userTransactionService;}
}
