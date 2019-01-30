package com.training.bean;

public class AddCategoryBean {
	private String categoryname;
	private String metatagtitle;
	
	public AddCategoryBean(){
		
	}
	public AddCategoryBean(String categoryname, String metatagtitle){
		this.categoryname=categoryname;
		this.metatagtitle=metatagtitle;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getMetatagtitle() {
		return metatagtitle;
	}
	public void setMetatagtitle(String metatagtitle) {
		this.metatagtitle = metatagtitle;
	}

}
