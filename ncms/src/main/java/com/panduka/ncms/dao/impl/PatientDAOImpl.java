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
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PatientDAOImpl implements PatientDAO {

    Logger logger = LogManager.getLogger(PatientDAOImpl.class);

    @Override public Patient getPatientById(String id) {

        Transaction transaction = null;
        Patient patient = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            patient = session.get(Patient.class, id);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("getPatientById() " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();
            return null;
        }
        //System.out.println(patient.toString());
        return patient;
    }

    @Override public String savePatient(Patient patient) {
        String id = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            id = (String) session.save(patient);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("addPatient() " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();
            return null;
        }
        return id;
    }

    @Override public boolean deletePatient(String id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Patient patient = session.get(Patient.class, id);

            if (patient != null) {
                session.delete(patient);
                logger.info(patient + " deleted");
            }
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("deletePatient() " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    @Override public boolean updatePatient(String id, Patient newPatientDetails) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.update(newPatientDetails);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("updatePatient() " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override public List<Patient> getPatientBySeverity(String severity) {

        Transaction transaction = null;
        List<Patient> patients = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery(GET_ALL_PATIENTS_BY_SEVERITY_QUERY);
            query.setParameter("severity", severity);

            patients = query.list();
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("getPatientBySeverity() " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();
            return null;
        }

        return patients;
    }

    @Override public List<Patient> getAllPatients() {

        Transaction transaction = null;
        List<Patient> patients = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery(GET_ALL_PATIENTS_QUERY);
            patients = query.list();
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("getAllPatients() " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();
            return null;
        }

        return patients;
    }

}
