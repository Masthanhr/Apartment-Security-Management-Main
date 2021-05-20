package com.cg.aps.repository;

import java.util.List;

import com.cg.aps.entities.DomesticHelpEntity;



public interface DomesticHelpRepository {

	public long add(DomesticHelpEntity bean);
	
	public void update(DomesticHelpEntity bean);
	
	public void delete(DomesticHelpEntity bean);
	
	public DomesticHelpEntity findByName(String name);
	
	public DomesticHelpEntity findByPk(long id);
	
	public List<DomesticHelpEntity> search(DomesticHelpEntity bean, long pageNo, int pageSize);
	
	public List<DomesticHelpEntity> search(DomesticHelpEntity bean);
	
	
}
