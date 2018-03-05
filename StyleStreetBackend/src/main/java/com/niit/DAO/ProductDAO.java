package com.niit.DAO;
import java.util.List;
import com.niit.Model.Product;
public interface ProductDAO 
  {
	public boolean addProduct (Product product);
	public Product getProduct(int productId);
	public boolean deleteProduct (Product product);
	public boolean updateProduct(Product product);
	public List<Product> getProducts();
  }
