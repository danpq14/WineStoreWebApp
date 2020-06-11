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

@WebServlet(name = "UpdateCartServlet", urlPatterns = "/updateCart")
public class UpdateCartServlet extends HttpServlet {
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
            if (quantity != 0) {
                list.get(i).setQuantity(quantity);
                list.get(i).setCost(quantity*price);
            }
            else {
                list.remove(i);
            }
        }
        order.setWines(list);
        session.setAttribute("order", order);
        float totalCost = 0;
        Customer customer = null;
        try {
            customer = wineStoreDAO.getCustomerById(order.getCustomerId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (WineInBill item : order.getWines()) {
            totalCost += item.getCost();
        }
        request.setAttribute("currentList", order.getWines());
        request.setAttribute("customer", customer);
        request.setAttribute("discount", customer.getDiscount()*100);
        request.setAttribute("total", totalCost*(1-customer.getDiscount()));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/ux/cart.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
