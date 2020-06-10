package controller.servlet.orderServlet;

import model.Customer;
import model.Order;
import model.WineInBill;
import service.WineStoreDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "OrderDetailServlet", urlPatterns = "/orderDetail")
public class OrderDetailServlet extends HttpServlet {
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
            int orderId = Integer.parseInt(request.getParameter("id"));
        try {
            Order order = wineStoreDAO.getOrderDetail(orderId);
            Customer customer = wineStoreDAO.getCustomerById(order.getCustomerId());
            List<WineInBill> wines = order.getWines();
            request.setAttribute("order", order);
            request.setAttribute("wines", wines);
            request.setAttribute("customer", customer);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/orderView/orderDetail.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
