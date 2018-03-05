package com.niit.Test;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ProductDAO;
import com.niit.Model.Product;

public class ProductUnitTest 
{
	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void addProductTest()
	{
		 Product product=new  Product();
		 product.setProductName("saturn gold");
		product.setProductDesc("highlighted version Type");
		assertTrue("Problem in product Insertion",productDAO.addProduct(product));
	}
	
	@Ignore
	@Test
	public void getProductTest()
	{
		assertNotNull("Problem in get Product",productDAO.getProduct(2));
	}
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		 Product product=productDAO.getProduct(3);
		assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
	}

	@Test
	public void updateProductTest()
	{
		 Product product=productDAO.getProduct(3);
		 product.setProductName("titan11");
		assertTrue("Problem in Updation",productDAO.updateProduct(product));
	}
	
	@Test
	public void listProductsTest()
	{
		List< Product> listProducts=productDAO.getProducts();
		assertNotNull("NoProducts",listProducts);
		
		for( Product product:listProducts)
		{
			System.out.print(product.getProductID()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.println(product.getProductDesc());
		}
	}
}










