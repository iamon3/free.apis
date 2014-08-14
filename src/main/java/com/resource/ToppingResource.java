package com.resource;

import static com.util.PathConstants.TOPPINGS_SERVICE_PATH;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.WebApplicationException;

import com.persistence.beans.Topping;

import java.util.List;

/**
 */
@Path(TOPPINGS_SERVICE_PATH)
public class ToppingResource {

    private static final String TOPPING_RESOURCE_PATH = "/{toppingId}";

    /**
     * curl -X GET http://127.0.0.1:9090/freeapis/toppings
     */
    @GET
    @Path("")
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    public List<Topping> getToppings()
    {
        return null;
    }

    /**
     * curl -X GET http://127.0.0.1:9090/freeapis/toppings/{id}
     */
    @GET
    @Path(TOPPING_RESOURCE_PATH)
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    public Topping getTopping(@PathParam("toppingId") String toppingId)
    {
        return null;
    }

    /**
     * curl -X POST http://127.0.0.1:9090/freeapis/toppings
     */
    @POST
    @Path("")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public Topping addTopping(Topping topping){
        return null;
    }
}
