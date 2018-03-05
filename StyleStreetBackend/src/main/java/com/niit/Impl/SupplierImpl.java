package com.niit.Impl;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.SupplierDAO;
import com.niit.Model.Supplier;

@Repository("supplierDAO")
public class SupplierImpl implements SupplierDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	//addsupplier
	@Transactional
	public boolean addSupplier(Supplier supplier) 
	{	
		try
		{
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(supplier);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	//getsupplier()
	
	public Supplier getSupplier(int supplierId) 
	{
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,supplierId);
		session.close();
		return supplier;
	}

	//deletesupplier()
	@Transactional
	public boolean deleteSupplier(Supplier supplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	}
	
	//updatesupplier()
	@Transactional
	public boolean updateSupplier(Supplier supplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	
	}

	//listsuppliers()	
	public List<Supplier> getSuppliers() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> listSuppliers=(List<Supplier>)query.list();
		return listSuppliers;
	}
	
	
	
	

}



	
	




