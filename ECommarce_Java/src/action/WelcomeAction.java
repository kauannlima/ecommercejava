package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductManagementDAO;
import pojo.Product;

public class WelcomeAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private List<Product> products;
    private String searchTerm;

    public void initializeProducts() {
        // Se o termo de pesquisa não estiver vazio, filtre os produtos
        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            products = ProductManagementDAO.getProductsByName(searchTerm);
        } else {
            // Se o termo de pesquisa estiver vazio, obtenha todos os produtos
            products = ProductManagementDAO.getAllProducts();
        }
    }

    public String execute() {
        initializeProducts();
        return "success";
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

  

}
