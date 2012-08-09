package by.minsler.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.minsler.admin.commands.AddCommand;
import by.minsler.admin.commands.AddWriteCommand;
import by.minsler.admin.commands.Command;
import by.minsler.admin.commands.DeleteCommand;
import by.minsler.admin.commands.EditCommand;
import by.minsler.admin.commands.EditWriteCommand;
import by.minsler.admin.commands.ShowCommand;

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String operation = request.getParameter("operation");

		Command com = null;

		if (operation == null) {
			com = new ShowCommand();
		} else if (operation.equals("add")) {
			com = new AddCommand();
		} else if (operation.equals("addwrite")) {
			com = new AddWriteCommand();
		} else if (operation.equals("edit")) {
			com = new EditCommand();
		} else if (operation.equals("delete")) {
			com = new DeleteCommand();
		} else if (operation.equals("editWrite")) {
			com = new EditWriteCommand();
		}
		com.execute(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
