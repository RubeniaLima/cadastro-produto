package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dao.CategoryDAO;
import dao.ProductDAO;
import domain.Category;
import domain.Product;
import lombok.Data;

@Named
@ViewScoped
@Data
public class ProductBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Product product;
	private List<Product> products;

	private List<Category> categories;

	private CategoryDAO categoryDAO;

	private ProductDAO productDAO;

	@PostConstruct
	public void start() {
		categoryDAO = new CategoryDAO();
		
		productDAO = new ProductDAO();

		product = new Product();
		categories = categoryDAO.listAll();
		products = productDAO.listAll();

	}

	public void save() {
       productDAO.save(product);
		product = new Product();
		categories = categoryDAO.listAll();
		products = productDAO.listAll();

		Messages.addGlobalInfo("Product saved");
       
	}
}
