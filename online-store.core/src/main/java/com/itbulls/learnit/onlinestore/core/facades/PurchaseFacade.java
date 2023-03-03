package com.itbulls.learnit.onlinestore.core.facades;

import java.util.List;

import com.itbulls.learnit.onlinestore.persistence.entities.Product;
import com.itbulls.learnit.onlinestore.persistence.entities.Purchase;
import com.itbulls.learnit.onlinestore.persistence.entities.User;

public interface PurchaseFacade {

	Integer LAST_STATUS_OF_ORDER_FULFILMENT_ID = 6;
	
	void createPurchase(User attribute, Product productId);

	List<Purchase> getNotCompletedPurchases();

	void markFulfilmentStageForPurchaseIdAsCompleted(Integer purchaseId);

}
