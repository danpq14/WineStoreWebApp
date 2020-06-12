package controller.servlet.productServlet;

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

@WebServlet(name = "TopProductServlet", urlPatterns = "/topProduct")
public class TopProductServlet extends HttpServlet {
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
        try {
            List<Wine> wines = wineStoreDAO.getTopProduct();
            request.setAttribute("wines", wines);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/ux/topProduct.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
