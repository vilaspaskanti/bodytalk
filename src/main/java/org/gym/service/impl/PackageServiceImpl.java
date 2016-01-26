package org.gym.service.impl;

import java.util.List;

import org.gym.dao.PackageDao;
import org.gym.model.GymPackage;
import org.gym.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageServiceImpl implements PackageService {

	@Autowired
	private PackageDao packageDao;
	
	@Override
	public List<GymPackage> getAllPackages() {
		return packageDao.getPackages();
	}

}
