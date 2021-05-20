package com.cg.aps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.aps.entities.DeliveryEntity;
import com.cg.aps.repository.DeliveryRepository;

@Service
public class DeliveryService implements IDeliveryService{
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	Logger logger=LoggerFactory.getLogger(DeliveryService.class);
	//******get delivery details findbyname******
	@Override
	public DeliveryEntity getDeliveryEntity(String name) {
		logger.info("Inside getDelivery method....");
		Optional<DeliveryEntity> delivery = deliveryRepository.findById(name);
		return (delivery.isPresent()) ? delivery.get() : null;
	}
	
	// ******get all the value by findall******
	@Override
	public List<DeliveryEntity> getDeliveryEntity() {
		logger.info("Inside getDelivery method....");
		List<DeliveryEntity> deliveryList = deliveryRepository.findAll();
		return deliveryList;
	}
	
	//******To post and get using deliveryentity ******
	@Override
	public List<DeliveryEntity> getDeliveryByDelivery(DeliveryEntity sendDelivery) {
		logger.info("Inside getDelivery method....");
		 Example<DeliveryEntity> deliveryExample = Example.of(sendDelivery);
		List<DeliveryEntity> deliveryList = deliveryRepository.findAll(deliveryExample); 
		return deliveryList;	
	}

	//******getting the value by giving ownername******
	@Override
	public DeliveryEntity getDeliveryOwner(String ownerName) {
		logger.info("Inside getDeliveryOwner method....");
	DeliveryEntity sendDelivery = deliveryRepository.ownerName(ownerName);
	return sendDelivery;
}


	//******inserting the values******
	@Override
	public DeliveryEntity insertDeliveryEntity(DeliveryEntity delivery) {
		logger.info("Inside getDelivery method....");
		DeliveryEntity deliveryexist = getDeliveryEntity(delivery.getOwnerName());
		if (deliveryexist == null) {
			delivery = deliveryRepository.save(delivery);
		}
		return delivery;
	}
	
	//******updating the values******
	@Override
	public DeliveryEntity updateDeliveryEntity(DeliveryEntity delivery) {
		logger.info("Inside getDelivery method....");
		DeliveryEntity deliveryexist = getDeliveryEntity(delivery.getOwnerName());
		if (deliveryexist != null) {
			delivery = deliveryRepository.save(delivery);
		}
		return delivery;
	}
	
	//******deleting the values******
	@Override
	public DeliveryEntity deleteDeliveryEntity(String name) {
		logger.info("Inside getDelivery method....");
		DeliveryEntity delivery = getDeliveryEntity(name);
		if (delivery != null)
			deliveryRepository.deleteById(name);
		return delivery;
	}
	
	//******pagination******
	@Override
	public List<DeliveryEntity> getDeliveryPage(Integer pageNo, Integer pageSize, String sortBy)
	{
		logger.info("Inside getDeliveryPage method....");
	    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

	    Page<DeliveryEntity> pagedResult = deliveryRepository.findAll(paging);
	     
	    if(pagedResult.hasContent()) {
	        return pagedResult.getContent();
	    } else {
	        return new ArrayList<DeliveryEntity>();
	    }
	}

	
	
}
