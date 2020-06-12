package controller.servlet.cartServlet;

import model.*;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddToCartServlet", urlPatterns = "/addToCart")
public class AddToCartServlet extends HttpServlet {
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
         HttpSession session = request.getSession();
         Object object = session.getAttribute("IS_LOGGED");
         if (object != null) {
             int wineId = Integer.parseInt(request.getParameter("id"));
             try {
                 Object o = session.getAttribute("account");
                 Account account = (Account) o;
                 int customerId = account.getCustomerId();
                 Customer customer = wineStoreDAO.getCustomerById(customerId);
                 Object o2 = session.getAttribute("order");
                 Order order = (Order) o2  ;
                 if (order ==  null) {
                     Wine wine = wineStoreDAO.selectWineByID(wineId);
                     WineInBill wineInBill = new WineInBill(wine.getId(), wine.getName(), 1, wine.getPrice()*1);
                     List<WineInBill> wines = new ArrayList<>();
                     wines.add(wineInBill);
                     Order newOrder = new Order();
                     newOrder.setCustomerId(customerId);
                     newOrder.setWines(wines);
                     newOrder.setCustomerId(customerId);
                     order = newOrder;
                     session.setAttribute("order", order);
                 }
                 else {
                     Wine wine = wineStoreDAO.selectWineByID(wineId);
                     WineInBill newWine = new WineInBill(wine.getId(), wine.getName(), 1, wine.getPrice()*1);
                     int index = -1; //nếu index = -1 thì tức là chưa có trong giỏ hàng
                     List<WineInBill> list = order.getWines();
                     for (int i=0; i< list.size(); i++) {
                         if (newWine.getWineId() == list.get(i).getWineId()){
                             index = i;
                             break;
                         }
                     }
                     if (index != -1) {
                         int newQuantity = list.get(index).getQuantity() + 1;
                         float price = list.get(index).getCost();
                         list.get(index).setQuantity(newQuantity);
                         list.get(index).setCost(newQuantity*price);
                     }
                     else {
                         list.add(newWine);
                     }

                     order.setWines(list);
                     session.setAttribute("order", order);
                 }
                 float totalCost = 0;
                 for (WineInBill item : order.getWines()) {
                     totalCost += item.getCost();
                 }
                 request.setAttribute("currentList", order.getWines());
                 request.setAttribute("customer", customer);
                 request.setAttribute("discount", customer.getDiscount()*100);
                 request.setAttribute("total", totalCost*(1-customer.getDiscount()));
                 RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/ux/cart.jsp");
                 requestDispatcher.forward(request, response);
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
         else {
             RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
             requestDispatcher.forward(request, response);
         }
    }
}
