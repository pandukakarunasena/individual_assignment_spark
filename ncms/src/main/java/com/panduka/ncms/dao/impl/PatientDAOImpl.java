package com.panduka.ncms.dao.impl;

import com.panduka.ncms.dao.PatientDAO;
import com.panduka.ncms.entity.Patient;
import com.panduka.ncms.utils.db.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PatientDAOImpl implements PatientDAO {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override public Patient getPatientById(String id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Patient patient = session.get( Patient.class, id);

        if( patient != null){
            return  patient;
        }

        tx.commit();
        session.close();

        return null;
    }

    @Override public void addPatient(Patient patient) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save( patient);

        tx.commit();
        session.close();
    }

    @Override public boolean deletePatient(String id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Patient patient = session.get( Patient.class, id);

        if( patient != null){
            session.delete( patient);
            return true;
        }

        tx.commit();
        session.close();

        return false;
    }

    @Override public boolean updatePatient(String id, Patient newPatientDetails) {
        return false;
    }

    @Override public List<Patient> getPatientBySeverity(String severity) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery( "From Patient where severityLevel=:severity");
        query.setParameter( "severity", severity);

        List< Patient> severityPatientList = query.list();

        return severityPatientList;
    }

    @Override public List<Patient> getAllPatients() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Patient ");
        List< Patient> patientList = query.list();

        tx.commit();
        session.close();

        return patientList;

    }

}
