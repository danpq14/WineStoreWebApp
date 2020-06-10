package controller.servlet.orderServlet;

import model.Customer;
import model.Order;
import service.WineStoreDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderListServlet", urlPatterns = "/orderList")
public class OrderListServlet extends HttpServlet {
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

        try {
            Customer customer = wineStoreDAO.getCustomerById(customerId);
            List<Order> orders = wineStoreDAO.getAllOrderFromCustomer(customerId);
            request.setAttribute("orders", orders);
            request.setAttribute("customer", customer);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/orderView/orderList.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
