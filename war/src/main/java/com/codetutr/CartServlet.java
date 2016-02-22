package com.codetutr;

import cart.ejb.Cart;
import cart.util.BookException;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "GreetingServlet", urlPatterns = "/payroll")
public class CartServlet extends HttpServlet {

	@EJB
	private static Cart cart;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String orderNumber = (String)req.getSession().getAttribute("orderNumber");
		out.print("Your: " + orderNumber);

//		this.getServletContext().getInitParameter()
//		req.getRequestDispatcher("x").

//		resp.addCookie();

		this.getServletContext().getNamedDispatcher("");
//		this.getServletConfig().get

	}
}