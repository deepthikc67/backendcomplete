package com.niit.Test;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDAO;
import com.niit.Model.User;

public class UserUnitTest 
{
	static UserDAO userDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void addUserTest()
	{
		User user=new User();
		user.setUserName("Rajuu");
		user.setUserAddress("banglore jayanagar");
		assertTrue("Problem in User Insertion",userDAO.addUser(user));
	}
	
	@Ignore
	@Test
	public void getUserTest()
	{
		assertNotNull("Problem in get user",userDAO.getUser(2));
	}
	
	@Ignore
	@Test
	public void deleteUserTest()
	{
		User user=userDAO.getUser(2);
		assertTrue("Problem in Deletion:",userDAO.deleteUser(user));
	}

	@Test
	public void updateUserTest()
	{
		User user=userDAO.getUser(3);
		user.setUserName("L Sofa Model");
		assertTrue("Problem in Updation",userDAO.updateUser(user));
	}
	
	@Test
	public void listUsersTest()
	{
		List<User> listUsers=userDAO.getUsers();
		assertNotNull("No users",listUsers);
		
		for(User user:listUsers)
		{
			System.out.print(user.getUserID()+":::");
			System.out.print(user.getUserName()+":::");
			System.out.println(user.getUserAddress());
			System.out.println(user.getMobileNO());
		}
	}
}










