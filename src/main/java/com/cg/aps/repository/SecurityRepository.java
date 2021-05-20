package com.cg.aps.repository;

import java.util.List;

import com.cg.aps.entities.SecurityEntity;



public interface SecurityRepository {

	public long add(SecurityEntity bean);
	
	public void update(SecurityEntity bean);
	
	public void delete(SecurityEntity bean);
	
	
	public SecurityEntity findByPk(long id);
	
	public List<SecurityEntity> search(SecurityEntity bean, long pageNo, int pageSize);
	
	public List<SecurityEntity> search(SecurityEntity bean);
	
	
}
