package by.minsler.admin.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.minsler.beans.PageData;
import by.minsler.dao.PageDataDaoPostgres;

public class EditWriteCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PageData pageData = new PageData();
		PageDataDaoPostgres dao = PageDataDaoPostgres.getDao();

		pageData.setId(request.getParameter("id"));
		pageData.setParentid(request.getParameter("parentid"));
		pageData.setTitle(request.getParameter("title"));
		pageData.setTitle4menu(request.getParameter("title4menu"));
		pageData.setKeywords(request.getParameter("keywords"));
		pageData.setDescription(request.getParameter("description"));
		pageData.setMaintext(request.getParameter("maintext"));
		dao.updatePage(pageData);
		try {
			response.sendRedirect("admin");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
