package by.minsler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.minsler.beans.PageData;
import by.minsler.db.ConnectionInit;

public class PageDataDaoPostgres {

	private static PageDataDaoPostgres inst;

	private Connection connection;
	private Statement statement;

	private PageDataDaoPostgres() {
		connection = ConnectionInit.getConnection();
	}

	public static PageDataDaoPostgres getDao() {
		if (inst == null)
			inst = new PageDataDaoPostgres();
		return inst;
	}

	public PageData getPage(String id) {
		PageData data = new PageData();

		try {
			statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select * from pages where id='" + id + "'");
			if (rs.next()) {
				data.setId(rs.getString("id"));
				data.setParentid(rs.getString("parentid"));
				data.setTitle(rs.getString("title"));
				data.setTitle4menu(rs.getString("title4menu"));
				data.setKeywords(rs.getString("keywords"));
				data.setDescription(rs.getString("description"));
				data.setMaintext(rs.getString("maintext"));
			} else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	public ArrayList<PageData> getPagesByParent(String parentid) {
		ArrayList<PageData> pages = new ArrayList<PageData>();
		try {
			statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select * from pages where parentid='"
							+ parentid + "'");
			while (rs.next()) {
				PageData data = new PageData();

				data.setId(rs.getString("id"));
				data.setParentid(rs.getString("parentid"));
				data.setTitle(rs.getString("title"));
				data.setTitle4menu(rs.getString("title4menu"));
				data.setKeywords(rs.getString("keywords"));
				data.setDescription(rs.getString("description"));
				data.setMaintext(rs.getString("maintext"));
				pages.add(data);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return pages;
	}

	public int addPage(PageData p) {

		int result = 0;
		try {
			String query = "insert into pages(id,parentid, title, title4menu,keywords,description,maintext) values (?,?,?,?,?,?,?)";
			PreparedStatement preStatement = connection.prepareStatement(query);
			preStatement.setString(1, p.getId());
			preStatement.setString(2, p.getParentid());
			preStatement.setString(3, p.getTitle());
			preStatement.setString(4, p.getTitle4menu());
			preStatement.setString(5, p.getKeywords());
			preStatement.setString(6, p.getDescription());
			preStatement.setString(7, p.getMaintext());
			result = preStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	public int deletePage(String id) {
		int result = 0;
		try {
			String query = "delete from pages where id = ?";
			PreparedStatement preStatement = connection.prepareStatement(query);
			preStatement.setString(1, id);
			result = preStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	public int updatePage(PageData p) {
		int result = 0;
		try {
			String query = "update pages set title=?,title4menu=?,keywords=?, description=?, maintext=? Where id=?";
			PreparedStatement preStatement = connection.prepareStatement(query);

			preStatement.setString(1, p.getTitle());
			preStatement.setString(2, p.getTitle4menu());
			preStatement.setString(3, p.getKeywords());
			preStatement.setString(4, p.getDescription());
			preStatement.setString(5, p.getMaintext());
			preStatement.setString(6, p.getId());

			result = preStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}
}
