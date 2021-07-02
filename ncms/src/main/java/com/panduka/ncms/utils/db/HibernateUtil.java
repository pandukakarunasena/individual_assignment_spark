package com.panduka.ncms.utils.db;

import com.panduka.ncms.entity.Bed;
import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.entity.Patient;
import com.panduka.ncms.entity.PatientQueue;
import com.panduka.ncms.entity.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private final static Logger logger = LogManager.getLogger( HibernateUtil.class);

    private static SessionFactory buildSessionFactory(){
        try{
            Configuration configuration = new Configuration();
            configuration.configure( "hibernate.cfg.xml");
            logger.info("configure loaded");

            configuration.addAnnotatedClass(Bed.class);
            configuration.addAnnotatedClass(Hospital.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Patient.class);
            configuration.addAnnotatedClass(PatientQueue.class);


            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings( configuration.getProperties()).build();
            logger.info( "hibernate service registry created");

            SessionFactory sessionFactory = configuration.buildSessionFactory( serviceRegistry);
            logger.info( "session factory created successfully");

            return sessionFactory;

        }catch (Throwable ex){
            logger.error( " Initial session factory creation failed " + ex + " " + "cause: " + ex.getCause());
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
