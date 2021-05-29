//package com.panduka.ncms.utils.db;
//
//import static com.panduka.ncms.utils.Constants.DATABASE_DRIVER;
//import static com.panduka.ncms.utils.Constants.DATABASE_PASSWORD;
//import static com.panduka.ncms.utils.Constants.DATABASE_URL;
//import static com.panduka.ncms.utils.Constants.DATABASE_USERNAME;
//import static com.panduka.ncms.utils.Constants.INITIAL_NO_OF_CONNECTIONS;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//
//public class TomcatJDBCConnectionPool implements ConnectionPool{
//
//    public static BasicDataSource dataSource = new BasicDataSource();
//    private static TomcatJDBCConnectionPool instance;
//
//    private TomcatJDBCConnectionPool(){
//        dataSource.setDriverClassName(DATABASE_DRIVER);
//        dataSource.setUrl(DATABASE_URL);
//        dataSource.setUsername(DATABASE_USERNAME);
//        dataSource.setPassword(DATABASE_PASSWORD);
//        dataSource.setInitialSize(INITIAL_NO_OF_CONNECTIONS);
//    }
//
//    public static TomcatJDBCConnectionPool getInstance(){
//        if(instance == null){
//            instance = new TomcatJDBCConnectionPool();
//        }
//        return instance;
//    }
//
//    @Override
//    public Connection getConnection() throws SQLException {
//        return dataSource.getConnection();
//    }
//}
