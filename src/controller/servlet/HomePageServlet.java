package controller.servlet;

import model.Account;
import model.Customer;
import service.WineStoreDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "HomePageServlet", urlPatterns = "/homePage")
public class HomePageServlet extends HttpServlet {
    WineStoreDAO wineStoreDAO;

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
        HttpSession session = request.getSession();
        Object o = session.getAttribute("IS_LOGGED");

        boolean isLog = (Boolean) o;

        if (isLog == true) {
            Object o2 = session.getAttribute("account");
            Account account = (Account) o2;
            try {
                Customer customer = wineStoreDAO.getCustomerById(account.getCustomerId());
                request.setAttribute("customer", customer);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/LoggedHomePage.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
