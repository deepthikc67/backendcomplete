package com.niit.Impl;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.CategoryDAO;
import com.niit.Model.Category;

@Repository("cdao")
public class CategoryImpl implements CategoryDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	//addCategory
	@Transactional
	public boolean addCategory(Category category) 
	{	
		try
		{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(category);
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

	//getCategory()
	
	public Category getCategory(int categoryId) 
	{
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,categoryId);
		session.close();
		return category;
	}

	//deleteCategory()
	@Transactional
	public boolean deleteCategory(Category category) 
	{

		Session session=sessionFactory.openSession();
session.beginTransaction(); session.save(category);
session.getTransaction().commit();
session.close();
return false;
		
	}
	
	//updateCategory()
	@Transactional
	public boolean updateCategory(Category category) 
	{
		try		
		{
			Session session=sessionFactory.openSession();
	        session.beginTransaction(); session.save(category);
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

	//listCategories()	
	public List<Category> getCategories() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> listCategories=(List<Category>)query.list();
		return listCategories;
	}
	
	
	
	

}



	
	



