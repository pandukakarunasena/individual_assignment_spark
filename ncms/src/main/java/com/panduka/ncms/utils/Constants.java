package com.panduka.ncms.utils;

public class Constants {

    //Database connection pool configuration implementation scratch and using a framework
    public final static int INITIAL_NO_OF_CONNECTIONS = 10;
    public final static String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    public final static String DATABASE_USERNAME = "root";
    public final static String DATABASE_PASSWORD = "mysql";
    public final static String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";


    //Database CRUD queries
    public final static String GET_ALL_HOSPITALS_QUERY= "from Hospital";
    public final static String GET_ALL_PATIENTS_BY_SEVERITY_QUERY="From Patient where severityLevel=:severity" ;
    public final static String GET_ALL_PATIENTS_QUERY= "from Patient ";

    //Jersey config package name
    public final static String PACKAGE_NAME_FOR_RESOURCES = "com.panduka.ncms.resources";


}
