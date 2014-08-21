package com.filter;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CORSResponseFilter implements Filter {

    String[] allowedOrigins = null;

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        allowedOrigins = filterConfig.getServletContext().getInitParameter("allowed-origins").split(",");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            // Cast to HTTP
            doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
        } else {
            throw new ServletException("Cannot filter non-HTTP requests/responses");
        }
    }


    private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        System.out.println(">>>>>>CORS Filter After");
        String originHeader = request.getHeader("Origin");

        if(null != originHeader){ // TODO Check the logic. Seems somthing is wrong
            if(allowedOrigin(originHeader)){
                System.out.println(">>>>>> CORS Filter Origin is allowed.");
                response.addHeader("Access-Control-Allow-Origin", originHeader);
                response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
                response.addHeader("Access-Control-Allow-Headers", "X-Custom-Header");
            }
            else{
                System.out.println(">>>>>> CORS Filter Origin is not allowed.");
            }
        }else{
            System.out.println(">>>>>> CORS Filter : Origin Header is not found. Not c CORS request.");
        }

    }

    private boolean allowedOrigin(String originHeader){
        for(String origin : allowedOrigins){
            if(originHeader.equals(origin.trim())){
                return true;
            }
        }
        return false;
    }
    /**
     */
    @Override
    public void destroy() {
        // do nothing
    }
}