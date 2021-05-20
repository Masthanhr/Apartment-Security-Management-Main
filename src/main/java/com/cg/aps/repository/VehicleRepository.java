package com.cg.aps.repository;

import java.util.List;

import com.cg.aps.entities.VehicleEntity;



public interface VehicleRepository {

	public long add(VehicleEntity bean);
	
	public void update(VehicleEntity bean);
	
	public void delete(VehicleEntity bean);
	
	public VehicleEntity findByName(String name);
	
	public VehicleEntity findByPk(long id);
	
	public List<VehicleEntity> search(VehicleEntity bean, long pageNo, int pageSize);
	
	public List<VehicleEntity> search(VehicleEntity bean);
	
	
}
