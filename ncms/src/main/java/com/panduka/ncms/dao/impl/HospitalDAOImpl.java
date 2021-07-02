package com.panduka.ncms.dao.impl;

import static com.panduka.ncms.utils.Constants.GET_ALL_HOSPITALS_QUERY;
import static com.panduka.ncms.utils.Constants.GET_ALL_PATIENTS_BY_HOSPITAL_ID_QUERY;

import com.panduka.ncms.dao.HospitalDAO;
import com.panduka.ncms.entity.Bed;
import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.entity.Patient;
import com.panduka.ncms.utils.db.HibernateUtil;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HospitalDAOImpl implements HospitalDAO {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final Logger logger = LogManager.getLogger( HospitalDAOImpl.class);

    @Override public List getAllHospitals() {
        logger.info( "getAllHospitals() method called: HospitalDAOImpl class");
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        Query q = session.createQuery( GET_ALL_HOSPITALS_QUERY);
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
        String id = (String)session.save(newHospital);
        //take id of the hospital and create 10 beds.
        for( int i = 1; i < 11; i++){
            Bed bed = new Bed(
                    i,
                    getHospitalById(id),
                    null,
                    false
            );
            session.save( bed);
        }
        session.getTransaction().commit();
        session.close();


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

    @Override public List<Patient> getPatientsByHospital(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Query q = session.createQuery( GET_ALL_PATIENTS_BY_HOSPITAL_ID_QUERY);
        q.setParameter( "id", id);

        List< Patient> patientList = q.list();

        return patientList;
    }



}
