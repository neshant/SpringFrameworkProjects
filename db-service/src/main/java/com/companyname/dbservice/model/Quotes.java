package com.companyname.dbservice.model;

import java.util.List;

public class Quotes {

	public Quotes() {
		// TODO Auto-generated constructor stub
	}

	public Quotes(String userName, List<String> quotes) {
		super();
		this.userName = userName;
		this.quotes = quotes;
	}

	private String userName;
	private List<String> quotes;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}

}
