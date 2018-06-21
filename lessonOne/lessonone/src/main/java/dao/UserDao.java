package dao;

import Entity.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public interface UserDao {

    public UsersEntity findById(int id);

    public void save(UsersEntity user);

    public void update(UsersEntity user);

    public void delete(UsersEntity user);

    public List<UsersEntity> findAll();
}
