package com.panduka.ncms.dao.impl;

import com.panduka.ncms.dao.HospitalDAO;
import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.utils.db.HibernateUtil;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HospitalDAOImpl implements HospitalDAO {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override public List getAllHospitals() {
        System.out.println( "get all hospitals DAO");
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Hospital");
        List allHospitals= q.list();
        tx.commit();
        session.close();

        return allHospitals;
    }

    @Override public Hospital getHospitalById(String id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Hospital selectedHospitalById = session.get( Hospital.class, id);
        tx.commit();
        session.close();

        System.out.println(selectedHospitalById);

        return selectedHospitalById;

    }

    @Override public Hospital createHospital( Hospital newHospital) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(newHospital);
        session.getTransaction().commit();
        session.close();
        System.out.println("Employee ID="+newHospital.getId());

        //terminate session factory, otherwise program won't end
        //HibernateUtil.getSessionFactory().close();

        return null;//send the created hospital data
    }

    @Override public boolean deleteHospital(String id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        Hospital hospitalToBeDeleted = session.get( Hospital.class, id);

        if( hospitalToBeDeleted != null){
            session.delete( hospitalToBeDeleted);
            return true;
        }

        tx.commit();
        session.close();

        return false;
    }

    @Override public boolean updateHospital(String id, Hospital newUpdatedHospital) {
        return false;
    }

}
