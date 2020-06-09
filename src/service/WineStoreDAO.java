package service;

import controller.connection.DatabaseConnection;
import model.Account;
import model.Wine;
import service.method.CheckAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public void exportProduct(int id, int amount,int customerId) throws SQLException {
        String insertOrder = "call insertNewOrder(?)";
        PreparedStatement statement = connection.prepareStatement(insertOrder);
        statement.setInt(1, customerId);

        String getNewestOrder = "call getNewestOrder(?)";
        CallableStatement callableStatement = connection.prepareCall(getNewestOrder);
        callableStatement.setString(1, "@order_id");

//        CallableStatement statement = connection.prepareCall(sql);
        statement.setInt(1, id);
        statement.setInt(2, amount);
        statement.execute();
    }
}
