package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.aps.entities.Admin;
import com.cg.aps.exception.AdminExistsException;
import com.cg.aps.exception.AdminNotFoundException;
import com.cg.aps.exception.InvalidDataException;
import com.cg.aps.repository.IAdminRepository;

@Service
@Transactional
public class AdminService implements IAdminService {

	@Autowired
	IAdminRepository repository;

	Logger logger = LoggerFactory.getLogger(AdminService.class);

	@ExceptionHandler
	@Override
	public Admin addNewAdmin(Admin admin) {
		logger.info("Inside addNewAdmin method");

		if (repository.existsByAdminId(admin.getAdminId())) {
		logger.error("Admin already exists");
		throw new AdminExistsException("Admin Id exists already"); // 
	} else {
		Admin adminObj = repository.save(admin);
		logger.info("Admin added");
		return adminObj;
	}
	}

	@Override
	public Admin signIn(Admin admin) {
		logger.info("Inside signIn method");
		int id = admin.getAdminId();
		String password = admin.getPassword();
		String roleId = admin.getRoleId();
		Admin adminData = repository.findByAdminIdAndPasswordAndRoleId(id, password, roleId);
		if (adminData == null) {
			logger.error("AdminNotFoundException in adminSignIn method");
			throw new AdminNotFoundException("No admin present"); 
		} else {

			return adminData;
		}

	}
	
	@Override
	public Admin adminLogin(String roleId, String password) {
		Optional<Admin> opuserEntity = repository.findByRoleIdAndPassword(roleId, password);
		if(opuserEntity.isPresent())
		{
			Admin userEntity = opuserEntity.get();
			logger.debug("user login");
			int n=userEntity.getAttempts();
			if(n<3) {
					if(userEntity.getPassword().equals(password)){
						return new Admin(userEntity.getAdminId(), userEntity.getRoleId(), userEntity.getPassword(), userEntity.getAttempts());
//						return UserUtil.convertLginEntityToLogin(userEntity);
					}else {
						userEntity.setAttempts(n+1);
						userEntity=repository.save(userEntity);
						logger.info("Invalid Password");
						throw new InvalidDataException("Invalid Password");
					}
			}else {
				logger.info("Reached maximum limit");
				throw new InvalidDataException("Reached maximum limit");
			}			
		}
		else
		{
			logger.info("Login Failed");
			throw new InvalidDataException("Login Failed");

		}
	}

	@Override
	public Admin signOut(Admin admin) {

		return admin;
	}

	@Override
	public List<Admin> getAll() {

		List<Admin> adminList = repository.findAll();
		if (adminList.isEmpty()) {
			logger.error("AdminNotFoundException in getAlladmin method");
			throw new AdminNotFoundException("No Admins found"); 
		} else
			return adminList;
	}


}
