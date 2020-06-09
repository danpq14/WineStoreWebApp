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

@WebServlet(name = "AllProductServlet", urlPatterns = "/AllProduct")
public class AllProductServlet extends HttpServlet {
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
        List<Wine> wineList = null;
        try {
           wineList = wineStoreDAO.getAllProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("wines", wineList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/productView/AllProduct.jsp");
        requestDispatcher.forward(request, response);
    }
}
