package fr.esgi.customer.servlets;

import fr.esgi.customer.beans.Customer;
import fr.esgi.customer.exception.MissingCustomerId;
import fr.esgi.customer.exception.NotFoundCustomerException;
import fr.esgi.customer.services.CustomersFileParser;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@WebServlet("/details")
public class CustomerDetailConsultationServlet extends HttpServlet {
    private final CustomersFileParser customersFileParser;
    public CustomerDetailConsultationServlet() { this.customersFileParser = new CustomersFileParser();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws MissingCustomerId, NotFoundCustomerException {
        if (!request.getParameterMap().containsKey("id")) throw new MissingCustomerId("Missing customer id");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            List<Customer> customers = customersFileParser.parse("customers.csv");
            for (Customer customer : customers) {
                if (customer.referenceId() == id) {
                    request.setAttribute("customer", customer);
                    request.getRequestDispatcher("/detailsCustomer.jsp").forward(request, response);
                    return;
                }
            }
        } catch (Exception e) {
            throw new NotFoundCustomerException("Resource not found !", e);
        }
    }
}
