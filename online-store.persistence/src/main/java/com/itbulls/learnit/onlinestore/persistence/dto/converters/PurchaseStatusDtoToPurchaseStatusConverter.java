package com.itbulls.learnit.onlinestore.persistence.dto.converters;

import org.springframework.stereotype.Service;

import com.itbulls.learnit.onlinestore.persistence.dto.PurchaseStatusDto;
import com.itbulls.learnit.onlinestore.persistence.entities.PurchaseStatus;
import com.itbulls.learnit.onlinestore.persistence.entities.impl.DefaultPurchaseStatus;

@Service
public class PurchaseStatusDtoToPurchaseStatusConverter {

	public PurchaseStatus convertPurchaseStatusDtoToPurchaseStatus(PurchaseStatusDto purchaseStatusDto) {
		PurchaseStatus purchaseStatus = new DefaultPurchaseStatus();
		purchaseStatus.setId(purchaseStatusDto.getId());
		purchaseStatus.setStatusName(purchaseStatusDto.getStatusName());
		return purchaseStatus;
	}

	public PurchaseStatusDto convertPurchaseStatusToPurchaseStatusDto(PurchaseStatus purchaseStatus) {
		PurchaseStatusDto dto = new PurchaseStatusDto();
		dto.setId(purchaseStatus.getId());
		dto.setStatusName(purchaseStatus.getStatusName());
		return dto;
	}

}
