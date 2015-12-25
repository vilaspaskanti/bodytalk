package org.gym.service.impl;

import org.gym.dao.RoleDao;
import org.gym.model.Role;
import org.gym.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDao roleDao;
	
	@Override
	public Role getRole(String role) {
		return roleDao.getRole(role);
	}

}
