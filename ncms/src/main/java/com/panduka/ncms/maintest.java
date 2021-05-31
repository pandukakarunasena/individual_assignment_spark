package com.panduka.ncms;

import com.panduka.ncms.dto.HospitalDTO;
import com.panduka.ncms.dto.impl.HospitalDTOImpl;
import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.entity.User;
import com.panduka.ncms.helpers.Mapper;
import com.panduka.ncms.utils.db.HibernateUtil;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class maintest {

    public static void main(String[] args) {
//        System.out.println("hospital dao called");
//
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//
//        Transaction tx = session.beginTransaction();
//        System.out.println("executing the query.....");
//        List<Hospital> allHospitals= session.createSQLQuery("select * from hospital").list();
//        tx.commit();
//
//        System.out.println( allHospitals);
//
//        //terminate session factory, otherwise program won't end
//        HibernateUtil.getSessionFactory().close();

        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.beginTransaction();


        for( int i = 0; i < 20; i++){
            User doctor = new User();
            doctor.setRole("doc");
            doctor.setUsername("doc"+i);
            doctor.setLastName("lastName"+i);
            doctor.setFirstName("firstName"+i);


            Hospital h = new Hospital();
            h.setName("hospital "+i);
            h.setAvailBeds(10);
            h.setDistrict("district "+ i%5);
            h.setLocationX(i*5);
            h.setLocationY(i*2);
            h.setBuildDate(new Date());
            h.setPatientList(null);
            h.setChiefDoctor(doctor);

            s.save( doctor);
            s.save( h);


        }
        tx.commit();

    }

}
