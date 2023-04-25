package fr.esgi.customer.api;

import fr.esgi.customer.beans.Customer;
import fr.esgi.customer.services.CustomersFileParser;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/customers")
public class CustomersResource {

    private final CustomersFileParser customersFileParser;
    public CustomersResource() { this.customersFileParser = new CustomersFileParser();
    }
    @GET
    public List<Customer> getAllCustomers () {
        List<Customer> customersList = customersFileParser.parse("customers.csv");
        return customersList;
    }
}
