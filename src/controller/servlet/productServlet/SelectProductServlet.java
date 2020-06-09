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


@WebServlet(name = "SelectProductServlet", urlPatterns = "/selectProduct")
public class SelectProductServlet extends HttpServlet {
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            String keyword = request.getParameter("keyword");
        try {
            List<Wine> wines = wineStoreDAO.selectWine(keyword); // lấy ra kết quả từ database
            request.setAttribute("wines", wines); //truyền kết quả lại cho trang jsp
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/productView/searchResult.jsp"); //chuyển hướng đến trang jsp
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/productView/searchProductForm.jsp");
        requestDispatcher.forward(request, response);
    }
}
