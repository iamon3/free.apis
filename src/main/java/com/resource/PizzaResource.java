package com.resource;

import static com.util.PathConstants.PIZZAS_SERVICE_PATH;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.WebApplicationException;
import com.persistence.beans.Pizza;

import java.util.List;

/**
 */
@Path(PIZZAS_SERVICE_PATH)
public class PizzaResource {

    private static final String PIZZA_RESOURCE_PATH = "/{pizzaId}";

    /**
     * curl -X GET http://127.0.0.1:9090/freeapis/pizzas
     */
    @GET
    @Path("")
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    public List<Pizza> getPizzas()
    {
        return null;
    }

    /**
     * curl -X GET http://127.0.0.1:9090/freeapis/pizzas/{id}
     */
    @GET
    @Path(PIZZA_RESOURCE_PATH)
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    public Pizza getPizza(@PathParam("pizzaId") String pizzaId)
    {
        return null;
    }

    /**
     * curl -X POST http://127.0.0.1:9090/freeapis/pizzas
     */
    @POST
    @Path("")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public Pizza addPizza(Pizza pizza){
        return null;
    }
}
