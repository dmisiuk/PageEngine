package by.minsler.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.minsler.beans.PageData;
import by.minsler.dao.PageDataDaoPostgres;

public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PageDataDaoPostgres dao;

	public SiteController() {
	}

	@Override
	public void init() throws ServletException {

		super.init();
		dao = PageDataDaoPostgres.getDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String section = (String) request.getParameter("sect");

		String subsection = (String) request.getParameter("subsect");
		String id;
		if (section == null) {
			id = "main";
		} else if (subsection == null) {
			id = section;
		} else {
			id = subsection;
		}
		PageData pageData = dao.getPage(id);
		request.setAttribute("pageid", id);
		request.setAttribute("pagedata", pageData);
		System.out.println(pageData);
		StringBuffer menutext = new StringBuffer();
		menutext.append("<ul>");
		ArrayList<PageData> mpages = dao.getPagesByParent("main");
		for (int i = 0; i < mpages.size(); i++) {
			menutext.append("<li><a href=\"site?sect=");
			menutext.append(mpages.get(i).getId());
			menutext.append("\">");
			menutext.append(mpages.get(i).getTitle4menu());
			menutext.append("</a>");
			ArrayList<PageData> spages = dao.getPagesByParent(mpages.get(i)
					.getId());
			menutext.append("<ul>");
			for (int j = 0; j < spages.size(); j++) {
				menutext.append("<li><a href=\"site?sect=");
				menutext.append(mpages.get(i).getId());
				menutext.append("&subsect=");
				menutext.append(spages.get(j).getId());
				menutext.append("\">");
				menutext.append(spages.get(j).getTitle4menu());
				menutext.append("</a></li>");

			}
			menutext.append("</ul>");
			menutext.append("</li>");
		}
		menutext.append("</ul>");
		request.setAttribute("pagemenu", menutext.toString());

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/pages.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
