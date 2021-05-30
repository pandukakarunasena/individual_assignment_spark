package com.panduka.ncms;

import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.entity.User;
import com.panduka.ncms.utils.db.HibernateUtil;
import java.util.List;
import java.util.function.DoubleConsumer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class maintest {

    public static void main(String[] args) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction t = s.beginTransaction();
        System.out.println( "tx created" );

        Hospital hospital = new Hospital();
        User doctor = new User();
        doctor.setId("doctor1");
        doctor.setFirstName("jothi");
        doctor.setLastName("bokka");
        doctor.setPassword("test");
        doctor.setHospitalId(null);
        doctor.setUsername("doctor1hospital1");
        doctor.setRole("doctor");

        hospital.setId("hospital1");
        hospital.setName("hospital test");
        hospital.setLocationX(500);
        hospital.setLocationY(500);
        hospital.setChiefDoctor(doctor);

        s.save(doctor);
        s.save( hospital);
        t.commit();

        System.out.println("done....");

    }

}
