package controller.servlet.customerServlet;

import model.Customer;
import service.WineStoreDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CustomerDetailServlet", urlPatterns = "/customerDetail")
public class CustomerDetailServlet extends HttpServlet {
    public WineStoreDAO wineStoreDAO;

    {
        try {
            wineStoreDAO = WineStoreDAO.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int customerId = Integer.parseInt(request.getParameter("id"));
            Customer customer = null;
        try {
            customer = wineStoreDAO.getCustomerById(customerId);
            int numberOfOrder = wineStoreDAO.countOrderByCustomer(customerId);
            float maxRevenue = wineStoreDAO.getMaxRevenueFromCustomer(customerId);
            float totalRevenue = wineStoreDAO.getTotalRevenueFromCustomer(customerId);
            request.setAttribute("customer", customer);
            request.setAttribute("numberOfOrder", numberOfOrder);
            request.setAttribute("maxRevenue", maxRevenue);
            request.setAttribute("totalRevenue", totalRevenue);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/customerView/customer-detail.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
