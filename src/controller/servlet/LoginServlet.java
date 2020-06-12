package controller.servlet;

import model.Account;
import service.WineStoreDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private WineStoreDAO wineStoreDAO;

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
            String username = request.getParameter("username");
            String password = request.getParameter("password");
        try {
            Account account = wineStoreDAO.checkAccount(username, password);
            int role_admin = 1;
            if (account != null) {
                HttpSession session = request.getSession();
                Object o = session.getAttribute("IS_LOGGED");
                if (o == null) {
                    session.setAttribute("account", account);
                    session.removeAttribute("order");
                    session.setAttribute("IS_LOGGED", true);
                    if (account.getRole() == role_admin) {
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/managerPage/managerPage.jsp");
                        requestDispatcher.forward(request, response);
                    }
                    else {
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/ux/customerHomePage.jsp");
                        requestDispatcher.forward(request, response);
                    }
                }
                else {
                    PrintWriter writer = response.getWriter();
                    writer.println("Bạn chưa đăng xuất");
                }

            }
            else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/fail-login.jsp");
                requestDispatcher.forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
