package service;

import controller.connection.DatabaseConnection;
import model.*;
import service.method.CheckAccount;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class WineStoreDAO {
    private Connection connection;
    private static WineStoreDAO instance;

    public WineStoreDAO() throws SQLException, ClassNotFoundException {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static WineStoreDAO getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new WineStoreDAO();
        }
        return instance;
    }

    public Account checkAccount(String userName, String password) throws SQLException {
        List<Account> accountList = new ArrayList<>();
        String getAllAccount = "call getAllAccount()";
        CallableStatement statement = connection.prepareCall(getAllAccount);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String user = resultSet.getString("userName");
            String pass = resultSet.getString("password");
            int customerId = resultSet.getInt("customerId");
            int role = resultSet.getInt("role");

            Account account = new Account(user, pass, customerId, role);
            accountList.add(account);
        }
       return CheckAccount.execute(userName, password, accountList);
    }

    public List<Wine> getAllProduct() throws SQLException {
        List<Wine> wines = new ArrayList<>();
        String sqlQuery = "select * from wine";
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            float price = resultSet.getFloat(3);
            int stock = resultSet.getInt(4);

            Wine wine = new Wine(id, name, price, stock);
            wines.add(wine);
        }

        return wines;
    }

    public List<Wine> selectWine(String keyword) throws SQLException {
        List<Wine> wines = new ArrayList<>();
        String sql = "call selectWineByNameOrId(?)";
        CallableStatement statement = connection.prepareCall(sql);
        statement.setString(1, "%" + keyword + "%");

        ResultSet resultSet = statement.executeQuery();
        while   (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            float price = resultSet.getFloat(3);
            int stock = resultSet.getInt(4);
            Wine wine = new Wine(id, name, price, stock);
            wines.add(wine);
        }
        return wines;
    }

    public Wine selectWineByID(int id) throws SQLException {
        Wine wine = null;
        String sql = "select * from wine where wineId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int wineId = resultSet.getInt(1);
            String name = resultSet.getString(2);
            float price = resultSet.getFloat(3);
            int stock = resultSet.getInt(4);
            wine = new Wine(wineId, name,price, stock);
        }
        return wine;
    }

    public void updateProduct(int id, String name, float price) throws SQLException {
        String sql = "update wine set wineName = ?, price = ? where wineId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setFloat(2, price);
        preparedStatement.setInt(3, id);
        preparedStatement.execute();
    }

    public void importProduct(int id, int amount) throws SQLException {
        String sql = "call importWineToInventory(?,?)";
        CallableStatement statement = connection.prepareCall(sql);
        statement.setInt(1, id);
        statement.setInt(2, amount);
        statement.execute();
    }

    public void exportProduct(int wineId, int amount,int customerId) throws SQLException {
        String insertOrder = "call insertNewOrder(?)";
        PreparedStatement statement = connection.prepareStatement(insertOrder);
        statement.setInt(1, customerId);
        statement.execute();

        String getNewestOrder = "call getNewestOrder()";
        CallableStatement callableStatement = connection.prepareCall(getNewestOrder);
        ResultSet resultSet = callableStatement.executeQuery();
        int orderId = -1;
        while (resultSet.next()) {
            orderId = resultSet.getInt(1);
        }

        String insert_order_detail = "call insert_order_detail(?,?,?)";
        CallableStatement insertOrderDetail = connection.prepareCall(insert_order_detail);
        insertOrderDetail.setInt(1, orderId);
        insertOrderDetail.setInt(2, wineId);
        insertOrderDetail.setInt(3, amount);
        insertOrderDetail.execute();
    }

    public void deleteProduct(int wineId) throws SQLException {
        Wine wine = selectWineByID(wineId);
        String sql = "delete from wine where wineId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, wineId);
        statement.execute();
    }

    public void addProduct(String name, float price, int stock) throws SQLException {
        String sql = "insert into wine (wineName,price,stock) values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setFloat(2, price);
        statement.setInt(3, stock);
        statement.execute();
    }

    public List<Customer> getAllCustomer() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "select * from customers where customerId < 90000";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int customerId = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String phone = resultSet.getString(3);
            float discount = resultSet.getFloat(4);

            Customer customer = new Customer(customerId, name, phone, discount);
            customers.add(customer);
        }

        return customers;
    }

    public Customer getCustomerById(int id) throws SQLException {
        Customer customer = null;
        String sql = "select * from customers where customerId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString(2);
            String phone = resultSet.getString(3);
            float discount = resultSet.getFloat(4);
            customer = new Customer(id, name, phone, discount);
        }
        return customer;
    }

    public void updateCustomer(int customerId, String name, String phone, float discount) throws SQLException {
        String sql = "update customers set customerName = ?,phone = ?, discount = ? where customerId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, phone);
        statement.setFloat(3, discount);
        statement.setInt(4, customerId);
        statement.execute();
    }

    public int countOrderByCustomer(int id) throws SQLException {
        String sql = "call countOrderByCustomer(?)";
        int countOrder = 0;
        CallableStatement statement = connection.prepareCall(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            countOrder = resultSet.getInt(1);
        }
        return countOrder;
    }

    public float getMaxRevenueFromCustomer(int id) throws SQLException {
        String sql = "call maxOrderFromCustomer(?)";
        float max = 0;
        CallableStatement statement = connection.prepareCall(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            max = resultSet.getFloat(1);
        }
        return max;
    }

    public float getTotalRevenueFromCustomer(int id) throws SQLException {
        String sql = "call totalRevenueFromCustomer(?)";
        CallableStatement statement = connection.prepareCall(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        float totalRevenue = 0;
        while (resultSet.next()) {
            totalRevenue = resultSet.getFloat(1);
        }
        return totalRevenue;
    }

    public Order getOrderDetail(int orderId) throws SQLException {
        String sql = "call getOrderDetail(?)";
        CallableStatement statement = connection.prepareCall(sql);
        statement.setInt(1, orderId);
        int order_id = -1;
        Date orderDate = null;
        int customerId = -1;
        List<WineInBill> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            order_id = resultSet.getInt(1);
            orderDate = resultSet.getDate(2);
            customerId = resultSet.getInt(3);
            String customerName = resultSet.getString(4);
            int wineId = resultSet.getInt(5);
            String wineName = resultSet.getString(6);
            int quantity = resultSet.getInt(7);
            float cost = resultSet.getFloat(8);

            WineInBill wine = new WineInBill(wineId, wineName, quantity, cost);
            list.add(wine);
        }
        Order order = new Order(orderId, customerId, orderDate, list);
        return order;
    }

    public List<Order> getAllOrderFromCustomer(int customerId) throws SQLException {
        String getAllOrder = "call getAllOrderByCustomer(?)";
        CallableStatement statement = connection.prepareCall(getAllOrder);
        statement.setInt(1, customerId);
        List<Integer> orderIdList = new ArrayList<>();
        try  {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int orderId = resultSet.getInt("orderId");
                orderIdList.add(orderId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Order> orders = new ArrayList<>();
        for (Integer id : orderIdList) {
            Order order = getOrderDetail(id);
            orders.add(order);
        }
        return orders;
    }

    public List<Customer> selectCustomer(String keyword) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "call selectCustomerByNameOrId(?)";
        CallableStatement statement = connection.prepareCall(sql);
        statement.setString(1,"%" + keyword + "%");

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int customerId = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String phone = resultSet.getString(3);
            float discount = resultSet.getFloat(4);

            Customer customer = new Customer(customerId,name,phone,discount);
            customers.add(customer);
        }
        return customers;
    }

    public List<Order> getOrderList(String keyword) throws SQLException {
        List<Integer> orderIdList = new ArrayList<>();
        String selectAllOrderIdCorrect = "call selectOrderByKeyword(?)";
        CallableStatement statement = connection.prepareCall(selectAllOrderIdCorrect);
        statement.setString(1, "%" + keyword + "%");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int orderId = resultSet.getInt("orderId");
            orderIdList.add(orderId);
        }

        List<Order> orders = new ArrayList<>();
        for (Integer id : orderIdList) {
            Order order = getOrderDetail(id);
            orders.add(order);
        }
        return orders;
    }

    public float getRevenueOverTime(String beginDate, String endDate) throws SQLException {
        String sql = "call selectRevenueOverTime(?,?)";
        CallableStatement statement = connection.prepareCall(sql);
        statement.setString(1, beginDate);
        statement.setString(2, endDate);
        ResultSet resultSet = statement.executeQuery();
        float revenue = 0;

        while (resultSet.next()) {
            revenue = resultSet.getFloat(1);
        }
        return revenue;
    }

    public int getOrderOverTime(String beginDate, String endDate) throws SQLException {
        String sql = "call selectOrderOverTime(?,?)";
        CallableStatement statement = connection.prepareCall(sql);
        statement.setString(1, beginDate);
        statement.setString(2, endDate);
        ResultSet resultSet = statement.executeQuery();
        int amountOrder = 0;

        while (resultSet.next()) {
            amountOrder = resultSet.getInt(1);
        }
        return amountOrder;
    }

    public List<Order> getTopOrder() throws SQLException {
        String sql = "call getTopOrder()";
        CallableStatement statement = connection.prepareCall(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Integer> orderIdList = new ArrayList<>();

        while (resultSet.next()) {
            int orderId = resultSet.getInt(1);
            orderIdList.add(orderId);
        }

        List<Order> orders = new ArrayList<>();
        for (Integer orderId : orderIdList) {
            Order order = getOrderDetail(orderId);
            orders.add(order);
        }
        return orders;
    }

    public List<Customer> getTopCustomer() throws SQLException {
        String sql = "call topCustomer()";
        CallableStatement statement = connection.prepareCall(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Integer> customerIdList = new ArrayList<>();
        while (resultSet.next()) {
            int customerId = resultSet.getInt(1);
            customerIdList.add(customerId);
        }

        List<Customer> topCustomerList = new ArrayList<>();
        for (Integer id : customerIdList) {
            Customer customer = getCustomerById(id);
            topCustomerList.add(customer);
        }

        return topCustomerList;
    }

    public List<Float> getTopCustomerRevenue() throws SQLException {
        String sql = "call topCustomer()";
        CallableStatement statement = connection.prepareCall(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Float> topRevenueList = new ArrayList<>();
        while (resultSet.next()) {
            float revenue = resultSet.getFloat(3);
            topRevenueList.add(revenue);
        }

        return topRevenueList;
    }

    public void insertNewOrderFromCart(Order order) throws SQLException {
        String insertOrder = "call insertNewOrder(?)";
        PreparedStatement statement = connection.prepareStatement(insertOrder);
        statement.setInt(1, order.getCustomerId());
        statement.execute();

        String getNewestOrder = "call getNewestOrder()";
        CallableStatement callableStatement = connection.prepareCall(getNewestOrder);
        ResultSet resultSet = callableStatement.executeQuery();
        int orderId = -1;
        while (resultSet.next()) {
            orderId = resultSet.getInt(1);
        }

        List<WineInBill> list = order.getWines();
        for (WineInBill item : list) {
            String insert_order_detail = "call insert_order_detail(?,?,?)";
            CallableStatement insertOrderDetail = connection.prepareCall(insert_order_detail);
            insertOrderDetail.setInt(1, orderId);
            insertOrderDetail.setInt(2, item.getWineId());
            insertOrderDetail.setInt(3, item.getQuantity());
            insertOrderDetail.execute();
        }
    }

    public List<Wine> getTopProduct() throws SQLException {
        String sql = "call topWine";
        CallableStatement statement = connection.prepareCall(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Integer> wineIdList = new ArrayList<>();

        while (resultSet.next()) {
            int wineId = resultSet.getInt(1);
            wineIdList.add(wineId);
        }

        List<Wine> wines = new ArrayList<>();
        for (Integer id : wineIdList) {
            wines.add(selectWineByID(id));
        }
        return wines;
    }

    public List<WineInBill> topProductRevenue() throws SQLException {
        String sql = "call topWine";
        CallableStatement statement = connection.prepareCall(sql);
        ResultSet resultSet = statement.executeQuery();
        List<WineInBill> list = new ArrayList<>();

        while (resultSet.next()) {
            int wineId = resultSet.getInt(1);
            String wineName = resultSet.getString(2);
            int quantity = resultSet.getInt(4);
            float cost = resultSet.getFloat(3);
            WineInBill wineInBill = new WineInBill(wineId, wineName, quantity, cost);
            list.add(wineInBill);
        }

        return list;
    }

}
