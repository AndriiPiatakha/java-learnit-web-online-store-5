package com.itbulls.learnit.onlinestore.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.itbulls.learnit.onlinestore.persistence.dao.UserDao;
import com.itbulls.learnit.onlinestore.persistence.dto.UserDto;

@Repository
public class JpaUserDao implements UserDao {

	@Override
	public boolean saveUser(UserDto user) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
			return true;
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
	public List<UserDto> getUsers() {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			List<UserDto> users = em.createQuery("SELECT u FROM user u", UserDto.class).getResultList();
			em.getTransaction().commit();
			return users;
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
	public UserDto getUserByEmail(String userEmail) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();

			TypedQuery<UserDto> query = em.createQuery("SELECT u FROM user u WHERE u.email = :email", UserDto.class);
			query.setParameter("email", userEmail);
			try {
				UserDto user = query.getSingleResult();
				em.getTransaction().commit();
				return user;
			} catch (NoResultException e) {
				return null;
			}
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
	public UserDto getUserById(int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			UserDto user = em.find(UserDto.class, id);
			em.getTransaction().commit();
			return user;
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
	public UserDto getUserByPartnerCode(String partnerCode) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			System.out.println(partnerCode);
			TypedQuery<UserDto> query = em.createQuery("SELECT u FROM user u WHERE u.partnerCode = :partnerCode",
					UserDto.class);
			query.setParameter("partnerCode", partnerCode);
			try {
				UserDto user = query.getSingleResult();
				em.getTransaction().commit();
				return user;
			} catch (NoResultException e) {
				return null;
			}

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
	public void updateUser(UserDto newUser) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(newUser);
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
	public List<UserDto> getReferralsByUserId(int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<UserDto> query = em.createQuery("SELECT u FROM user u WHERE u.referrerUser.id = :id",
					UserDto.class);
			query.setParameter("id", id);
			List<UserDto> users = query.getResultList();
			em.getTransaction().commit();
			return users;
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
