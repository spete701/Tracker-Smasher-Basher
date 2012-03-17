package net.stevenpeterson.tracker;

public class HTMLBean {
	private String title;
	private String stylesheet;
	private String body;
	private String charSet;
	private String docType;
	
	public HTMLBean(){
		this.docType = "<!DOCTYPE html>\n";
		this.charSet = "utf-8";
		this.stylesheet = "default.css";
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStylesheet() {
		return stylesheet;
	}
	public void setStylesheet(String stylesheet) {
		this.stylesheet = stylesheet;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCharSet() {
		return charSet;
	}
	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
}
