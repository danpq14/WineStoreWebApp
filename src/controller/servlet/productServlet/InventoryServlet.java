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
        int id = Integer.parseInt(request.getParameter("id"));
        int amount  = Integer.parseInt(request.getParameter("amount"));
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("import")) {
            try {
                importProduct(id, amount, request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (action.equalsIgnoreCase("export")) {
            int customerId = Integer.parseInt(request.getParameter("customerId"));
            exportProduct(id, amount, customerId, request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int amount  = Integer.parseInt(request.getParameter("amount"));
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("import")) {
            try {
                showImportForm(id, request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (action.equalsIgnoreCase("export")) {
            try {
                showExportForm(id, amount,request, response );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void showImportForm(int id, HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Wine wine = wineStoreDAO.selectWineByID(id);
        request.setAttribute("wine", wine);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/productView/importForm.jsp");
        requestDispatcher.forward(request, response);
    }

    public void importProduct(int id, int amount, HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        wineStoreDAO.importProduct(id, amount);
        Wine wine = wineStoreDAO.selectWineByID(id);
        request.setAttribute("wine", wine);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/productView/editResult.jsp");
        requestDispatcher.forward(request, response);
    }

    public void showExportForm(int id, int amount, HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/productView/exportForm.jsp");
        requestDispatcher.forward(request, response);
    }

    private void exportProduct(int id, int amount, int customerId, HttpServletRequest request, HttpServletResponse response) {
        wineStoreDAO.exportProduct(id, amount, customerId);
    }
}
