package by.minsler.admin.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.minsler.dao.PageDataDaoPostgres;

public class DeleteCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");

		PageDataDaoPostgres dao = PageDataDaoPostgres.getDao();

		dao.deletePage(id);
		try {
			response.sendRedirect("admin");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
