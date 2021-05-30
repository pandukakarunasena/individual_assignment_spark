package com.panduka.ncms.dao;

import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.utils.db.HibernateUtil;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HospitalDAOImpl implements HospitalDAO{

    @Override public List<Hospital> getAllHospitals() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Hospital> allHospitals= session.createSQLQuery("select * from hospital").list();
        tx.commit();

        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();

        return allHospitals;
    }

    @Override public Hospital getHospitalById(String id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();

        id = "402888e679bf31b60179bf31be090001"; //test id
        Hospital selectedHospitalById = session.get( Hospital.class, id);
        tx.commit();
        HibernateUtil.getSessionFactory().close();
        System.out.println(selectedHospitalById);

        return selectedHospitalById;

    }

    @Override public Hospital createHospital( Hospital newHospital) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(newHospital);
        session.getTransaction().commit();

        System.out.println("Employee ID="+newHospital.getId());

        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();

        return null;//send the created hospital data
    }

    @Override public boolean deleteHospital(String id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();

        id = "402888e679bf31b60179bf31be090001"; //test id

        Query query = session.createQuery("delete Hospital where id = :id");
        query.setParameter("id", id);

        int result = query.executeUpdate();

        if (result > 0) {
            System.out.println("Expensive products was removed");
            return true;
        }

        tx.commit();
        HibernateUtil.getSessionFactory().close();

        return false;
    }

    @Override public boolean updateHospital(String id, Hospital newUpdatedHospital) {
        return false;
    }

}
