package com.panduka.ncms.dao;

import static org.junit.jupiter.api.Assertions.*;

import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.entity.User;
import com.panduka.ncms.utils.db.HibernateUtil;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HospitalDAOImplTest {

    @Test void getAllHospitals() {

    }

    @Test void getHospitalById() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        String id  = "402888e679bf31b60179bf31be090001"; //test id
        Hospital selectedHospitalById = session.get( Hospital.class, id);
        tx.commit();
        HibernateUtil.getSessionFactory().close();
        Hospital hospital = new Hospital();

        Assertions.assertEquals(hospital.getClass(), selectedHospitalById.getClass());

    }

    @Test void createHospital() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction tx = session.beginTransaction();

        User doctor = new User();
        doctor.setId("doctor1");
        doctor.setFirstName("jothi");
        doctor.setLastName("bokka");
        doctor.setPassword("test");
        doctor.setHospitalId(null);
        doctor.setUsername("doctor1hospital1");
        doctor.setRole("doctor");

        Hospital hospital = new Hospital();
        hospital.setId("hospital1");
        hospital.setName("hospital test");
        hospital.setLocationX(500);
        hospital.setLocationY(500);
        hospital.setChiefDoctor(doctor);

        session.save(doctor);
        session.save( hospital);

        tx.commit();

    }

    @Test void deleteHospital() {
        boolean deleted = false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        String id = "402888e679bf31b60179bf31be090001"; //test id

        Query query = session.createQuery("delete Hospital where id = :id");
        query.setParameter("id", id);

        int result = query.executeUpdate();

        if (result > 0) {
            deleted = true;
        }

        tx.commit();
        HibernateUtil.getSessionFactory().close();

        Assertions.assertEquals(true, deleted);
    }

    @Test void updateHospital() {
    }

}