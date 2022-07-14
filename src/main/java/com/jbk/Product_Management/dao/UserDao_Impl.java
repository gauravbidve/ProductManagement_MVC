package com.jbk.Product_Management.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.RollbackException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jbk.Product_Management.entity.User;

@Repository
public class UserDao_Impl implements UserDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public User loginProcess(User user) {
		
		Session session = null;
		User usr = null;
		try {
		session = sf.openSession();
		usr = session.get(User.class,user.getUsername());
		System.out.println(usr);
		if(usr!=null) {
			if(user.getPassword().equals(usr.getPassword())) {
				return usr;
			} else {
				usr = null;
			}
		}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return usr;
	}

	@Override
	public boolean addUser(User user) {
		
		Session session = null;
		boolean value = false;
		
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			value = true;
		}catch(RollbackException r) {
			value=false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return value;
	}

	@Override
	public List<User> listOfUser() {
		
		Session session = null;
		List<User> users = new ArrayList<>();
		
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(User.class);
			users = criteria.list();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return users;
	}

	@Override
	public boolean deleteUser(String username) {
		
		Session session = null;
		boolean value = false;
		
		try {
			session=sf.openSession();
			User user = session.get(User.class, username);
			Transaction transaction = session.beginTransaction();
			session.delete(user);
			transaction.commit();
			value=true;
		}catch(IllegalArgumentException i) {
			value=false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return value;
	}

	@Override
	public User profile(String username) {
		
		Session session = null;
		User user = null;
		
		try {
			session = sf.openSession();
			user = session.get(User.class, username);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		
		Session session = null;
		boolean value = false;
		
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
			value=true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return value;
	}

	@Override
	public int[] insertUsers(List<User> list) {
		
		Session session = null;
		int[] countArray = new int[2];
		int addCount = 0;
		int notCount = 0;
		
		try {
			session = sf.openSession();
			for(User user:list) {
				User usr = session.get(User.class, user.getUsername());
				if(usr==null) {
					Transaction transaction = session.beginTransaction();
					session.save(user);
					transaction.commit();
					addCount++;
				} else {
					notCount++;
				}
			}
			
			countArray[0]=addCount;
			countArray[1]=notCount;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return countArray;
	}


}
