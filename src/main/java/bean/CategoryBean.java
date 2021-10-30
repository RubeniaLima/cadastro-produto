package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dao.CategoryDAO;
import domain.Category;
import lombok.Data;

@Named
@ViewScoped
@Data
public class CategoryBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private Category category;
	private List<Category> categories;
	private CategoryDAO categoryDAO;
	
	@PostConstruct
	public void start() {
		category = new Category();
		categoryDAO =  new CategoryDAO();
		list();
		
	}
		
	
	public void save() {
		categoryDAO.save(category);
		category = new Category();
		Messages.addGlobalInfo("Category saved");
		list();
	}
	
	public void list() {
		categories = categoryDAO.listAll();
	}
}
