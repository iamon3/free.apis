package com.resource;

import static com.util.PathConstants.TOPPINGS_SERVICE_PATH;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.WebApplicationException;

import com.persistence.beans.Topping;
import com.persistence.service.ToppingService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 */
@Path(TOPPINGS_SERVICE_PATH)
public class ToppingResource {

    private static final String TOPPING_RESOURCE_PATH = "/{toppingId}";

    private ToppingService toppingService = new ToppingService();

    /**
     * curl -X GET http://127.0.0.1:9090/freeapis/toppings
     */
    @GET
    @Path("")
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    public Collection<Topping> getToppings()
    {
        Collection<Topping> toppings = getToppingService().getToppings();
        if(null != toppings){
            return toppings;
        }
        throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }

    /**
     * curl -X GET http://127.0.0.1:9090/freeapis/toppings/{id}
     */
    @GET
    @Path(TOPPING_RESOURCE_PATH)
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    public Topping getTopping(@PathParam("toppingId") String toppingId)
    {
        Topping topping = new Topping();
        try{
            topping = getToppingService().getTopping(Integer.getInteger(toppingId));
        }
        catch(Exception e){
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        if(topping == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return topping;
    }

    /**
     * curl -X POST http://127.0.0.1:9090/freeapis/toppings
     */
    @POST
    @Path("")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public Topping addTopping(Topping topping){
        Topping t= new Topping();

        t = getToppingService().addTopping(t);

        if(null == t){
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return t;
    }

    private ToppingService getToppingService(){
        return toppingService;
    }
}
