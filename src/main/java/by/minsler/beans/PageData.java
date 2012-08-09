package by.minsler.beans;

import java.io.Serializable;

public class PageData implements Serializable {

	private String id;
	private String parentid;
	private String title;
	private String title4menu;
	private String keywords;
	private String description;
	private String maintext;

	public PageData() {

	}

	public String getMaintext() {
		return maintext;
	}

	public void setMaintext(String maintext) {
		this.maintext = maintext;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getTitle4menu() {
		return title4menu;
	}

	public void setTitle4menu(String title4menu) {
		this.title4menu = title4menu;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return (id != null ? id.hashCode() : 0);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PageData)) {
			return false;
		}
		PageData p = (PageData) obj;
		return equalsHelp(this.id, p.id)
				&& equalsHelp(this.parentid, p.parentid)
				&& equalsHelp(this.title, p.title)
				&& equalsHelp(this.title4menu, p.title4menu)
				&& equalsHelp(this.keywords, p.keywords)
				&& equalsHelp(this.description, p.description)
				&& equalsHelp(this.maintext, p.maintext);

	}

	private boolean equalsHelp(Object obj1, Object obj2) {
		if (obj1 == obj2) {
			return true;
		}
		if (obj1 == null || obj2 == null) {
			return false;
		}
		if (obj1.getClass() == obj2.getClass()) {
			return obj1.equals(obj2);
		}
		return false;
	}
}