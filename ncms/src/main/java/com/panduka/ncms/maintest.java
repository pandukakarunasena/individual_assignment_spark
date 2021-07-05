package com.panduka.ncms;

import com.panduka.ncms.auth.TokenGenerator;
import com.panduka.ncms.dao.UserDAO;
import com.panduka.ncms.dao.impl.HospitalDAOImpl;
import com.panduka.ncms.dao.impl.UserDAOImpl;
import com.panduka.ncms.entity.Hospital;
import com.panduka.ncms.entity.Patient;
import com.panduka.ncms.entity.User;
import com.panduka.ncms.helpers.BedBooking;
import com.panduka.ncms.helpers.BedBookingImpl;
import com.panduka.ncms.utils.db.HibernateUtil;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
        System.out.println(" add patient details method");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Query q = session.createQuery( "from Hospital h where h.id=:id");
        q.setParameter("id", "402888e879dd32080179dd322a130003");
        Hospital hospital =(Hospital) q.getSingleResult();


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
            p.setHospital( hospital);

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

    public static void loggerConfigurationTesting(){
        logger.info( "loggerConfigurationTesting method called");

    }

    public static void getPatientListByHospital(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try{


            Query q = session.createQuery("select patientList from Hospital h where h.id=:id");
            q.setParameter( "id", "402888e879dd32080179dd322a130003");


            List patientList = q.list();

            tx.commit();
            System.out.println( patientList);
        }catch( NullPointerException ex){
            tx.rollback();
            System.out.println( ex);
            System.out.println( ex.getMessage() + " " + ex.getCause());
        }


    }
    private static final Logger logger = LogManager.getLogger( maintest.class);

    public static void main(String[] args) {

//        Hospital h = new Hospital();
//        h.setName("hospital0");
//        h.setAvailBeds(10);
//        h.setDistrict("district0");
//        h.setLocationX(0);
//        h.setLocationY(0);
//        h.setBuildDate(new Date());
//        h.setPatientList(null);
//        h.setChiefDoctor(null);
//
//        new HospitalDAOImpl().createHospital( h);

//        List b =  new BedBookingImpl().bookABed(0,0);
//        System.out.println( b.get(0));
//        System.out.println( b.get(1));


//        User userToBeUpdated = new User(
//                "userTest1",
//                "password1",
//                "jon",
//                "doe",
//                "MOH admin",
//                null
//        );
//        UserDAO userDAOImpl = new UserDAOImpl();
////        String id = "402888f27a6d7a01017a6d7a07b30000";
//        User existingUser = userDAOImpl.getUserByUserNameAndPassword( "userTest2", "password2");
//        System.out.println( existingUser.getFirstName() + " " + existingUser.getLastName());

//        existingUser.setUsername("userTest1");
//        existingUser.setPassword("password1");
//
//        System.out.println(userDAOImpl.updateUser(id, existingUser));
//        String jwt = new TokenGenerator().generateToken("jon", "snow");
//        System.out.println( jwt);
        //System.out.println( new TokenGenerator().parseJwt( "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidXNlclRlc3QzIiwicGFzc3dvcmQiOiJwYXNzd29yZDMiLCJzdWIiOiJqYW5lIiwianRpIjoiNmQzNmNiMzItNDdmZC00Yjg2LTk2YTYtOTgyYzRlNjk0Yzg2IiwiaWF0IjoxNjI1NDgwMjMzLCJleHAiOjE2MjU0ODA1MzN9.fbMQoNgCDApGDlYgNTGCSHCHUzqW91tYLe1BBDnUu3A"));
    }


}
