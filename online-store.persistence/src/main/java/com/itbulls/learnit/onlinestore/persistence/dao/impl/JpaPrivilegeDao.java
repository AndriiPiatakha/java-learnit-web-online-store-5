package com.itbulls.learnit.onlinestore.persistence.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.itbulls.learnit.onlinestore.persistence.dao.PrivilegeDao;
import com.itbulls.learnit.onlinestore.persistence.dto.PrivilegeDto;

@Repository
public class JpaPrivilegeDao implements PrivilegeDao {

	@Override
	public void save(PrivilegeDto privilege) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(privilege);
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
	public PrivilegeDto getPrivilegeByName(String privilegeName) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<PrivilegeDto> query = em.createQuery("SELECT p FROM privilege p WHERE p.name = :privilegeName",
					PrivilegeDto.class);
			query.setParameter("privilegeName", privilegeName);
			PrivilegeDto privilege = query.getResultList().stream().findFirst().orElse(null);
			em.getTransaction().commit();
			return privilege;
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
