package com.niit.Impl;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.UserDAO;
import com.niit.Model.User;

@Repository("categoryDAO")
public class UserImpl implements UserDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	//addUser
	@Transactional
	public boolean addUser(User user) 
	{	
		try
		{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	//getUser()
	
	public User getUser(int userId) 
	{
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class,userId);
		session.close();
		return user;
	}

	//deleteUser()
	@Transactional
	public boolean deleteUser(User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	}
	
	//updateUser()
	@Transactional
	public boolean updateUser(User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	
	}

	//listUsers()	
	public List<User> getUsers() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<User> listUsers=(List<User>)query.list();
		return listUsers;
	}
	
	
	
	

}



	
	




