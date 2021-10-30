package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dao.CategoryDAO;
import domain.Category;
import lombok.Data;

@Named
@ViewScoped
@Data
public class ProductBean implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private List<Category> categories;
		
		private CategoryDAO categoryDAO;
		
	
	@PostConstruct
	public void start() {
		
		categoryDAO = new CategoryDAO();
		categories =  categoryDAO.listAll();
	}

}
