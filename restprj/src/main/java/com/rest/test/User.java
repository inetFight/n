package com.rest.test;

public class User {
private String name;
private int deposit;
static User[] u = new User[10];


public User(String name, int deposit ){
	this.name = name;
	this.deposit = deposit;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getDeposit() {
	return deposit;
}

public void setDeposit(int deposit) {
	this.deposit += deposit;
}

}
