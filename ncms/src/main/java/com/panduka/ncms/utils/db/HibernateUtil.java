package com.panduka.ncms.utils.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory(){
        try{
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            System.out.println("hibernate config loaded");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("hibernate service registry created");

            SessionFactory sessionFactory = configuration.buildSessionFactory( serviceRegistry);

            return sessionFactory;
        }catch (Throwable ex){
            System.err.println(" Initial session factory creation failed" + ex);
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }

    public static void close(){
        sessionFactory.close();
    }


}
