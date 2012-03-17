package net.stevenpeterson.tracker;

public class HTMLBeanDecorator {
	private HTMLBean htmlData;

	private HTMLBeanDecorator(HTMLBean htmlData) {
		super();
		this.htmlData = htmlData;
	}

	public static HTMLBeanDecorator htmlFactory(HTMLBean htmlData) {
		return new HTMLBeanDecorator(htmlData);
	}

	public String getHTML() {
		StringBuilder sb = new StringBuilder();
		sb.append(getDoctype());
		sb.append(openHTMLTag());
		sb.append(getHead());
		sb.append(getBody());
		sb.append(closeHTMLTag());
		return sb.toString();
	}

	public String getDoctype() {
		return "<!DOCTYPE html>\n";
	}

	public String openHTMLTag() {
		return "<html lang=\"en\">\n";
	}

	public String closeHTMLTag() {
		return "</html>";
	}

	public String getHead() {
		return "<head>\n" + formatCharset() + getStyleSheetLink()
				+ getTitleSetting() + "</head>\n";
	}

	private String getTitleSetting() {
		return "<title>" + htmlData.getTitle() + "</title>\n";
	}

	public String formatCharset() {
		return "<meta charset=\"" + this.htmlData.getCharSet() + "\" />\n";
	}

	public String getStyleSheetLink() {
		return "<link type=\"text/css\" href=\""
				+ this.htmlData.getStylesheet() + "\" rel=\"stylesheet\"/>\n";
	}

	public String getBody() {
		return "<body>\n" + this.htmlData.getBody() + "\n<body>\n";
	}

}
