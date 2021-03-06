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

@WebServlet(name = "InventoryServlet", urlPatterns = "/inventory")
public class InventoryServlet extends HttpServlet {
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
        int wineId = Integer.parseInt(request.getParameter("id"));
        int amount  = Integer.parseInt(request.getParameter("amount"));
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("import")) {
            try {
                importProduct(wineId, amount, request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (action.equalsIgnoreCase("export")) {
            int customerId = Integer.parseInt(request.getParameter("customerId"));
            try {
                exportProduct(wineId, amount, customerId, request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int wineId = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("import")) {
            try {
                showImportForm(wineId, request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (action.equalsIgnoreCase("export")) {
            try {
                showExportForm(wineId,request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void showImportForm(int wineId, HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Wine wine = wineStoreDAO.selectWineByID(wineId);
        request.setAttribute("wine", wine);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/productView/importForm.jsp");
        requestDispatcher.forward(request, response);
    }

    public void importProduct(int wineId, int amount, HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        wineStoreDAO.importProduct(wineId, amount);
        Wine wine = wineStoreDAO.selectWineByID(wineId);
        request.setAttribute("wine", wine);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/productView/editResult.jsp");
        requestDispatcher.forward(request, response);
    }

    public void showExportForm(int wineId, HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Wine wine = wineStoreDAO.selectWineByID(wineId);
        request.setAttribute("wine", wine);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/productView/exportForm.jsp");
        requestDispatcher.forward(request, response);
    }

    private void exportProduct(int wineId, int amount, int customerId, HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        wineStoreDAO.exportProduct(wineId, amount, customerId);
        Wine wine = wineStoreDAO.selectWineByID(wineId);
        request.setAttribute("wine", wine);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/productView/editResult.jsp");
        requestDispatcher.forward(request, response);
    }
}
