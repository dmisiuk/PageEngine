package by.minsler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			Class.forName("org.firebirdsql.jdbc.FBDriver");
			System.out.println("jdbc driver loaded");
		} catch (ClassNotFoundException e) {
			System.out.println("error load jdbc driver");
		}

	}
}
