package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory factory =  Persistence.createEntityManagerFactory("cadastroproduto");
	
	public static EntityManager getEntityManager() {
		
	EntityManager section = factory.createEntityManager();
	return section;
	}

}
