/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.server;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Orvur
 */
@Path("generic")
public class GenericResource {

    public Count count;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.school.server.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object getXml() {
        //TODO return proper representation object
        if (count == null) {
            if (main.getCount() == null) {
                main.setCount(new Count());
            }
            count = main.getCount();
        }   
        System.out.println(count.getCount());
        return count;

    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     */
    @POST
    @Path("/{num}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Object putXml(@PathParam("num") int num) {
        if (count == null) {
            if (main.getCount() == null) {
                main.setCount(new Count());
            }
            count = main.getCount();
        }
        count.setCount(count.getCount() + num);
        System.out.println(num);
        System.out.println(count.getCount());
        return count;
    }
}
