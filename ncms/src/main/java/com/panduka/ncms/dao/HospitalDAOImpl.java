package com.panduka.ncms.dao;

import com.panduka.ncms.dto.HospitalDTO;
import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.utils.db.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class HospitalDAOImpl implements HospitalDAO{

    @Override public List<Hospital> getAllHospitals() {

        return null;
    }

    @Override public Hospital getHospitalById(String id) {
        return null;
    }

    @Override public Hospital createHospital( Hospital newHospital) {
        //Get Session
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(newHospital);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID="+newHospital.getId());

        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionAnnotationFactory().close();

        return null;
    }

    @Override public boolean deleteHospital() {
        return false;
    }

    @Override public boolean updateHospital() {
        return false;
    }

}
