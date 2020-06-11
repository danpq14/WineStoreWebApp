package controller.servlet.revenueServlet;

import service.WineStoreDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RevenueOverTimeServlet", urlPatterns = "/revenueOverTime")
public class RevenueOverTimeServlet extends HttpServlet {
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String beginDate = request.getParameter("beginDate");
        String endDate = request.getParameter("endDate");
        try {
            float revenue = wineStoreDAO.getRevenueOverTime(beginDate, endDate);
            int amountOrder = wineStoreDAO.getOrderOverTime(beginDate, endDate);
            request.setAttribute("beginDate", beginDate);
            request.setAttribute("endDate", endDate);
            request.setAttribute("revenue", revenue);
            request.setAttribute("amountOrder", amountOrder);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/revenue/revenueOverTime.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/revenue/revenueOverTimeForm.jsp");
        requestDispatcher.forward(request, response);
    }
}
