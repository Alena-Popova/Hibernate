package DAOImpl;

import Entity.UsersEntity;
import dao.UserDao;
import utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import java.util.List;

public class UserDAOImpl implements UserDao {

    public UsersEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UsersEntity.class, id);
    }

    public void save(UsersEntity user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(UsersEntity user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(UsersEntity user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }


    public List<UsersEntity> findAll() {
        List<UsersEntity> users = (List<UsersEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }
}
