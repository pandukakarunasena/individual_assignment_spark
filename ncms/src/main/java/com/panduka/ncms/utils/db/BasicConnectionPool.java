package com.panduka.ncms.utils.db;


import static com.panduka.ncms.utils.Constants.DATABASE_PASSWORD;
import static com.panduka.ncms.utils.Constants.DATABASE_URL;
import static com.panduka.ncms.utils.Constants.DATABASE_USERNAME;
import static com.panduka.ncms.utils.Constants.INITIAL_NO_OF_CONNECTIONS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasicConnectionPool implements ConnectionPool{

    private static List<Connection> connectionPool;
    private static List<Connection> usedConnections = new ArrayList<>();

    private BasicConnectionPool(List<Connection> connectionPool) {
    }

    public static BasicConnectionPool create() throws SQLException {
        connectionPool = new ArrayList<>();
        for(int i = 0; i <  INITIAL_NO_OF_CONNECTIONS; i++){
            connectionPool.add(DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD));
        }

        return  new BasicConnectionPool(connectionPool);
    }

    @Override public Connection getConnection() {
        Connection connection = connectionPool.get(connectionPool.size()-1);
        usedConnections.add(connection);
        return connection;
    }

    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

}
