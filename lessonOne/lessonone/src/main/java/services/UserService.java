package services;

import DAOImpl.UserDAOImpl;
import Entity.UsersEntity;
import dao.UserDao;

import java.util.List;

public class UserService {

    private UserDao usersDao = new UserDAOImpl();

    public UsersEntity findUserById(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(UsersEntity user) {
        usersDao.save(user);
    }

    public void updateUser(UsersEntity user) {
        usersDao.update(user);
    }

    public void deleteUser(UsersEntity user) {
        usersDao.delete(user);
    }

    public List<UsersEntity> findAll() {
        return usersDao.findAll();
    }
}
