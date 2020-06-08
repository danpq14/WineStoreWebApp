package service;

import controller.connection.DatabaseConnection;
import model.Account;
import service.method.CheckAccount;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            String pass = resultSet.getString("userName");
            int customerId = resultSet.getInt("customerId");
            int role = resultSet.getInt("role");

            Account account = new Account(user, pass, customerId, role);
            accountList.add(account);
        }
       return CheckAccount.execute(userName, password, accountList);
    }
}
