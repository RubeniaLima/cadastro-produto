package util;

import javax.persistence.EntityManager;

public class TestDB {

	public static void main(String[] args) {

		EntityManager con = JpaUtil.getEntityManager();
		
		System.out.println("entrou no banco" + con);
	}

}
