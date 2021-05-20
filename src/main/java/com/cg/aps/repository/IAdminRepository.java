package com.cg.aps.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {
	public Admin findByAdminIdAndPasswordAndRoleId(int adminId, String password, String roleId);

	public boolean existsByAdminId(int adminId);
	public Admin findByAdminId(int adminId);
	Optional<Admin> findByRoleIdAndPassword(String roleId, String password);
}

