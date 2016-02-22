package com.codetutr;

import cart.ejb.Cart;
import cart.util.BookException;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GreetingServlet", urlPatterns = "/payroll")
public class GreetingServlet extends HttpServlet {

	//@EJB
	private static Cart cart;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (cart == null) {
			try {
				resp.getOutputStream().println("Iniciando ejb via jndi.1.");
				cart = (Cart) InitialContext.doLookup("java:module/CartBean");
				resp.getOutputStream().println("valor:" + cart);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			/**
			try {
				resp.getOutputStream().println("Iniciando ejb via jndi.2.");
				cart = (Cart) InitialContext.doLookup("java:app/ejb1-1.0.0-SNAPSHOT/CartBean");
				resp.getOutputStream().println("valor:" + cart);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			try {
				resp.getOutputStream().println("Iniciando ejb via jndi.3.");
				cart = (Cart) InitialContext.doLookup("java:global/earWithWar/ejb1-1.0.0-SNAPSHOT/CartBean");
				resp.getOutputStream().println("valor:" + cart);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			try {
				resp.getOutputStream().println("Iniciando ejb via jndi.4.");
				cart = (Cart) InitialContext.doLookup("java:jboss/exported/earWithWar/ejb1-1.0.0-SNAPSHOT/CartBean!cart.ejb.Cart");
				resp.getOutputStream().println("valor:" + cart);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			try {
				resp.getOutputStream().println("Iniciando ejb via jndi.5.");
				cart = (Cart) InitialContext.doLookup("java:module/CartBean!cart.ejb.Cart");
				resp.getOutputStream().println("valor:" + cart);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			try {
				resp.getOutputStream().println("Iniciando ejb via jndi.6.");
				cart = (Cart) InitialContext.doLookup("java:app/ejb1-1.0.0-SNAPSHOT/CartBean!cart.ejb.Cart");
				resp.getOutputStream().println("valor:" + cart);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			try {
				resp.getOutputStream().println("Iniciando ejb via jndi.7.");
				cart = (Cart) InitialContext.doLookup("java:global/earWithWar/ejb1-1.0.0-SNAPSHOT/CartBean!cart.ejb.Cart");
				resp.getOutputStream().println("valor:" + cart);
			} catch (NamingException e) {
				e.printStackTrace();
			}*/
		}

		try {
			if (cart != null) {
				resp.getOutputStream().println("Si encontro resp:");
				cart.initialize("Duke d'Url", "123");
				cart.addBook("Infinite Jest");
				cart.addBook("Bel Canto");
				cart.addBook("Kafka on the Shore");

				List<String> bookList = cart.getContents();

				bookList = cart.getContents();

				Iterator<String> iterator = bookList.iterator();

				while (iterator.hasNext()) {
					String title = iterator.next();
					resp.getOutputStream().println("<br>Retrieving book title from cart: " + title + "</br>");
				}

				resp.getOutputStream().println("Removing \"Gravity's Rainbow\" from cart.");
				cart.removeBook("Gravity's Rainbow");
				cart.remove();
			} else {
				resp.getOutputStream().println("No hay ejb");
			}

		} catch (BookException ex) {
			resp.getOutputStream().write(("Caught a BookException: " + ex.getMessage() ).getBytes());
		} catch (Exception ex) {
			resp.getOutputStream().write("Caught an unexpected exception!".getBytes());
			ex.printStackTrace();
		}
	}
}