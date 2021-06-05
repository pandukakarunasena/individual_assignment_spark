package com.panduka.ncms;


import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.entity.Patient;
import com.panduka.ncms.entity.User;
import com.panduka.ncms.utils.db.HibernateUtil;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class maintest {

    public static void addHospitalDetails(){
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

    public static  void getAllHospitalTest(){
            System.out.println("hospital dao called");

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();

            Transaction tx = session.beginTransaction();
            System.out.println("executing the query.....");
            List<Hospital> allHospitals= session.createSQLQuery("select * from hospital").list();
            tx.commit();

            System.out.println( allHospitals);
    }

    public static  void addPatientDetails(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        for ( int i = 0; i < 5; i++){

            User doctor = new User();
            doctor.setRole("doc");
            doctor.setUsername("doc"+i);
            doctor.setLastName("lastName"+i);
            doctor.setFirstName("firstName"+i);

            Patient p = new Patient();
            p.setAdmitDate( new Date());
            p.setAge( 20+i);
            p.setDischargedBy( doctor);
            p.setLocationX(10+i);
            p.setLocationY(5*i);
            p.setSeverityLevel("bad");

            session.save( p);
            session.save( doctor);
        }
        tx.commit();
    }

    public static void getChiefDoctorByHospitalIdTest(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("executing the query.....");
        NativeQuery q = session.createSQLQuery("select chiefDoctor_id from hospital where hospital.id =:id");
        q.setParameter("id", "402888e879dd32080179dd322a190027");
        String doctor = (String) q.getSingleResult();

        NativeQuery q2 = session.createSQLQuery("select * from user where user.id=:id");
        q2.setParameter("id", doctor);
        q2.addEntity( User.class);
        User doctorDetails = (User) q2.getSingleResult();

        tx.commit();

        System.out.println( doctor);
        System.out.println( doctorDetails);
    }

    public static  void getPatientById( ){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Patient patient = session.get( Patient.class, "402888e879dd452d0179dd4531030000");

        if( patient != null){
            System.out.println(patient);
        }

        tx.commit();
        session.close();

    }

    public static void getPatientBySeverity(String severity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery( "From Patient where severityLevel=:severity");
        query.setParameter( "severity", severity);

        List< Patient> severityPatientList = query.list();
        System.out.println( severityPatientList.get(0).getDischargedBy());
        System.out.println( severityPatientList);

    }

    public static void main(String[] args) {
        getPatientBySeverity( "bad");
    }


}
