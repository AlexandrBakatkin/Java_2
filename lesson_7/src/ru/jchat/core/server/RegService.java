package ru.jchat.core.server;

import java.sql.*;

public class RegService {
    private Connection connection;
    private Statement statement;

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        statement = connection.createStatement();
    }

    public boolean registration(String login, String password) throws SQLException {
            ResultSet rs = statement.executeQuery("INSERT INTO ");
            if (rs == null) {
                return true;
            } else return false;
    }

    public void disconnect(){
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
