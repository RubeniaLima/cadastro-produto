package bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dao.ProductDAO;
import domain.Product;
import lombok.Data;

@Data
@Named
@ViewScoped
public class ProductSearchBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Product product;
	private Boolean showDataPanel;
	
	@PostConstruct
	public void newProduct() {
		product = new Product();
		showDataPanel=false;
	}
	
	public void search() {
		ProductDAO productDAO = new ProductDAO();
		Product result =  productDAO.searchById(product.getId());
		if(result == null) {
			Messages.addFlashGlobalWarn("Id not found");
			showDataPanel=false;
			
		}else {
			product = result;
			showDataPanel = true;
		}
		
	}

}
