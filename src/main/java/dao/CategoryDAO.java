package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Category;
import util.JpaUtil;

public class CategoryDAO {
	
	

	public void save(Category category) {

		EntityManager section = JpaUtil.getEntityManager();

		EntityTransaction transaction = section.getTransaction();

		transaction.begin();
		section.persist(category);
		transaction.commit();

		section.close();
	}
	
	public Category serchById(Long id) {
		EntityManager section = JpaUtil.getEntityManager();
		Category category = section.find(Category.class, id);
		return category;
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> listAll(){
		String jpql = "select c from Category c order by name";
		EntityManager section = JpaUtil.getEntityManager();
		Query query = section.createQuery(jpql);
		List<Category> result = query.getResultList();
		return result;
	}
}
