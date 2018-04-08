package com.infosys.dao;

import java.util.List;

import org.hibernate.Session;

import com.infosys.beans.Account;
import com.infosys.beans.Auth;
import com.infosys.util.HibernateUtil;

//Accountdao uses hibernate to access and search database
public class AccountDao {
	// Getaccount searches table for instance of a user with a specific username
	public Auth getAccount(String username) {
		//hibernate util is used to create a session
		Session session = HibernateUtil.getSessionFactory().openSession();
		//HQL returns a list of Accounts searching for username in prepared HQl statement
		List<Account> accountlist = session.createQuery("from Account where username = :mystring").setString("mystring", username).list();
		Account users;
		//if size of return list is greater than zero a user has been found
		if (accountlist.size()>0) {
			users = accountlist.get(0);
		}
		//else null should be returned so request can end
		else {
			System.out.println("not found");
			users = null;
		}
		//session is closed before returned 
		session.close();
		if (users==null) {
			return null;
		}
		//new authorized object is returned which has the name and password from the database to  check
		Auth auth = new Auth(users.getUsername(), users.getPassword());
		
		return auth;
	}
	
	//As opposed to getAccount, getUser returns a full Account object to be returned to client
	public Account getUser(String username) {
		//return (Users) HibernateUtil.getSessionFactory().	openSession().get(Users.class, user.getUid());
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Setstring is depreciated but still functional for these purposes
		List<Account> retUserList = session.createQuery("from Account where username = :namevar").
				setString("namevar", username).list(); 
		Account retUser;
		if(retUserList.size() > 0) {
			retUser = retUserList.get(0);
		}
		else {
			retUser = null;
		}
			session.close();
			return retUser;
		}
	}

