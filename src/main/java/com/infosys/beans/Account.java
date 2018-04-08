package com.infosys.beans;

import javax.persistence.*;


/*mapping class of the hibernate orm to contain accounts from database
 */
//Entity says the class can be mapped to a table
@Entity
//Table provides the actual database table the class will be mapped to
@Table(name="accounts")
public class Account {
	//Id defines as primary key
	//column defines which column in the table the value is mapped to
	//Generated value defines the strategy on inserting a primary key as default values
	@Id
	@Column(name="accountids")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int accountid;
	
	@Column(name="username")
	private String username;
	
	@Column(name="passwords")
	private String password;

	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="money")
	private String money;
	
	public Account() {
		
	}
	
	public Account(int accountid, String username, String password, String firstname, String lastname, String money) {
		super();
		this.accountid = accountid;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.money = money;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	
}
