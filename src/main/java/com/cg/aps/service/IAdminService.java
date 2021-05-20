package com.cg.aps.service;

	
import java.util.List;


import com.cg.aps.entities.Admin;

public interface IAdminService {
	public  Admin addNewAdmin(Admin admin) ;
	public Admin signIn(Admin admin);
	public Admin signOut(Admin admin);
	public List<Admin> getAll();
	public Admin adminLogin(String roleId, String password);
}
