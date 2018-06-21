package DAOImpl;

import Entity.RoleEntity;
import dao.RoleDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class RoleDaoImpl implements RoleDao {

    public RoleEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(RoleEntity.class, id);
    }

    public void save(RoleEntity role) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(role);
        tx1.commit();
        session.close();
    }

    public void update(RoleEntity role) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(role);
        tx1.commit();
        session.close();
    }

    public void delete(RoleEntity role) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(role);
        tx1.commit();
        session.close();
    }

    public List<RoleEntity> findAll() {
        List<RoleEntity> users = (List<RoleEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Role").list();
        return users;
    }
}
