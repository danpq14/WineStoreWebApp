package controller.servlet.cartServlet;

import model.Customer;
import model.Order;
import model.Wine;
import model.WineInBill;
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
import java.util.List;

@WebServlet(name = "FinishCartServlet", urlPatterns = "/finishCart")
public class FinishCartServlet extends HttpServlet {
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
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Object o = session.getAttribute("order");
        Order order = (Order) o;
        List<WineInBill> list = order.getWines();
        for (int i=0; i<list.size(); i++) {
            int quantity = Integer.parseInt(request.getParameter("quantity"+i));
            float price = 0;
            try {
                Wine wine = wineStoreDAO.selectWineByID(list.get(i).getWineId());
                price = wine.getPrice();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            list.get(i).setQuantity(quantity);
            list.get(i).setCost(quantity*price);
        }
        order.setWines(list);
        try {
            Customer customer = wineStoreDAO.getCustomerById(order.getCustomerId());
            float totalCost = 0;
            for (WineInBill item : order.getWines()) {
                totalCost += item.getCost();
            }
            wineStoreDAO.insertNewOrderFromCart(order);
            request.setAttribute("currentList", order.getWines());
            request.setAttribute("customer", customer);
            request.setAttribute("discount", customer.getDiscount()*100);
            request.setAttribute("total", totalCost*(1-customer.getDiscount()));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/ux/showOrder.jsp");
            requestDispatcher.forward(request, response);
            session.setAttribute("order", null);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
