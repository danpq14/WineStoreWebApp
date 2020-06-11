package controller.servlet.orderServlet;

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
import java.util.List;

@WebServlet(name = "SearchOrderServlet", urlPatterns = "/searchOrder")
public class SearchOrderServlet extends HttpServlet {
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
            String keyword = request.getParameter("keyword");
        try {
            List<Order> orderList = wineStoreDAO.getOrderList(keyword);
            request.setAttribute("orders", orderList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/orderView/searchOrderResult.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/orderView/searchOrderForm.jsp");
        requestDispatcher.forward(request, response);
    }
}
