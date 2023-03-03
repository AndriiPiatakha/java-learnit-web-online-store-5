package com.itbulls.learnit.onlinestore.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.itbulls.learnit.onlinestore.persistence.dao.PurchaseDao;
import com.itbulls.learnit.onlinestore.persistence.dto.PurchaseDto;
import com.itbulls.learnit.onlinestore.persistence.dto.PurchaseStatusDto;
import com.itbulls.learnit.onlinestore.persistence.dto.UserDto;

@Repository
public class JpaPurchaseDao implements PurchaseDao {

	@Override
	public void savePurchase(PurchaseDto order) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();

			em.persist(order);

			em.getTransaction().commit();
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public List<PurchaseDto> getPurchasesByUserId(int userId) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<PurchaseDto> query = em.createQuery("SELECT p FROM purchase p WHERE p.userDto.id = :id",
					PurchaseDto.class);
			query.setParameter("id", userId);
			List<PurchaseDto> resultList = query.getResultList();
			em.getTransaction().commit();
			return resultList;
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public List<PurchaseDto> getPurchases() {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<PurchaseDto> query = em.createQuery("SELECT p FROM purchase p", PurchaseDto.class);
			List<PurchaseDto> resultList = query.getResultList();
			em.getTransaction().commit();
			return resultList;
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public List<PurchaseDto> getNotCompletedPurchases(Integer lastFulfilmentStageId) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery(
					"SELECT p.id, p.userDto, p.purchaseStatusDto FROM purchase p WHERE p.purchaseStatusDto.id != :statusId");
			query.setParameter("statusId", lastFulfilmentStageId);
			List<Object[]> resultList = query.getResultList();
			List<PurchaseDto> purchases = new ArrayList<>();
			for (Object[] resultTuple : resultList) {
				purchases.add(new PurchaseDto((Integer) resultTuple[0], (UserDto) resultTuple[1],
						(PurchaseStatusDto) resultTuple[2]));
			}
			em.getTransaction().commit();
			return purchases;
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public PurchaseDto getPurchaseById(Integer purchaseId) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<PurchaseDto> criteriaQuery = criteriaBuilder.createQuery(PurchaseDto.class);
			Root<PurchaseDto> purchaseRoot = criteriaQuery.from(PurchaseDto.class);
			purchaseRoot.fetch("userDto");
			purchaseRoot.fetch("productDtos");
			Query query = em.createQuery(criteriaQuery.select(purchaseRoot)
					.where(criteriaBuilder.equal(purchaseRoot.get("id"), purchaseId)));
			PurchaseDto purchase = (PurchaseDto) query.getSingleResult();
			em.getTransaction().commit();
			return purchase;
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void updatePurchase(PurchaseDto newPurchase) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(newPurchase);
			em.getTransaction().commit();
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
	}

}
