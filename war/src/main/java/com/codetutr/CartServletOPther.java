package com.codetutr;

import cart.ejb.Cart;

import javax.ejb.EJB;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GreetingServlet", urlPatterns = "/payroll")
public class CartServletOPther extends GenericServlet {

	@EJB
	private static Cart cart;


	protected void doGet(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
/*
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String orderNumber = (String)req.getSession().getAttribute("orderNumber");
		out.print("Your: " + orderNumber);
*/
//		this.getServletContext().getInitParameter()
//		req.getRequestDispatcher("x").
		HttpSessionContext d = null;
		d.getSession("");

		HttpSessionBindingEvent e = null;
		e.getSession();



	}

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

	}
}