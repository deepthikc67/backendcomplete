package com.niit.Test;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.SupplierDAO;
import com.niit.Model.Supplier;

public class SupplierUnitTest 
{
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("Ramu");
		supplier.setSupplierAddress("banglore");
		assertTrue("Problem in Supplier Insertion",supplierDAO.addSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void getSupplierTest()
	{
		assertNotNull("Problem in get supplier",supplierDAO.getSupplier(2));
	}
	
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(2);
		assertTrue("Problem in Deletion:",supplierDAO.deleteSupplier(supplier));
	}

	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(3);
		supplier.setSupplierName("L Sofa Model");
		assertTrue("Problem in Updation",supplierDAO.updateSupplier(supplier));
	}
	
	@Test
	public void listSuppliersTest()
	{
		List<Supplier> listSuppliers=supplierDAO.getSuppliers();
		assertNotNull("No Suppliers",listSuppliers);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.print(supplier.getSupplierID()+":::");
			System.out.print(supplier.getSupplierName()+":::");
			System.out.println(supplier.getSupplierAddress());
			System.out.println(supplier.getSupplierMobileNO());
		}
	}
}










