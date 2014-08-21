import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.handler.*;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import com.filter.CORSResponseFilter;

/**
 Following blog was used for jetty + jersey integration.
 http://www.tzehon.com/2012/11/06/microservices-with-jetty-and-jersey/
 */
public class FreeApiServer{

    private static String ALLOWED_ORIGINS = "http://free-pizza-app.free-org.cloudbees.net, http://localhost:8080";

    private static String ALLOWED_ORIGINS_CONTEXT_PARAM = "allowed-origins";

    public static void main(String[] args) throws Exception{

        try{

            Server server = new Server(Integer.valueOf(System.getenv("PORT")));

            ServletHolder jerseyServletHolder = new ServletHolder(ServletContainer.class);
            jerseyServletHolder.setInitParameter("com.sun.jersey.config.property.packages", "com.resource");
            jerseyServletHolder.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature","true");
            jerseyServletHolder.setInitParameter("com.sun.jersey.config.feature.Debug", "true");
            jerseyServletHolder.setInitParameter("com.sun.jersey.config.feature.Trace", "true");
            jerseyServletHolder.setInitParameter("com.sun.jersey.spi.container.ContainerRequestFilters", "com.sun.jersey.api.container.filter.LoggingFilter");
            jerseyServletHolder.setInitParameter("com.sun.jersey.spi.container.ContainerResponseFilters", "com.sun.jersey.api.container.filter.LoggingFilter");


            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");
            context.addServlet(jerseyServletHolder, "/freeapis/*");
            context.addFilter(CORSResponseFilter.class, "/*", 1);
            context.setInitParameter(ALLOWED_ORIGINS_CONTEXT_PARAM,ALLOWED_ORIGINS); // Equivalent to <context-param> in web.xml

            server.setHandler(context);

            QueuedThreadPool queuedThreadPool = new QueuedThreadPool(10);
            queuedThreadPool.setName("ApiServe");
            server.setThreadPool(queuedThreadPool);

            server.start();
            server.join();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
