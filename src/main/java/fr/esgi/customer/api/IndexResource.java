package fr.esgi.customer.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class IndexResource {
    @GET
    public String hello () {
        return "Hello world";
    }
}
