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

@WebServlet(name = "EditCustomerServlet", urlPatterns = "/editCustomer")
public class EditCustomerServlet extends HttpServlet {
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
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int customerId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        float discount = Float.parseFloat(request.getParameter("discount"));
        try {
            wineStoreDAO.updateCustomer(customerId, name, phone, discount);
            Customer customer = wineStoreDAO.getCustomerById(customerId);
            request.setAttribute("customer", customer);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/customerView/editCustomerSuccess.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Customer customer = wineStoreDAO.getCustomerById(id);

            request.setAttribute("customer", customer);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/customerView/editForm.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
