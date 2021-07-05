package com.panduka.ncms.dao.impl;

import com.panduka.ncms.dao.UserDAO;
import com.panduka.ncms.entity.User;
import com.panduka.ncms.exception.UserCreationFailedException;
import com.panduka.ncms.utils.db.HibernateUtil;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDAOImpl implements UserDAO {

    private static final Logger logger = LogManager.getLogger(UserDAOImpl.class);

    @Override public User saveUser(User newUser) {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            String hql = " FROM User U WHERE U.username = :username";
            Query query = session.createQuery(hql);
            query.setParameter("username", newUser.getUsername());
            List results = query.getResultList();

            if (results != null && !results.isEmpty()) {
                throw new UserCreationFailedException();
            }

            String id = (String) session.save(newUser);
            user = session.byId(User.class).getReference(id);
            transaction.commit();

        } catch (Exception ex) {
            logger.error("saveUser() " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }

            return null;
        }

        return user;
    }

    @Override public boolean updateUser(String id, User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("updateUser() " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    @Override public boolean deleteUser(String id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);

            if (user != null) {
                session.delete(user);
                System.out.println("user is deleted");
            }

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("deleteUser() " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    @Override public User getUser(String id) {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            user = session.get(User.class, id);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("getUser() " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();
            return null;
        }
        return user;
    }

    @Override public User getUserByUserNameAndPassword(String username, String password) {

        Transaction transaction = null;
        User user = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = " FROM User U WHERE U.username = :username AND U.password = : password";
            Query query = session.createQuery(hql);
            query.setParameter("password", password);
            query.setParameter("username", username);
            List results = query.getResultList();

            if (results != null && !results.isEmpty()) {
                user = (User) results.get(0);
            }

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("getUserByUserNameAndPassword() " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();

        }

        return user;
    }

    @Override public User getUserByUsername(String username) {
        Transaction transaction = null;
        User user = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = " FROM User U WHERE U.username = :username";
            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            List results = query.getResultList();

            if (results != null && !results.isEmpty()) {
                user = (User) results.get(0);
            }

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("getUserByUsername() " + ex.getMessage());
            logger.error(ex.getCause());
            ex.printStackTrace();

        }

        return user;
    }

}
