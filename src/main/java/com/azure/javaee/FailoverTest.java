package com.azure.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class FailoverTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = "user";

		if (request.getParameter("name") != null) {
			name = request.getParameter("name");
		}

		if (request.getSession().getAttribute("name") != null) {
			name = (String) request.getSession().getAttribute("name");
		} else {
			request.getSession().setAttribute("name", name);
		}

		response.getWriter().append("Hello world, ").append(name).append(" from ").append(request.getLocalAddr())
				.append("!");
	}
}