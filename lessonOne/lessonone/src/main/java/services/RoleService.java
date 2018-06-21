package services;

import DAOImpl.RoleDaoImpl;
import Entity.RoleEntity;
import dao.RoleDao;

import java.util.List;

public class RoleService {

    private RoleDao usersDao = new RoleDaoImpl();

    public RoleEntity findRoleById(int id) {
        return usersDao.findById(id);
    }

    public void saveRole(RoleEntity role) {
        usersDao.save(role);
    }

    public void updateRole(RoleEntity role) {
        usersDao.update(role);
    }

    public void deleteRole(RoleEntity role) {
        usersDao.delete(role);
    }

    public List<RoleEntity> findAll() {
        return usersDao.findAll();
    }
}
