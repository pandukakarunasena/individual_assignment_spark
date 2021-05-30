package com.panduka.ncms.dao;

import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.utils.db.HibernateUtil;

import java.util.List;
import org.hibernate.Session;

public class HospitalDAOImpl implements HospitalDAO{

    @Override public List<Hospital> getAllHospitals() {
        System.out.println("hospital dao called");

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        System.out.println(" executing the query.....");
        List<Hospital> allHospitals= session.createSQLQuery("select * from hospital").list();

        System.out.println( allHospitals);

        for( Hospital h: allHospitals){
            System.out.println(h);
        }


        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
        return allHospitals;
    }

    @Override public Hospital getHospitalById(String id) {
        return null;
    }

    @Override public Hospital createHospital( Hospital newHospital) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(newHospital);
        session.getTransaction().commit();

        System.out.println("Employee ID="+newHospital.getId());

        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
        return null;
    }

    @Override public boolean deleteHospital(String id) {
        return false;
    }

    @Override public boolean updateHospital(String id, Hospital newUpdatedHospital) {
        return false;
    }

}
