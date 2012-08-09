package by.minsler.admin.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.minsler.beans.PageData;
import by.minsler.dao.PageDataDaoPostgres;

public class ShowCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<PageData> list;
		ArrayList<PageData> subList;
		Iterator<PageData> pageIterator;
		PageDataDaoPostgres dao = PageDataDaoPostgres.getDao();
		list = dao.getPagesByParent("main");
		pageIterator = list.iterator();
		StringBuffer st = new StringBuffer();
		st.append("<ul>");
		while (pageIterator.hasNext()) {
			PageData pageData = pageIterator.next();
			st.append("<li>");
			st.append(pageData.getTitle());
			st.append(" <a href=\"admin?operation=edit&id=");
			st.append(pageData.getId());
			st.append("\">Edit</a>");
			st.append(" <a href=\"admin?operation=delete&id=");
			st.append(pageData.getId());
			st.append("\">Delete</a>");
			st.append("</a></li>");

			subList = dao.getPagesByParent(pageData.getId());
			Iterator<PageData> subpageIterator = subList.iterator();

			st.append("<ul>");
			while (subpageIterator.hasNext()) {
				PageData subPageData = subpageIterator.next();
				st.append("<li>");
				st.append(subPageData.getTitle());
				st.append(" <a href=\"admin?operation=edit&id=");
				st.append(subPageData.getId());
				st.append("\">Edit</a>");
				st.append(" <a href=\"admin?operation=delete&id=");
				st.append(subPageData.getId());
				st.append("\">Delete</a>");
				st.append("</a></li>");
			}
			st.append("<li><a href=\"admin?operation=add&id=");
			st.append(pageData.getId());
			st.append("\">Add page</a></li>");

			st.append("</ul>");
			st.append("</li>");
		}
		st.append("<li><a href=\"admin?operation=add&id=main\">");
		st.append("Add page</a></li>");
		st.append("</ul>");

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/mainadmin.jsp");
		request.setAttribute("menu", st.toString());
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
