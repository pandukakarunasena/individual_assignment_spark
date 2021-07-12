package com.panduka.ncms.dao.impl;

import static com.panduka.ncms.utils.Constants.GET_ALL_HOSPITALS_QUERY;
import static com.panduka.ncms.utils.Constants.GET_ALL_PATIENTS_BY_HOSPITAL_ID_QUERY;

import com.panduka.ncms.dao.HospitalDAO;
import com.panduka.ncms.entity.Bed;
import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.entity.Patient;
import com.panduka.ncms.utils.db.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HospitalDAOImpl implements HospitalDAO {
    private static final Logger logger = LogManager.getLogger(HospitalDAOImpl.class);

    @Override public List getAllHospitals() {

        Transaction transaction = null;
        List hospitals = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query q = session.createQuery(GET_ALL_HOSPITALS_QUERY);
            hospitals = q.list();
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("getAllHospitals(): " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();

            return null;
        }
        return hospitals;
    }

    @Override public Hospital getHospitalById(String id) {

        Transaction transaction = null;
        Hospital hospital = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            hospital = session.get(Hospital.class, id);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("getAllHospitals(): " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();

            return null;
        }

        return hospital;
    }

    @Override public Hospital saveHospital(Hospital newHospital) {

        Transaction transaction = null;
        Hospital hospital = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(newHospital);
            transaction.commit();

        } catch (Exception ex) {
            //            if (transaction != null) {
            //                transaction.rollback();
            //            }
            logger.error("saveHospital(): " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();

            return null;
        }

        return hospital;
    }

    @Override public boolean deleteHospital(String id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            Hospital hospitalToBeDeleted = session.get(Hospital.class, id);

            if (hospitalToBeDeleted != null) {
                session.delete(hospitalToBeDeleted);
                logger.info(hospitalToBeDeleted + " deleted");

            }
            transaction.commit();
            session.close();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("deleteHospital(): " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();

            return false;
        }

        return true;
    }

    @Override public boolean updateHospital(String id, Hospital newUpdatedHospital) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(newUpdatedHospital);
            transaction.commit();
            logger.info(newUpdatedHospital + " updated");

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("deleteHospital(): " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    @Override public List<Patient> getPatientsByHospital(String id) {

        Transaction transaction = null;
        List<Patient> patients = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query q = session.createQuery(GET_ALL_PATIENTS_BY_HOSPITAL_ID_QUERY);
            q.setParameter("id", id);
            patients = q.list();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("deleteHospital(): " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();
            return null;
        }
        return patients;
    }

}
