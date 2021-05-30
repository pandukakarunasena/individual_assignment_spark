package com.panduka.ncms;

import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.utils.db.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class maintest {

    public static void main(String[] args) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction t = s.beginTransaction();
        System.out.println( "tx created" );

        List<Hospital> h = s.createSQLQuery("select * from hospital").list();

        for( Object a: h){
            System.out.println(a.toString().);
        }
        t.commit();

        System.out.println(h);

    }

}
