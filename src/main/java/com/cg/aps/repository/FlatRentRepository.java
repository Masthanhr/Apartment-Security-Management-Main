package com.cg.aps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entities.FlatRentEntity;

@Repository
public interface FlatRentRepository extends JpaRepository<FlatRentEntity, Integer>{

	public FlatRentEntity ownerName(String ownerName);

}
