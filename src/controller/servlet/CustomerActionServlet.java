package controller.servlet;

import model.Wine;
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

@WebServlet(name = "CustomerActionServlet", urlPatterns = "/customerAction")
public class CustomerActionServlet extends HttpServlet {
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
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "showAllProduct" :
                try {
                    showAllProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void showAllProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Wine> wines = wineStoreDAO.getAllProduct();
        request.setAttribute("wines", wines);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/ux/showList.jsp");
        requestDispatcher.forward(request, response);
    }
}
