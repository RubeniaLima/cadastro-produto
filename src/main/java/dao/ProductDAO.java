package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Product;
import util.JpaUtil;

public class ProductDAO {

	public void save(Product product) {

		EntityManager section = JpaUtil.getEntityManager();

		EntityTransaction transaction = section.getTransaction();

		transaction.begin();
		section.persist(product);
		transaction.commit();

		section.close();
	}

	public Product serchById(Long id) {
		EntityManager section = JpaUtil.getEntityManager();
		Product product = section.find(Product.class, id);
		return product;
	}

	@SuppressWarnings("unchecked")
	public List<Product> listAll() {
		
		String jpql = "select p from Product p order by name";
		EntityManager section = JpaUtil.getEntityManager();
		Query query = section.createQuery(jpql);
		List<Product> result = query.getResultList();
		return result;
	}
}
