package com.itbulls.learnit.onlinestore.persistence.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.itbulls.learnit.onlinestore.persistence.dao.ProductDao;
import com.itbulls.learnit.onlinestore.persistence.dto.ProductDto;

@Repository
public class JpaProductDao implements ProductDao {

	@Override
	public List<ProductDto> getProducts() {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			List<ProductDto> products = em.createQuery("SELECT p FROM product p", ProductDto.class).getResultList();
			em.getTransaction().commit();
			return products;
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
	public ProductDto getProductById(int productId) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			ProductDto product = em.find(ProductDto.class, productId);
			em.getTransaction().commit();
			return product;
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
	public List<ProductDto> getProductsLikeName(String searchQuery) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();

			Query query = em.createNativeQuery(
					"SELECT * FROM learn_it_db.product WHERE UPPER(product_name) LIKE UPPER(CONCAT('%',?1,'%')",
					ProductDto.class);
			query.setParameter(1, searchQuery);
			List<ProductDto> resultList = query.getResultList();
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
	public List<ProductDto> getProductsByCategoryId(Integer id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<ProductDto> query = em.createQuery("SELECT p FROM product p WHERE p.categoryDto.id = :id",
					ProductDto.class);
			query.setParameter("id", id);
			List<ProductDto> resultList = query.getResultList();
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
	public List<ProductDto> getProductsByCategoryIdPaginationLimit(Integer categoryId, Integer page,
			Integer paginationLimit) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<ProductDto> query = em.createQuery("SELECT p FROM product p WHERE p.categoryDto.id = :id",
					ProductDto.class);
			query.setParameter("id", categoryId);

			query.setFirstResult((page - 1) * paginationLimit);
			query.setMaxResults(paginationLimit);

			List<ProductDto> resultList = query.getResultList();
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
	public Integer getProductCountForCategory(Integer categoryId) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Long> query = em.createQuery("SELECT COUNT(p) FROM product p WHERE p.categoryDto.id = :id",
					Long.class);
			query.setParameter("id", categoryId);
			Long count = query.getSingleResult();
			em.getTransaction().commit();
			return count.intValue();
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
	public Integer getProductCountForSearch(String searchQuery) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createNativeQuery(
					"SELECT COUNT(*) FROM product WHERE UPPER(product_name) LIKE UPPER(CONCAT('%',:searchQuery,'%'))");
			query.setParameter("searchQuery", searchQuery);
			BigInteger count = (BigInteger) query.getSingleResult();
			em.getTransaction().commit();
			return count.intValue();
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
	public List<ProductDto> getProductsLikeNameForPageWithLimit(String searchQuery, Integer page,
			Integer paginationLimit) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();

			Query query = em.createNativeQuery(
					"SELECT p.id, p.guid, p.product_name, p.description, p.price, p.category_id, p.img_name, c.id as cat_id, c.category_name, c.img_name as cat_img "
							+ "FROM learn_it_db.product p JOIN category c ON p.category_id = c.id "
							+ "WHERE UPPER(product_name) LIKE UPPER(CONCAT('%',:searchQuery,'%')) LIMIT :offset, :limit",
					ProductDto.class);
			query.setParameter("searchQuery", searchQuery);
			query.setParameter("offset", (page - 1) * paginationLimit);
			query.setParameter("limit", paginationLimit);

			List<ProductDto> resultList = query.getResultList();

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
	public ProductDto getProductByGuid(String guid) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<ProductDto> query = em.createQuery("SELECT p FROM product p WHERE p.guid = :guid",
					ProductDto.class);
			query.setParameter("guid", guid);

			ProductDto product = query.getSingleResult();
			em.getTransaction().commit();
			return product;
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
