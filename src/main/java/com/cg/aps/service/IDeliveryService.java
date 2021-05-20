package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entities.DeliveryEntity;

public interface IDeliveryService {
	public DeliveryEntity getDeliveryEntity(String name);
	
	public List<DeliveryEntity> getDeliveryEntity();
	
	public List<DeliveryEntity> getDeliveryByDelivery(DeliveryEntity sendDelivery);
	
	public DeliveryEntity getDeliveryOwner(String ownerName);
	
	public DeliveryEntity insertDeliveryEntity(DeliveryEntity delivery);
	
	public DeliveryEntity updateDeliveryEntity(DeliveryEntity delivery);
	
	public DeliveryEntity deleteDeliveryEntity(String name);
	
	public List<DeliveryEntity> getDeliveryPage(Integer pageNo, Integer pageSize, String sortBy);

}
