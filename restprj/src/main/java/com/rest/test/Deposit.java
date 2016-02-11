package com.rest.test;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/deposit")
public class Deposit {

	@GET
	@Path("/{username}")
	@Produces(MediaType.TEXT_PLAIN)
	public String get(@PathParam("username") String username) {

		for (int i = 0; i < User.u.length; i++) {
			if (User.u[i] != null)
				if (User.u[i].getName().equals(username) == true) {
					return "User " + User.u[i].getName() + " has " + User.u[i].getDeposit() + " on deposit";

				}

		}

		return "User not found";
	}

	@PUT
	@Path("/{username}/{dep}")
	@Produces(MediaType.TEXT_PLAIN)
	public String add(@PathParam("username") String username, @PathParam("dep") int dep) {
		for (int i = 0; i < User.u.length; i++) {
			if (User.u[i] != null) {
				if (User.u[i].getName().equals(username) == true) {
					User.u[i].setDeposit(dep);
					return " deposit " + User.u[i].getName() + " increased on " + dep + " . Deposit = "
							+ User.u[i].getDeposit();

				}
			}
		}
		for (int j = 0; j < User.u.length; j++) {
			if (User.u[j] == null) {
				User.u[j] = new User(username, dep);
				return "User not found. Created new user with name " + username + " and deposited " + dep;
			}
		}

		return "Array is max! Error";
	}

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String Deposit() {
		String s = " ";
		for (int i = 0; i < User.u.length; i++) {
			if (User.u[i] != null) {
				s += User.u[i].getName() + " = " + User.u[i].getDeposit() + "\n";
			}
		}
		return s;
	}

}
