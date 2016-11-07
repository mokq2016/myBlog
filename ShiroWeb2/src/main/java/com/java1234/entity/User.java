package com.java1234.entity;

public class User {

	private int id;
	private String userName;
	private String password;
	
	private String salt;

    private Boolean locked = Boolean.FALSE;
	
	
	public User(int id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	
	public String getCredentialsSalt() {
        return userName + salt;
    }
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password="
				+ password + ", salt=" + salt + ", locked=" + locked + "]";
	}
	
	
	
}
