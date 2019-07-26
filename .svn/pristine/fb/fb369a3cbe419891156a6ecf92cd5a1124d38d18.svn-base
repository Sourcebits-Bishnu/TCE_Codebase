package com.tce.content.web.lesson;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContentBooksTataResponse {
	private String bookId;

	private String title;

	private String json;

	private String eBookBasePath;

	public ContentBooksTataResponse() {

	}

	public ContentBooksTataResponse(String bookId, String title, String json) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.json = json;
	}

	public ContentBooksTataResponse(String bookId, String title, String json, String eBookBasePath) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.json = json;
		this.eBookBasePath = eBookBasePath;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String geteBookBasePath() {
		return eBookBasePath;
	}

	public void seteBookBasePath(String eBookBasePath) {
		this.eBookBasePath = eBookBasePath;
	}

}
