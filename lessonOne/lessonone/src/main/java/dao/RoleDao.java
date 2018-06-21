package dao;

import Entity.RoleEntity;

import java.util.List;

public interface RoleDao {

    public RoleEntity findById(int id);

    public void save(RoleEntity role);

    public void update(RoleEntity role);

    public void delete(RoleEntity role);

    public List<RoleEntity> findAll();
}
