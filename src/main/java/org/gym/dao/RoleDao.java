package org.gym.dao;

import org.gym.model.Role;

public interface RoleDao extends GenericDao<Long, Role>{

	Role getRole(String role);

}
