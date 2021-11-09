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
		categoryDAO =  new CategoryDAO();
		cleanAndRechargeView();
		
	}
		
	
	public void save() {
		categoryDAO.save(category);
		
		Messages.addGlobalInfo("Category saved");
		cleanAndRechargeView();
	}
	
	public void select(Category selectedCategory) {
		category = selectedCategory;
	}
	
	public void edit() {
		categoryDAO.edit(category);
		cleanAndRechargeView();
		Messages.addGlobalInfo("Category edited.");

	}
	
	public void cleanAndRechargeView() {
		category = new Category();
		categories = categoryDAO.listAll();
	}
	
	
}
