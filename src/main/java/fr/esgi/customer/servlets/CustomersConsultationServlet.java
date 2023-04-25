package fr.esgi.customer.servlets;

import fr.esgi.customer.beans.Customer;
import fr.esgi.customer.exception.CustomersParsingException;
import fr.esgi.customer.services.CustomersFileParser;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@WebServlet("/list")
public class CustomersConsultationServlet extends HttpServlet {
    private final CustomersFileParser customersFileParser;
    public CustomersConsultationServlet() { this.customersFileParser = new CustomersFileParser();
    }
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws CustomersParsingException {
        try {
            List<Customer> customersList = customersFileParser.parse("customers.csv");
            System.out.println(customersList);
            request.setAttribute("customers", customersList);.

            request.getRequestDispatcher("/listCustomers.jsp").forward(request, response);
        } catch (Exception e) {
            throw new CustomersParsingException("Une erreur est survenue", e);
        }
    }
}
