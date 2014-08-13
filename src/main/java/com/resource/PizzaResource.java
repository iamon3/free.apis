package com.resource;

import static com.util.PathConstants.PIZZAS_SERVICE_PATH;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.WebApplicationException;
import com.persistence.beans.Pizza;
/**
 */
@Path(PIZZAS_SERVICE_PATH)
public class PizzaResource {

    private static final String PIZZA_RESOURCE_PATH = "/{pizzaId}";

    /**
     * curl -X GET http://127.0.0.1:9090/freeapis/pizzas
     */
    @GET
    @Path(PIZZA_RESOURCE_PATH)
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    public Pizza getPizza(@PathParam("pizzaId") String pizzaId)
    {
        return null;
    }

}
