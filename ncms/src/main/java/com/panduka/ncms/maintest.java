package com.panduka.ncms;

import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.entity.User;
import com.panduka.ncms.utils.db.HibernateUtil;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class maintest {

    public static void main(String[] args) {
        System.out.println("hospital dao called");

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction tx = session.beginTransaction();
        System.out.println("executing the query.....");
        List<Hospital> allHospitals= session.createSQLQuery("select * from hospital").list();
        tx.commit();

        System.out.println( allHospitals);

        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();

    }

}
