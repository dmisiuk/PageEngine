package by.minsler.admin.commands;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.minsler.beans.PageData;
import by.minsler.dao.PageDataDaoPostgres;

public class EditCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");

		PageDataDaoPostgres dao = PageDataDaoPostgres.getDao();

		PageData pagedate = dao.getPage(id);
		request.setAttribute("pagedata", pagedate);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/edit.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
