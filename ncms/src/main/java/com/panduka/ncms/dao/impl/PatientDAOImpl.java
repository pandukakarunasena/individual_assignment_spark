package com.panduka.ncms.dao.impl;

import static com.panduka.ncms.utils.Constants.GET_ALL_PATIENTS_BY_SEVERITY_QUERY;
import static com.panduka.ncms.utils.Constants.GET_ALL_PATIENTS_QUERY;

import com.panduka.ncms.dao.PatientDAO;
import com.panduka.ncms.entity.Patient;
import com.panduka.ncms.utils.db.HibernateUtil;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class PatientDAOImpl implements PatientDAO {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Logger logger = LogManager.getLogger( PatientDAOImpl.class);

    @Override public Patient getPatientById(String id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try{
            Patient patient = session.get( Patient.class, id);

            if( patient != null){
                return  patient;
            }
            tx.commit();

        }catch (Exception ex){
            logger.error( "getPatientById() " + ex.getMessage());
            logger.error( ex.getCause());
        }finally {
            session.close();
        }

        return null;
    }

    @Override public boolean addPatient(Patient patient) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try{
            //the bed number and the hospital should be taken as the requirement.
            session.save( patient);
            tx.commit();

        }catch (Exception ex){
            logger.error( "addPatient() " + ex.getMessage());
            logger.error( ex.getCause());
        }finally {
            session.close();
        }

        return true;
    }

    @Override public boolean deletePatient(String id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try{
            Patient patient = session.get( Patient.class, id);

            if( patient != null){
                session.delete( patient);
                return true;
            }
            tx.commit();

        }catch ( Exception ex){
            logger.error( "deletePatient() " + ex.getMessage());
            logger.error( ex.getCause());
        }finally {
            session.close();
        }

        return false;
    }

    @Override public boolean updatePatient(String id, Patient newPatientDetails) {
        return false;
    }

    @Override public List<Patient> getPatientBySeverity(String severity) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try{
            Query query = session.createQuery( GET_ALL_PATIENTS_BY_SEVERITY_QUERY);
            query.setParameter( "severity", severity);

            List< Patient> severityPatientList = query.list();
            tx.commit();
            return severityPatientList;

        }catch(Exception ex){
            logger.error( "getPatientBySeverity() " + ex.getMessage());
            logger.error( ex.getCause());
        }finally{
            session.close();
        }

        return null;
    }

    @Override public List<Patient> getAllPatients() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try{
            Query query = session.createQuery( GET_ALL_PATIENTS_QUERY);
            List< Patient> patientList = query.list();
            tx.commit();
            return patientList;

        }catch( Exception ex){
            logger.error( "getPatientBySeverity() " + ex.getMessage());
            logger.error( ex.getCause());
        }finally{
            session.close();
        }

        return null;
    }
}
